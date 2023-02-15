package model.uploaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import controller.Product;
import model.products.MenuProduct;

public class MenuProductsUploader extends GenericUploader{
    private ArrayList<MenuProduct> menuProduct;
    private HashMap<String, Product> menuProductsSearch;

    public MenuProductsUploader(File document_name){
        super(document_name);
        menuProduct = new ArrayList<MenuProduct>();
        menuProductsSearch = new HashMap<String, Product>();

    }
    
    @Override
    public void putEntry(String[] elemsLine) {
        String name = elemsLine[0];
        int basisCost = Integer.parseInt(elemsLine[1].substring(0, elemsLine[1].length() - 1)) / 100;
        MenuProduct new_product = new MenuProduct(name, basisCost);
        menuProduct.add(new_product);
        menuProductsSearch.put(name, new_product);
    }

    public ArrayList<MenuProduct> getProduct() {
        return menuProduct;
    }

    public HashMap<String, Product> getProducts_search() {
        return menuProductsSearch;
    }
}
