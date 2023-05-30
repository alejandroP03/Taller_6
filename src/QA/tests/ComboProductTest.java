package QA.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Product;
import model.products.ComboProduct;
import model.products.MenuProduct;

public class ComboProductTest {
    ComboProduct comboProduct;

    @BeforeEach
    void setUp() {
        comboProduct = new ComboProduct("Combo 1", 0.1f);
    }

    @Test
    void testAddItemInCombo() {
        Product testProd = new MenuProduct("Test", 0);
        comboProduct.addItemInCombo(testProd);
        assertEquals(testProd, comboProduct.getComboItems().get(0));
    }

    @Test
    void generateBillTxtTest() {
        Product testProd = new MenuProduct("Test", 0);
        comboProduct.addItemInCombo(testProd);
        assertEquals("Combo 1 (Test): 0$", comboProduct.generateBillTxt());
    }
}
