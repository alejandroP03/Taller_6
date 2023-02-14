package controller;

import java.io.File;
import java.util.ArrayList;

public class Order {
    private static int numOfOrders;
    private int orderId;
    private String clientName;
    private String clientAddress;

    private ArrayList<Product> orderItems;

    public Order(String clientName, String clientAddress) {
    }

    public int getOrderId() {
        return 0;
    }

    public void addProduct(Product newItem) {

    }

    private int getNetCostOrder() {
        return 0;
    }

    private int getTotalCostOrder() {
        return 0;
    }

    private int getIVACostOrder() {
        return 0;
    }

    private String generateBillTxt() {
        return null;
    }

    public void saveBill(File billsFile) {

    }
}
