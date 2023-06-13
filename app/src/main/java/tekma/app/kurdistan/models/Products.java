package tekma.app.kurdistan.models;

import java.io.Serializable;

public class Products implements Serializable {
    private int image;
    private String name;
    private long price;
    private String date;
    private String dateAge;

    public Products() {
    }

    public Products(String name, long price, String date, String dateAge) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.dateAge = dateAge;
    }

    public Products(int image, String name, long price, String date, String dateAge) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.date = date;
        this.dateAge = dateAge;
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
