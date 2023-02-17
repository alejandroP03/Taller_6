package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import model.products.ComboProduct;
import model.products.IngredientProduct;
import model.products.MenuProduct;
import model.uploaders.CombosUploader;
import model.uploaders.IngredientsUploader;
import model.uploaders.MenuProductsUploader;

public class DataHandler {
    private ArrayList<ComboProduct> comboProductsList;
    private ArrayList<MenuProduct> menuProductsList;
    private ArrayList<IngredientProduct> ingredientsProductsList;
    private HashMap<String, MenuProduct> menuProductsSearchMap;

    public DataHandler() {
        this.comboProductsList = new ArrayList<ComboProduct>();
        this.menuProductsList = new ArrayList<MenuProduct>();
        this.ingredientsProductsList = new ArrayList<IngredientProduct>();
        this.menuProductsSearchMap = new HashMap<String, MenuProduct>();
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

    public void UploadRestaurantInfo(File ingredientsFile, File menuFile, File combosFile)
            throws FileNotFoundException, IOException {
        uploadIngredients(ingredientsFile);
        uploadMenu(menuFile);
        uploadCombos(combosFile);
    }

    private void uploadIngredients(File ingredientsFile) throws FileNotFoundException, IOException {
        IngredientsUploader ingredients = new IngredientsUploader(ingredientsFile);
        ingredients.accessDocument();
        this.ingredientsProductsList = ingredients.getIngredients();
    }

    private void uploadMenu(File menuFile) throws FileNotFoundException, IOException {
        MenuProductsUploader menu = new MenuProductsUploader(menuFile);
        menu.accessDocument();
        this.menuProductsList = menu.getProduct();
        this.menuProductsSearchMap = menu.getProducts_search();
    }

    private void uploadCombos(File comboFile) throws FileNotFoundException, IOException {
        CombosUploader combos = new CombosUploader(comboFile, menuProductsSearchMap);
        combos.accessDocument();
        this.comboProductsList = combos.getCombo();
    }
}