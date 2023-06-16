package tekma.app.kurdistan.handlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import tekma.app.kurdistan.models.Product;

public class DbHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "imageDB";

    public DbHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ProductS_TABLE = "CREATE TABLE IF NOT EXISTS " + Product.TABLE_PRODUCTS +
                "(" + Product.KEY_ID + " INTEGER PRIMARY KEY,"
                + Product.KEY_IMAGE + " IMAGE,"
                + Product.KEY_NAME + " TEXT,"
                + Product.KEY_PRICE + " TEXT,"
                + Product.KEY_DATE + " TEXT)";

        db.execSQL(CREATE_ProductS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Product.TABLE_PRODUCTS);
        onCreate(db);
    }

    public void addProduct(Product product) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Product.KEY_IMAGE, product.getImage());
        values.put(Product.KEY_NAME, product.getName());
        values.put(Product.KEY_PRICE, product.getPrice());
        values.put(Product.KEY_DATE, product.getDate());

        db.insert(Product.TABLE_PRODUCTS, null, values);

        db.close();
    }

    public Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Product.TABLE_PRODUCTS, new String[]{
                        Product.KEY_ID,  Product.KEY_IMAGE, Product.KEY_NAME, Product.KEY_PRICE, Product.KEY_DATE}, Product.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        assert cursor != null;
        Product product = new Product(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                cursor.getString(2),
                Long.parseLong(cursor.getString(3)),
                cursor.getString(4));

        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Product.TABLE_PRODUCTS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setImage(Integer.parseInt(cursor.getString(1)));
                product.setName(cursor.getString(2));
                product.setPrice(Long.parseLong(cursor.getString(3)));
                product.setDate(cursor.getString(4));
                productList.add(product);
            } while (cursor.moveToNext());
        }

        return productList;
    }


    public int getProductsCount() {
        String countQuery = "SELECT * FROM " + Product.TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

}
