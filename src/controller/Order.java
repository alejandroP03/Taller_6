package controller;

import java.util.ArrayList;

public class Order <T extends Product>{
    private static int numOfOrders = 0;
    private int orderId;
    private String clientName;
    private String clientAddress;

    private ArrayList<T> orderItems;

    public Order(String clientName, String clientAddress) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        numOfOrders ++;
        this.orderId = numOfOrders;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void addProduct(T newItem) {
        orderItems.add(newItem);
    }

}
