package controller;

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

}
