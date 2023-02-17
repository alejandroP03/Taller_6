package model.products;

import java.util.ArrayList;

import controller.Product;

public class CustomProduct implements Product {
    private Product baseProduct;
    private ArrayList<Product> addedProducts;
    private ArrayList<Product> deletedProducts;

    public CustomProduct(Product baseProduct) {
        this.baseProduct = baseProduct;
        this.addedProducts = new ArrayList<Product>();
        this.deletedProducts = new ArrayList<Product>();
    }

    public String getName() {
        return String.format("%s (modificado)", baseProduct.getName());
    };

    public int getPrice() {
        int additionalPrice = 0;
        for (Product product : addedProducts) {
            additionalPrice += product.getPrice();
        }
        return baseProduct.getPrice() + additionalPrice;
    };

    public void addIngredient(Product addition) {
        addedProducts.add(addition);
    }

    public void removeIngredient(Product item) {
        deletedProducts.add(item);
    }

    public String generateBillTxt() {
        String productNames = "";
        for (Product product : addedProducts) {
            productNames += product.generateBillTxt();
        }
        for (Product product : deletedProducts) {
            productNames += String.format("\n*\t\tSin %s: 0$", product.getName());
        }

        return String.format("%s %s", baseProduct.generateBillTxt(), productNames);
    };
}
