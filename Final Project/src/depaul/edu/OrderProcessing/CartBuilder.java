package depaul.edu.OrderProcessing;

import java.util.ArrayList;

import depaul.edu.Products.Product;

public class CartBuilder {
	private Cart cart;
	public CartBuilder() {
		cart = Cart.INSTANCE;
		cart.setProducts(new ArrayList<Product>());
	}
	public CartBuilder addProduct(Product newItem) {
		cart.addProduct(newItem);
		return this;
	}
	public CartBuilder removeProduct(Product itemToRemove) {
		cart.removeProduct(itemToRemove);
		return this;
	}
	public CartBuilder removeProduct(int indexOfItemToRemove) {
		cart.removeProduct(indexOfItemToRemove);
		return this;
	}
	public Cart build() {
		return cart;
	}
}
