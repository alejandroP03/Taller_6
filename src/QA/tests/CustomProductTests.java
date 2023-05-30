package QA.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.products.CustomProduct;
import model.products.IngredientProduct;
import model.products.MenuProduct;

public class CustomProductTests {
    CustomProduct customProductTest;

    @BeforeEach
    public void setUp() {
        customProductTest = new CustomProduct(new MenuProduct("Test", 0));
    }

    @Test
    public void testAddIngredient() {
        ArrayList<IngredientProduct> ingredients = new ArrayList<IngredientProduct>();
        ingredients.add(new IngredientProduct("Test", 10));
        ingredients.add(new IngredientProduct("Test2", 20));
        ingredients.add(new IngredientProduct("Test3", 30));

        for (IngredientProduct ingredient : ingredients) {
            customProductTest.addIngredient(ingredient);
        }

        assertArrayEquals(ingredients.toArray(), customProductTest.getAddedProducts().toArray());
    }

    @Test
    public void testRemoveIngredient() {
        ArrayList<IngredientProduct> ingredients = new ArrayList<IngredientProduct>();
        ingredients.add(new IngredientProduct("Test", 10));
        ingredients.add(new IngredientProduct("Test2", 20));
        ingredients.add(new IngredientProduct("Test3", 30));

        for (IngredientProduct ingredient : ingredients) {
            customProductTest.removeIngredient(ingredient);
        }

        assertArrayEquals(ingredients.toArray(), customProductTest.getDeletedProducts().toArray());
    }

    @Test
    public void getPriceTest() {
        ArrayList<IngredientProduct> addedIngredients = new ArrayList<IngredientProduct>();
        addedIngredients.add(new IngredientProduct("Test", 10));
        addedIngredients.add(new IngredientProduct("Test2", 20));
        addedIngredients.add(new IngredientProduct("Test3", 30));
        ArrayList<IngredientProduct> deletedIngredients = new ArrayList<IngredientProduct>();
        deletedIngredients.add(new IngredientProduct("Test4", 40));
        deletedIngredients.add(new IngredientProduct("Test5", 50));
        deletedIngredients.add(new IngredientProduct("Test6", 60));

        for (IngredientProduct ingredient : addedIngredients) {
            customProductTest.addIngredient(ingredient);
        }

        for (IngredientProduct ingredient : deletedIngredients) {
            customProductTest.removeIngredient(ingredient);
        }

        assertEquals(60, customProductTest.getPrice());
    }
    
}