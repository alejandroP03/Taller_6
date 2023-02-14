package model.products;

import java.util.ArrayList;

import controller.Product;

public class CustomProduct implements Product{
    private Product baseProduct;
    private ArrayList<Product> addedProducts;
    private ArrayList<Product> deletedProducts;

    public CustomProduct(Product baseProduct) {

    }

    public String getName() {
        return null;
    };

    public int getPrice() {
        return 0;
    };


    public String generateBillTxt() {
        return null;
    };
}
