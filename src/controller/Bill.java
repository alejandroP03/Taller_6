package controller;

import java.io.File;

public class Bill {
    /*Bill get the bill logic of Order class in order to mantain the one responsability principle
     */
    private Order billOrder;

    public Bill(Order billOrder){
        this.billOrder = billOrder;
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
