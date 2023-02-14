package controller;

import java.util.ArrayList;

public class Restaurant {
    ArrayList<Order> previousOrders;
    Order activeOrder;

    // Data
    ArrayList<Product> comboProducts;
    ArrayList<Product> menuProducts;
    ArrayList<Product> ingredientsProducts;

    public Restaurant(ArrayList<Product> comboProducts, ArrayList<Product> menuProducts,
            ArrayList<Product> ingredientsProducts) {
        this.comboProducts = comboProducts;
        this.menuProducts = menuProducts;
        this.ingredientsProducts = ingredientsProducts;
    }

    public void startOrder(String customerName, String customerAddress) {

    }

    public void closeAndSaveOrder() {
    }

    public Order getOpenOrder() {
        return null;
    }

}
