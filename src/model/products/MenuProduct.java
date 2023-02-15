package model.products;

import controller.Product;

public class MenuProduct implements Product{
    private int basisPrice;
    private String menuProductName;

    public MenuProduct(String menuProductName, int basisPrice) {
        this.menuProductName = menuProductName;
        this.basisPrice = basisPrice;
    }

    public String getName() {
        return menuProductName;
    };

    public int getPrice() {
        return basisPrice;
    };


    public String generateBillTxt() {
        return null;
    };
}
