package model.products;

import controller.Product;

public class IngredientProduct implements Product{
    private String ingredientProductName;
    private int price;

    public IngredientProduct(String ingredientProductName, int price) {
        this.ingredientProductName = ingredientProductName;
        this.price = price;
    }


    public int getPrice() {
        return 0;
    };

    public String getName() {
        return null;
    };

    public String generateBillTxt() {
        return null;
    };
}
