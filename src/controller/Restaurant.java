package controller;

import java.util.ArrayList;

import model.products.ComboProduct;
import model.products.IngredientProduct;
import model.products.MenuProduct;

public class Restaurant {
    ArrayList<Order<Product>> previousOrders;
    Order<Product> activeOrder;

    // Data
    private ArrayList<ComboProduct> comboProducts;
    private ArrayList<MenuProduct> menuProducts;
    private ArrayList<IngredientProduct> ingredientsProducts;

    public Restaurant(ArrayList<ComboProduct> comboProducts, ArrayList<MenuProduct> menuProducts,
            ArrayList<IngredientProduct> ingredientsProducts) {
        this.comboProducts = comboProducts;
        this.menuProducts = menuProducts;
        this.ingredientsProducts = ingredientsProducts;
    }

    public void startOrder(String customerName, String customerAddress) {
        this.activeOrder = new Order<Product>(customerName, customerAddress);
    }

    public void closeAndSaveOrder() {
        previousOrders.add(this.activeOrder);
        this.activeOrder = null;
    }

    public Order<Product> getOpenOrder() {
        return this.activeOrder;
    }

    public Order<Product> getPreviousOrder(int id) {
        return previousOrders.get(id);
    }

}
