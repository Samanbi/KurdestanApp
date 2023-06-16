package tekma.app.kurdistan.models;

import java.io.Serializable;

public class Product implements Serializable {

    public static final String TABLE_PRODUCTS = "products";
    public static final String KEY_ID = "id";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_DATE = "date";


    private int id;
    private int image;
    private String name;
    private long price;
    private String date;
    private String dateAge;

    public Product() {
    }

    public Product(int id, int image, String name, long price, String date) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public Product(int id, String name, long price, String date, String dateAge) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.dateAge = dateAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateAge() {
        return dateAge;
    }

    public void setDateAge(String dateAge) {
        this.dateAge = dateAge;
    }
}
