package tekma.app.kurdistan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import tekma.app.kurdistan.adapters.ProductAdapter;
import tekma.app.kurdistan.models.Products;

public class MainActivity extends AppCompatActivity {

    private Activity activity;
    private RecyclerView mainRecycler;
    private List<Products> productDataList;
    private boolean checkBackAgan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init(){
        bindViews();
        fillMockDataList();

        mainRecycler.setAdapter(new ProductAdapter(activity, productDataList));
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(layoutManager);

    }

    private void bindViews(){
        mainRecycler = findViewById(R.id.main_recyclerView);
    }

    private void fillMockDataList() {
        productDataList = new ArrayList<>();
        productDataList.add(new Products("برنج", 300000, "1402/3/19", "10 دقیقه قبل"));
        productDataList.add(new Products("روغن", 550000, "1402/3/19", "25 دقیقه قبل" ));
        productDataList.add(new Products("چای", 320000, "1402/3/19", "30 دقیقه قبل" ));
        productDataList.add(new Products("لوبیا", 50000, "1402/2/14", "چند روز پیش" ));
        productDataList.add(new Products("گوشت", 150000, "1402/2/17", "چند روز پیش" ));
        productDataList.add(new Products("شیر", 18000, "1402/1/1", "چند روز پیش" ));
    }

    @Override
    public void onBackPressed() {
        if (checkBackAgan) {
            super.onBackPressed();
            return;
        }
        this.checkBackAgan = true;
        Snackbar snackbar = Snackbar.make(MainActivity.this.getCurrentFocus(), R.string.twice_back, Snackbar.LENGTH_SHORT);
        snackbar.getView().setTranslationY(-135);
        snackbar.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkBackAgan = false;
            }
        }, 2000);

    }
}