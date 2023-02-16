package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bill{
    /*Bill get the bill logic of Order class in order to mantain the one responsability principle
     */
    private Order<Product> billOrder;
    public final static int widthBillText = 120;

    public Bill(Order<Product> billOrder){
        this.billOrder = billOrder;
    }

     private int getNetCostOrder() {
        return this.billOrder.getOrderCost();
    }

    private int getTotalCostOrder() {
        return this.getIVACostOrder() + this.getNetCostOrder();
    }

    private int getIVACostOrder() {
        return (int) (this.billOrder.getOrderCost() * 0.19);
    }

    private String getProductsBill(){
        ArrayList<Product> prodList = billOrder.getOrderItems();
        String productsBill = "";
        for (Product prod : prodList) {
            productsBill += String.format("* %s \n", prod.generateBillTxt());
        }

        return productsBill;
    }

    public String generateBillTxt() {
        return String.format("* Hamburgesería \n* ID: %d \n* Cliente: %s \n* Dirección: %s \n*\n*\n*\n* Pedido: \n%s \n*\n*\n* Precio neto: %d\n* IVA: %d\n* Precio total: %d\n*\n*\n*\n* Gracias por su compra \n*\n*\n*", billOrder.getOrderId(), billOrder.getClientName(), billOrder.getClientAddress(), this.getProductsBill(), getNetCostOrder(), getIVACostOrder(), getTotalCostOrder());
    }

    public void saveBill(File billsFile) throws IOException {
        FileWriter fr = new FileWriter(billsFile);
        fr.append(generateBillTxt());
        fr.close();
    }
}
