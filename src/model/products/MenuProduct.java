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
        return null;
    };

    public int getPrice() {
        return 0;
    };


    public String generateBillTxt() {
        return null;
    };
}
