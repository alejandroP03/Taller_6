package controller;

import java.io.File;
import java.util.ArrayList;

public class Restaurant {
    ArrayList<Order> previousOrders;
    Order activeOrder;

    //Data
    ArrayList<Product> comboProducts;
    ArrayList<Product> menuProducts;
    ArrayList<Product> ingredientsProducts;

    public Restaurant() {

    }

    public void startOrder(String customerName, String customerAddress) {

    }

    public void closeAndSaveOrder() {
    }

    public Order getOpenOrder() {
        return null;
    }

    public ArrayList<Product> getBasisMenu() {
        return null;
    }

    public ArrayList<Product> getIngredients() {
        return null;
    }

    public void UploadRestaurantInfo(File ingredientsFile, File menuFile, File combosFile) {

    }

    private void uploadIngredients(File ingredientsFile) {

    }

    private void uploadMenu(File menuFile) {

    }

    private void uploadCombos(File comboFile) {

    }
}
