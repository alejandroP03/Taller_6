package model.uploaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import model.products.MenuProduct;

public class MenuProductsUploader extends GenericUploader{
    private ArrayList<MenuProduct> menuProduct;
    private HashMap<String, MenuProduct> menuProductsSearch;

    public MenuProductsUploader(File document_name){
        super(document_name);
        menuProduct = new ArrayList<MenuProduct>();
        menuProductsSearch = new HashMap<String, MenuProduct>();

    }
    
    @Override
    public void putEntry(String[] elemsLine) {
        String name = elemsLine[0];
        int basisCost = Integer.parseInt(elemsLine[1]);
        MenuProduct new_product = new MenuProduct(name, basisCost);
        menuProduct.add(new_product);
        menuProductsSearch.put(name, new_product);
    }

    public ArrayList<MenuProduct> getProduct() {
        return menuProduct;
    }

    public HashMap<String, MenuProduct> getProducts_search() {
        return menuProductsSearch;
    }
}
