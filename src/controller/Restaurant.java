package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {
    ArrayList<Order<Product>> previousOrders;
    Order<Product> activeOrder;

    private final String billFilePath = this.getClass().getResource("/data/facturas.txt").getPath();
    private final File billFile = new File(billFilePath);

    public Restaurant() {
        this.previousOrders = new ArrayList<Order<Product>>();
    }

    public void startOrder(String customerName, String customerAddress) {
        this.activeOrder = new Order<Product>(customerName, customerAddress);
    }

    public boolean hasAlreadyOrdered() {
        for (Order<Product> order : previousOrders) {
            if (this.activeOrder.getOrderItems().equals(order.getOrderItems()))
                return true;
        }
        return false;

    }

    public void closeAndSaveOrder() throws IOException {
        Bill orderBill = new Bill(activeOrder);
        orderBill.saveBill(billFile);
        previousOrders.add(this.activeOrder);
        this.activeOrder = null;
    }

    public Order<Product> getOpenOrder() {
        return this.activeOrder;
    }

    public Order<Product> getPreviousOrder(int id) {
        return previousOrders.get(id - 1);
    }

}
