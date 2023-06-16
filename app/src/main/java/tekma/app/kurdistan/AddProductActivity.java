package tekma.app.kurdistan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import tekma.app.kurdistan.handlers.DbHandler;
import tekma.app.kurdistan.models.Product;

public class AddProductActivity extends AppCompatActivity {

    private MaterialButton btnAdd;
    private TextInputLayout name, phone;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        init();
    }

    private void init() {
        bindViews();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product();
                int imageValue = imageView.getImageAlpha();
                String nameValue = name.getEditText().getText().toString();
                String phoneValue = phone.getEditText().getText().toString();
                product.setImage(imageValue);
                product.setName(nameValue);
                product.setPrice(Long.parseLong(phoneValue));
                @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter =
                        new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                product.setDate(formatter.format(date));

                DbHandler handler = new DbHandler(AddProductActivity.this);
                handler.addProduct(product);
                Snackbar.make(btnAdd.getRootView(), R.string.product_added, BaseTransientBottomBar.LENGTH_LONG).show();
                AddProductActivity.this.finish();
            }
        });
    }

    private void bindViews() {
        btnAdd = findViewById(R.id.btn_add);
        imageView = findViewById(R.id.image_field);
        name = findViewById(R.id.name_field);
        phone = findViewById(R.id.price_field);
    }
}