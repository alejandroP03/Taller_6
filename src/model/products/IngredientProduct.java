package model.products;

import controller.Product;

public class IngredientProduct implements Product {
    private String ingredientProductName;
    private int price;

    public IngredientProduct(String ingredientProductName, int price) {
        this.ingredientProductName = ingredientProductName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    };

    public String getName() {
        return ingredientProductName;
    };

    public String generateBillTxt() {
        return String.format("\n*\t\tAdición de %s: %d$", ingredientProductName, price);
    };
}
