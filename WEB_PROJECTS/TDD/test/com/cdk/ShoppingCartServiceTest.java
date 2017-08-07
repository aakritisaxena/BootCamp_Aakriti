package com.cdk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static com.sun.deploy.config.JREInfo.clear;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ShoppingCartServiceTest {


    ShoppingCartService shoppingCartService = null;

    @Before
    public void init() {
        shoppingCartService = new ShoppingCartService();
    }

    @After
    public void clean() {
        shoppingCartService = null;
    }


    @Test
    public void testAddItem() {
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        int initialCartSize = shoppingCartService.countItems();
        shoppingCartService.addItem(product);
        int currentCartSize = shoppingCartService.countItems();
        assertEquals(1, (currentCartSize - initialCartSize));
    }


    @Test
    public void testAddFourItem() {
        Product product1 = new Product(100L, "Laptop", 2000.00, 1);
        Product product2 = new Product(200L, "Mobile", 1500.00, 1);
        Product product3 = new Product(300L, "Nano Car", 100000.00, 1);
        shoppingCartService.addItem(product1);
        shoppingCartService.addItem(product2);
        shoppingCartService.addItem(product2);
        shoppingCartService.addItem(product3);
        assertEquals(4,shoppingCartService.countItems() );
    }




    @Test(expected = ItemNotFoundException.class)
    public void testRemoveNotExistentItem() throws ItemNotFoundException {
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        shoppingCartService.addItem(product);
        shoppingCartService.removeItem(200L);
    }

    @Test
    public void testRemoveItem() {
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        shoppingCartService.addItem(product);
        try {
            shoppingCartService.removeItem(100L);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(0, shoppingCartService.countItems());
    }


    @Test
    public void testCountItems() {
        assertEquals(0, shoppingCartService.countItems());
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        shoppingCartService.addItem(product);
        assertEquals(1, shoppingCartService.countItems());
    }

    @Test
    public void testCorrectProductAdded() {
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        shoppingCartService.addItem(product);
        Collection<Product> products = shoppingCartService.showCartDetails();
        Product p = products.iterator().next();
        assertTrue(p.getId()==100L);
        assertTrue(p.getName().equals("Laptop"));
    }


    @Test
    public void testDuplicateItem() {
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        int initialCartSize = shoppingCartService.countItems();
        shoppingCartService.addItem(product);
        shoppingCartService.addItem(product);
        int currentCartSize = shoppingCartService.countItems();
        assertEquals(2, (currentCartSize - initialCartSize));
    }

    @Test
    public void testEmptyCart(){
        int initialCartSize = shoppingCartService.countItems();
        Product product = new Product(100L, "Laptop", 2000.00, 1);
        shoppingCartService.addItem(product);
        shoppingCartService.addItem(product);
        shoppingCartService.emptyCart();
        int finalCartSize= shoppingCartService.countItems();
        assertEquals(0, finalCartSize);
    }

    @Test
    public void testTotalPrice(){
        Product product1 = new Product(100L, "Laptop", 2000.00, 1);
        Product product2 = new Product(101L, "top", 500.00, 1);
        shoppingCartService.addItem(product1);
        shoppingCartService.addItem(product2);
       long price = (long) shoppingCartService.totalPrice();
        assertEquals(2500, price);
     }

}




