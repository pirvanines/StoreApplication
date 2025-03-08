package Objects;

import java.awt.image.BufferedImage;
import java.net.URL;

public class Product {

    private int id;
    private String image;
    private String title;
    private String category;
    private double price;
    private String currency;
    private String description;
    private Rating rating;

    private boolean favourite;
    private boolean shoppingCart;

    public Product(int id, double price, String description,String title, String category, String img, String currency,  Rating rating) {
        this.image = img;
        this.category = category;
        this.price = price;
        this.currency = currency;
        this.description = description;
        this.rating = rating;
        this.favourite = false;
        this.shoppingCart = false;
        this.title = title;
    }

    private void WriteImageInMemory()
    {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public boolean isShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(boolean shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
