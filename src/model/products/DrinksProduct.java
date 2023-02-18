package model.products;

import controller.Product;

public class DrinksProduct implements Product{
    private int basisPrice;
    private String drinkProductName;

    public DrinksProduct(String drinkProductName, int basisPrice) {
        this.drinkProductName = drinkProductName;
        this.basisPrice = basisPrice;
    }

    public String getName() {
        return drinkProductName;
    };

    public int getPrice() {
        return basisPrice;
    };

    public String generateBillTxt() {
        return String.format("%s: %d$", drinkProductName, basisPrice);
    };
}
