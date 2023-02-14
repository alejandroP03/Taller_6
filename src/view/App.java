package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Order;
import controller.Product;
import controller.Restaurant;
import model.DataHandler;

public class App {
    Restaurant restaurant;
    DataHandler dh;

    public void executeApp() throws NumberFormatException, IOException {
        dh = new DataHandler();
        restaurant = new Restaurant(dh.getCombos(), dh.getMenu(), dh.getIngredients());
        int option;
        do {
            System.out.println("Sistema de manejo de pedidos");
            showMenu();
            option = Integer.parseInt(input("Opción: "));
            executeOption(option);
        } while (option != 0);
        consoleInput.close();
    }

    private void showMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Iniciar nuevo pedido");
        System.out.println("2. Agregar nuevo elemento al pedido");
        System.out.println("3. Cerrar un pedido y guardar la factura");
        System.out.println("4. Consultar la información de un pedido dado su id");
        System.out.println("0. Salir");
    }

    private void executeOption(int option) throws IOException {
        switch (option) {
            case 1:
                startOrder();
                break;
            case 2:
                addProductInOrder();
                break;
            case 3:
                closeAndSaveOrder();
                break;
            case 4:
                getPreviousOrderById();
                break;
        }

    }

    private void startOrder() throws IOException {
        String client = input("Nombre del cliente: ");
        String address = input("Dirección del cliente: ");
        restaurant.startOrder(client, address);
    }

    private void addProductInOrder() throws IOException {
        Order actualOrder = restaurant.getOpenOrder();
        Product newItem = null;
        if (actualOrder != null) {
            actualOrder.addProduct(newItem);
        } else
            System.out.println("No hay ordenes abiertas");
    }

    private void closeAndSaveOrder() {
        if (restaurant.getOpenOrder() != null)
            restaurant.closeAndSaveOrder();
        else
            System.out.println("No hay ordenes abiertas");
    }

    private void getPreviousOrderById() throws NumberFormatException, IOException {
        Integer id = Integer.parseInt(input("Id del pedido: "));
        restaurant.getPreviousOrder(id);
    }

    BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

    private String input(String message) throws IOException {
        System.out.print(message);
        String line = consoleInput.readLine();
        return line;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        App console = new App();
        console.executeApp();

    }
}
