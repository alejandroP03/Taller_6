package model.uploaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import model.products.DrinksProduct;

public class DrinksUploader extends GenericUploader {
    private ArrayList<DrinksProduct> drinksProducts;
    private HashMap<String, DrinksProduct> drinkProductsSearch;

    public DrinksUploader(File document_name) {
        super(document_name);
        drinksProducts = new ArrayList<DrinksProduct>();
        drinkProductsSearch = new HashMap<String, DrinksProduct>();
    }

    @Override
    public void putEntry(String[] elemsLine) {
        String name = elemsLine[0];
        int basisCost = Integer.parseInt(elemsLine[1]);
        DrinksProduct new_product = new DrinksProduct(name, basisCost);
        drinksProducts.add(new_product);
        drinkProductsSearch.put(name, new_product);

    }

    public ArrayList<DrinksProduct> getProduct() {
        return drinksProducts;
    }

    public HashMap<String, DrinksProduct> getProducts_search() {
        return drinkProductsSearch;
    }
}
