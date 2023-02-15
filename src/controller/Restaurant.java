package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Restaurant {
    ArrayList<Order<Product>> previousOrders;
    Order<Product> activeOrder;
    static final File BillFilePath = new File("data/facturas.txt");

    public Restaurant() {
        this.previousOrders = new ArrayList<Order<Product>>();
    }

    public void startOrder(String customerName, String customerAddress) {
        this.activeOrder = new Order<Product>(customerName, customerAddress);
    }

    public void closeAndSaveOrder() throws IOException {
        Bill orderBill = new Bill(activeOrder);
        orderBill.saveBill(BillFilePath);
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
