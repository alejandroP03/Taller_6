package model.products;

import java.util.ArrayList;

import controller.Product;

public class ComboProduct implements Product{
    private float discount;
    private String comboName;
    private ArrayList<Product> comboItems;

    public ComboProduct(String comboName, float discount) {
        this.comboName = comboName;
        this.discount = discount;
        this.comboItems = new ArrayList<Product>();
    }

    public void addItemInCombo(Product itemProduct) {

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
