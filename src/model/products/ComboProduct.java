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
        comboItems.add(itemProduct);
    }

    public int getPrice() {
        int sum = 0;
        for (Product product : comboItems) {
            sum += product.getPrice();
        }
        return (int) (sum * (1 - discount));
    };

    public String getName() {
        return comboName;
    };

    public String generateBillTxt() {
        String productNames = "";
        for (Product product : comboItems) {
            productNames += product.getName() + ", ";
        }
        productNames = productNames.substring(0, productNames.length() - 2);

        return String.format("%s (%s): %d$", this.comboName, productNames, this.getPrice());
    };
}
