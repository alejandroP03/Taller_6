package QA.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.products.MenuProduct;

public class MenuProductTests {
    private MenuProduct testProduct;

    @BeforeEach
    public void setUp() throws Exception {
        this.testProduct = new MenuProduct("Test", 0);
    }

    @Test
    public void generateBillTxtTest() {
        assert (this.testProduct.generateBillTxt().equals("Test: 0$"));
    }

}
