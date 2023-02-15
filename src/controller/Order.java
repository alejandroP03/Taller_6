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
        this.orderItems = new ArrayList<T>();
        numOfOrders ++;
        this.orderId = numOfOrders;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public int getOrderCost(){
        int itemsCost = 0;
        for (T item : orderItems) {
            itemsCost += item.getPrice();
        }

        return itemsCost;
    }

    public ArrayList<T> getOrderItems() {
        return orderItems;
    }

    public void addProduct(T newItem) {
        this.orderItems.add(newItem);
    }

}
