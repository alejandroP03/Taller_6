package model.uploaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import controller.Product;
import model.products.ComboProduct;
import model.products.DrinksProduct;
import model.products.MenuProduct;

public class CombosUploader extends GenericUploader {
    private ArrayList<ComboProduct> combos;
    private HashMap<String, MenuProduct> menuProductsSearchMap;
    private HashMap<String, DrinksProduct> drinksProductsSearchMap;

    public CombosUploader(File document_name, HashMap<String, MenuProduct> menuProductsSearchMap,
            HashMap<String, DrinksProduct> drinksProductsSearchMap) {
        super(document_name);
        this.combos = new ArrayList<ComboProduct>();
        this.menuProductsSearchMap = menuProductsSearchMap;
        this.drinksProductsSearchMap = drinksProductsSearchMap;
    }

    @Override
    public void putEntry(String[] elemsLine) {
        String comboName = elemsLine[0];
        float discount = Float.parseFloat(elemsLine[1].substring(0, elemsLine[1].length() - 1)) / 100;
        ComboProduct actualCombo = new ComboProduct(comboName, discount);
        for (int i = 2; i < elemsLine.length; i++) {
            String comboProductName = elemsLine[i];
            Product comboProduct = menuProductsSearchMap.get(comboProductName) != null
                    ? menuProductsSearchMap.get(comboProductName)
                    : drinksProductsSearchMap.get(comboProductName);

            actualCombo.addItemInCombo(comboProduct);
        }

        combos.add(actualCombo);
    }

    public ArrayList<ComboProduct> getCombo() {
        return combos;
    }

}