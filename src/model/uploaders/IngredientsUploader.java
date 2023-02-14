package model.uploaders;

import java.io.File;
import java.util.ArrayList;

import model.products.IngredientProduct;

public class IngredientsUploader extends GenericUploader{
    private ArrayList<IngredientProduct> ingredientsList;

    public IngredientsUploader(File document_name){
        super(document_name);
        this.ingredientsList = new ArrayList<IngredientProduct>();
    }

    @Override
    public void putEntry(String[] elemsLine) {
        String name = elemsLine[0];
        Integer aditionalCost = Integer.parseInt(elemsLine[1]);
        IngredientProduct new_ingredient = new IngredientProduct(name, aditionalCost);
        this.ingredientsList.add(new_ingredient);
    }

    public ArrayList<IngredientProduct> getIngredients() {
        return ingredientsList;
    }

}
