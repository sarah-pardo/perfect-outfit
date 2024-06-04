package depaul.edu.OrderProcessing;

import depaul.edu.Products.Product;
import depaul.edu.Products.ProductFactory;
import depaul.edu.Products.ProductType;
import depaul.edu.Util.InputHelper;

public class OrderProcessingService {
	private InputHelper inputHelper;
	private CartBuilder cartBuilder;
	public OrderProcessingService(CartBuilder cartBuilder, InputHelper inputHelper) {
		this.inputHelper = inputHelper;
		this.cartBuilder = cartBuilder;
	}
	
	public Cart createCart() {
		return cartBuilder.build();
	}
	
	public void viewCatalog() {
    	System.out.println("Browse the catalog...");
		int catalogNumber = 1;
        for (ProductType product : ProductType.values()) {
        	System.out.println("#"+catalogNumber++);
            Product displayProduct = ProductFactory.getProduct(product);
            displayProduct.print();
            System.out.println();
        }
    }
	
	public void viewCart(Cart cart) {
		if (!cart.isEmpty()) {
			int cartIndex = 1;
			for(Product product : cart.getProducts()) {
				System.out.println("Cart Item #"+cartIndex++);
				product.print();
			}
		}else {
			System.out.println("Your cart is currently empty. \nYou can add products to your cart by entering 1 on the main menu screen.");
		}
	}
	public Cart removeProductFromCart(Cart cart) {
		if(cart.isEmpty()) {
			System.out.println("Your cart is currently empty. \nYou can add products to your cart by entering 1 on the main menu screen.");
			return cartBuilder.build();
		}
		int userChoice = inputHelper.getIntFromStringInput("Please enter a cart item # to remove it from your cart. Enter 0 to go back.");
		if (userChoice == 0) {
			return cartBuilder.build();
		}
		try{
			cartBuilder.removeProduct(userChoice -1);
			System.out.println("Item successfully removed.");
		}catch(Exception ex) {
			System.out.println("Sorry, that is not a valid cart item #.");
		}
		return cartBuilder.build();
	}
	
	public Cart addProductToCart() {
		int userChoice = inputHelper.getIntFromStringInput("Please enter a catalog number to select a product to add to your cart. Enter 0 to go back.");
		if (userChoice == 0) {
			return cartBuilder.build();
		}
		ProductType productType = getProductTypeByOrdinal(userChoice -1);
		if (productType == null) {
			System.out.println("Sorry, that is not a valid catalog number.");
			return cartBuilder.build();
		}
		Product newProduct = ProductFactory.getProduct(productType);
		cartBuilder.addProduct(newProduct);
		System.out.println(newProduct.getName() + " added to cart!");
		return cartBuilder.build();
	}
	
	public ProductType getProductTypeByOrdinal(int ordinal) {
	    for (ProductType product : ProductType.values()) {
	        if (product.ordinal() == ordinal) {
	            return product;
	        }
	    }
	    return null; 
	}
	public double getCartSubTotal(Cart cart) {
		return Math.floor(cart.getTotal() * 100) / 100;
	}
	public double getTotalAfterTaxes(double subtotal) {
	    double total = subtotal * 1.0625;
	    total = Math.floor(total * 100) / 100; 
	    return total;
	}
	public double preCheckoutSummary(Cart cart) {
		if (!cart.isEmpty()) {
			viewCart(cart);
			double subTotal = getCartSubTotal(cart);
			double total = getTotalAfterTaxes(subTotal);
			System.out.println("Subtotal: $"+subTotal+"\n");
			System.out.println("x 6.25% sales tax.\n");
			System.out.println("Total:    $"+total);
			return total;
		}else {
			System.out.println("You cannot check out because your cart is empty!");
			return 0;
		}
	}
}
