package depaul.edu.Tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import depaul.edu.OrderProcessing.Cart;
import depaul.edu.OrderProcessing.CartBuilder;
import depaul.edu.Products.Product;
import depaul.edu.Products.Hats.CowboyHat;
import depaul.edu.Products.Shoes.CowboyBoots;

import java.util.List;

public class CartBuilderTest {
    private CartBuilder cartBuilder;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cartBuilder = new CartBuilder();
        product1 = new CowboyHat(10.0, "Product1");
        product2 = new CowboyBoots(20.0, "Product2");
    }

    @Test
    public void testAddProduct() {
        Cart result = cartBuilder.addProduct(product1).build();
        List<Product> products = result.getProducts();
        assertTrue("Product 1 should be added to the cart", products.contains(product1));
    }

    @Test
    public void testRemoveProductByObject() {
        cartBuilder.addProduct(product1);
        Cart result = cartBuilder.removeProduct(product1).build();
        List<Product> products = result.getProducts();
        assertFalse("Product 1 should be removed from the cart", products.contains(product1));
    }

    @Test
    public void testRemoveProductByIndex() {
        cartBuilder.addProduct(product1).addProduct(product2);
        Cart result = cartBuilder.removeProduct(0).build();
        List<Product> products = result.getProducts();
        assertFalse("Product 1 should be removed from the cart", products.contains(product1));
        assertTrue("Product 2 should still be in the cart", products.contains(product2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveProductByInvalidIndex() {
        cartBuilder.addProduct(product1);
        cartBuilder.removeProduct(5).build();
    }
}
