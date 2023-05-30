package model.uploaders;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import QA.exceptions.RepeatedIngredientException;
import model.products.IngredientProduct;

public class IngredientsUploader extends GenericUploader {
    private Map<String, IngredientProduct> ingredientsMap;

    public IngredientsUploader(File document_name) {
        super(document_name);
        ingredientsMap = new HashMap<String, IngredientProduct>();
    }

    @Override
    public void putEntry(String[] elemsLine) {

        String name = elemsLine[0];
        Integer aditionalCost = Integer.parseInt(elemsLine[1]);
        if (!ingredientsMap.containsKey(name)) {
            IngredientProduct new_ingredient = new IngredientProduct(name, aditionalCost);
            ingredientsMap.put(name, new_ingredient);
        } else {
            throw new RepeatedIngredientException(
                    "El ingrediente " + name + " ya existe, modifique el archivo y reinicie la aplicacion");
        }
    }

    public ArrayList<IngredientProduct> getIngredients() {
        return new ArrayList<IngredientProduct>(ingredientsMap.values());
    }

}
