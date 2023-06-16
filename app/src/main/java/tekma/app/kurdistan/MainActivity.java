package tekma.app.kurdistan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import tekma.app.kurdistan.adapters.ProductAdapter;
import tekma.app.kurdistan.handlers.DbHandler;
import tekma.app.kurdistan.models.Product;

public class MainActivity extends AppCompatActivity {

    private Activity activity;
    private FloatingActionButton fab;
    private RecyclerView mainRecycler;
    private List<Product> productDataList;
    private boolean checkBackAgan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        bindViews();

        fab.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddProductActivity.class)));

    }

    private void loadProducts() {
        DbHandler handler = new DbHandler(this);
        productDataList = handler.getAllProducts();

        fillMockDataList();

        mainRecycler.setAdapter(new ProductAdapter(activity, productDataList));
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);

    }

    private void fillMockDataList() {
        productDataList.add(new Product(1, "روغن", 550000, "1402/3/19", "25 دقیقه قبل"));
        productDataList.add(new Product(2, "گوشت", 150000, "1402/2/17", "چند روز پیش"));
        productDataList.add(new Product(3, "شیر", 18000, "1402/1/1", "چند روز پیش"));
    }

    private void bindViews() {
        mainRecycler = findViewById(R.id.main_recyclerView);
        fab = findViewById(R.id.fab_add);
    }


    @Override
    public void onBackPressed() {
        if (checkBackAgan) {
            super.onBackPressed();
            return;
        }
        this.checkBackAgan = true;
        Toast.makeText(this, R.string.twice_back, Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> checkBackAgan = false, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }
}