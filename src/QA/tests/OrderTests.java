package QA.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import QA.exceptions.ExceededOrderPrice;
import controller.Bill;
import controller.Order;
import controller.Product;
import controller.Restaurant;
import model.products.MenuProduct;

public class OrderTests {
    private Restaurant restaurant;
    private Order<Product> oldestOrder;
    private MenuProduct testProduct = new MenuProduct("Test", 0);

    @BeforeEach
    public void setUp() throws Exception {
        this.restaurant = new Restaurant();
        this.restaurant.startOrder("Test", "Test");
        this.restaurant.getOpenOrder().addProduct(testProduct);
        this.oldestOrder = this.restaurant.getOpenOrder();
        this.restaurant.closeAndSaveOrder();
    }

    @Test
    public void addProductsTest() {
        this.restaurant.startOrder("Test", "Test");
        this.restaurant.getOpenOrder().addProduct(testProduct);
        assertEquals("The order should have 1 product", 1, this.restaurant.getOpenOrder().getOrderItems().size());
    }

    @Test
    public void conserveOrderTest() {
        assertEquals("The order should be conserved", oldestOrder,
                this.restaurant.getPreviousOrder(oldestOrder.getOrderId()));
    }

    @Test
    public void hasAlreadyOrderedTest() {
        this.restaurant.startOrder("TestCompare", "TestCompare");
        this.restaurant.getOpenOrder().addProduct(testProduct);
        assertEquals("The order should be conserved", true, this.restaurant.hasAlreadyOrdered());
    }

    @Test
    public void getOrderCostTest() {
        assertEquals("The order cost should be 0", 0, oldestOrder.getOrderCost());
    }

    @Test
    public void getBillTest() {
        Bill bill = new Bill(oldestOrder);
        assertEquals(
                "* Hamburgesería \n* ID: 1 \n* Cliente: Test \n* Dirección: Test \n*\n*\n*\n* Pedido: \n* Test: 0$ \n \n*\n*\n* Precio neto: 0\n* IVA: 0\n* Precio total: 0\n*\n*\n*\n* Gracias por su compra \n*\n*\n*",
                bill.generateBillTxt());
    }

    @Test
    public void maxOrderException() {
        MenuProduct testProduct = new MenuProduct("Test", 150001);
        this.restaurant.startOrder("TestCompare", "TestCompare");
        assertThrows(ExceededOrderPrice.class, () -> {
            this.restaurant.getOpenOrder().addProduct(testProduct);
        });
    }

    @AfterEach
    public void tearDown() throws Exception {
        this.restaurant = null;
        this.oldestOrder = null;
        Order.deleteIdsCount();
    }

}
