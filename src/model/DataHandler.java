package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import model.products.ComboProduct;
import model.products.DrinksProduct;
import model.products.IngredientProduct;
import model.products.MenuProduct;
import model.uploaders.CombosUploader;
import model.uploaders.DrinksUploader;
import model.uploaders.IngredientsUploader;
import model.uploaders.MenuProductsUploader;

public class DataHandler {
    private ArrayList<ComboProduct> comboProductsList;
    private ArrayList<MenuProduct> menuProductsList;
    private ArrayList<IngredientProduct> ingredientsProductsList;
    private HashMap<String, MenuProduct> menuProductsSearchMap;
    private ArrayList<DrinksProduct> drinksProductsList;
    private HashMap<String, DrinksProduct> drinkProductsSearchMap;

    public DataHandler() {
        this.comboProductsList = new ArrayList<ComboProduct>();
        this.menuProductsList = new ArrayList<MenuProduct>();
        this.ingredientsProductsList = new ArrayList<IngredientProduct>();
        this.menuProductsSearchMap = new HashMap<String, MenuProduct>();
        this.drinksProductsList = new ArrayList<DrinksProduct>();
        this.drinkProductsSearchMap = new HashMap<String, DrinksProduct>();
    }

    public ArrayList<MenuProduct> getMenu() {
        return menuProductsList;
    }

    public ArrayList<IngredientProduct> getIngredients() {
        return ingredientsProductsList;
    }

    public ArrayList<ComboProduct> getCombos() {
        return comboProductsList;
    }

    public ArrayList<DrinksProduct> getDrinks() {
        return drinksProductsList;
    }

    public void UploadRestaurantInfo(File ingredientsFile, File menuFile, File combosFile, File drinksFile)
            throws FileNotFoundException, IOException {
        uploadIngredients(ingredientsFile);
        uploadMenu(menuFile);
        uploadDrinks(drinksFile);
        uploadCombos(combosFile);
        // agregar la relacion de composicion
    }

    private void uploadIngredients(File ingredientsFile) throws FileNotFoundException, IOException {
        try {
            IngredientsUploader ingredients = new IngredientsUploader(ingredientsFile);
            ingredients.accessDocument();
            this.ingredientsProductsList = ingredients.getIngredients();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void uploadMenu(File menuFile) throws FileNotFoundException, IOException {
        MenuProductsUploader menu = new MenuProductsUploader(menuFile);
        menu.accessDocument();
        this.menuProductsList = menu.getProduct();
        this.menuProductsSearchMap = menu.getProducts_search();
    }

    private void uploadDrinks(File drinksFile) throws FileNotFoundException, IOException {
        DrinksUploader drinks = new DrinksUploader(drinksFile);
        drinks.accessDocument();
        this.drinksProductsList = drinks.getProduct();
        this.drinkProductsSearchMap = drinks.getProducts_search();
    }

    private void uploadCombos(File comboFile) throws FileNotFoundException, IOException {
        CombosUploader combos = new CombosUploader(comboFile, menuProductsSearchMap, drinkProductsSearchMap);
        combos.accessDocument();
        this.comboProductsList = combos.getCombo();
    }
}