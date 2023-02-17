package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controller.Bill;
import controller.Order;
import controller.Product;
import controller.Restaurant;
import model.DataHandler;
import model.products.CustomProduct;
import model.products.IngredientProduct;
import model.products.MenuProduct;

public class App {
    private Restaurant restaurant;
    private DataHandler dh;

    public void executeApp() throws NumberFormatException, IOException {
        dh = new DataHandler();
        uploadInfo();
        restaurant = new Restaurant();
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

    private Product productSelection(int typeOfProduct) throws IOException {
        switch (typeOfProduct) {
            case 1:
                listProducts(dh.getCombos());
                return selectProd(dh.getCombos());
            case 2:
                listProducts(dh.getMenu());
                return selectProd(dh.getMenu());
        }

        return null;
    }

    private void listProducts(ArrayList<? extends Product> prods) throws NumberFormatException, IOException {
        int i = 0;
        for (Product prod : prods) {
            String addTxt = (prod instanceof IngredientProduct) ? "Adición de" : "";
            System.out.println(String.format("%d. %s %s", ++i, addTxt, prod.getName()));
        }
    }

    private Product selectProd(ArrayList<? extends Product> prods) throws IOException {
        int prodSelection = Integer.parseInt(input("Producto seleccionado: ")) - 1;

        Product selection = prods.get(prodSelection);

        if (selection instanceof MenuProduct) {

            if (input("¿Desea modificar el pedido? (S/n): ").equals(new String("S"))) {
                CustomProduct customSelection = new CustomProduct(selection);
                if (input("¿Desea adicionar ingredientes? (S/n): ").equals(new String("S"))) {
                    listProducts(dh.getIngredients());
                    int ingredInd = Integer.parseInt(input("Selleccione un ingrediente: ")) - 1;
                    customSelection.addIngredient(dh.getIngredients().get(ingredInd));
                }
                if (input("¿Desea quitar ingredientes? (S/n): ").equals(new String("S"))) {
                    listProducts(dh.getIngredients());
                    int ingredInd = Integer.parseInt(input("Selleccione un ingrediente: "));
                    customSelection.removeIngredient(dh.getIngredients().get(ingredInd));
                }
                return customSelection;
            }

        }
        return selection;
    }

    private void uploadInfo() throws FileNotFoundException, IOException {
        File ingrFile = new File("data/ingredientes.txt");
        File comboFile = new File("data/combos.txt");
        File meunFile = new File("data/menu.txt");

        dh.UploadRestaurantInfo(ingrFile, meunFile, comboFile);
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
        Order<Product> actualOrder = restaurant.getOpenOrder();
        if (actualOrder != null) {
            System.out.println("1. Combos \n2. Productos del menu");
            int typeOfProd = Integer.parseInt(input("Selleccione un tipo de producto: "));
            Product selectedProd = productSelection(typeOfProd);

            actualOrder.addProduct(selectedProd);
        } else
            System.out.println("No hay ordenes abiertas");
    }

    private void closeAndSaveOrder() throws IOException {
        if (restaurant.getOpenOrder() != null)
            restaurant.closeAndSaveOrder();
        else
            System.out.println("No hay ordenes abiertas");
    }

    private void getPreviousOrderById() throws NumberFormatException, IOException {
        Integer id = Integer.parseInt(input("Id del pedido: "));
        Order<Product> queryOrder = restaurant.getPreviousOrder(id);
        Bill orderInfo = new Bill(queryOrder);
        System.out.println(orderInfo.generateBillTxt());
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
