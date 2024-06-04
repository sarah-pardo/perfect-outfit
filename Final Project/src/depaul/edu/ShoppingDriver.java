package depaul.edu;

import java.util.Scanner;
import depaul.edu.Authentication.AuthenticationService;
import depaul.edu.Authentication.User;
import depaul.edu.Util.InputHelper;
import depaul.edu.Util.MenuConstants;
import depaul.edu.OrderProcessing.Cart;
import depaul.edu.OrderProcessing.CartBuilder;
import depaul.edu.OrderProcessing.CartPersistenceService;
import depaul.edu.OrderProcessing.OrderProcessingService;
import depaul.edu.Payment.PaymentService;
import depaul.edu.Products.Drawable;

public class ShoppingDriver implements Drawable{
	private AuthenticationService authenticationService;
	private CartPersistenceService cartPersistenceService;
	private OrderProcessingService orderProcessingService;
	private PaymentService paymentService;
	private Scanner scanner;
	private InputHelper inputHelper;
	private CartBuilder cartBuilder;
	
	public ShoppingDriver() {
	    scanner = new Scanner(System.in);
	    inputHelper = new InputHelper(scanner);
	    authenticationService = new AuthenticationService(inputHelper);
	    cartPersistenceService = new CartPersistenceService();
	    cartBuilder = new CartBuilder();
	    orderProcessingService = new OrderProcessingService(cartBuilder, inputHelper);
	    paymentService = new PaymentService(inputHelper, cartPersistenceService);
	}
	
	public static void main(String[] args) {
		ShoppingDriver store = new ShoppingDriver();
		store.draw();
		User user = store.authenticationService.authenticate();
		Cart cart = store.orderProcessingService.createCart();
		store.cartPersistenceService.loadCart(user.getName(), cart);
        boolean exit = false;
        while (!exit) {
            int option = store.inputHelper.getIntFromStringInput(MenuConstants.DRIVER_PROMPT);
            switch (option) {
            	case 0:
	            	exit = true;
	            	System.out.println("Saving your cart information...");
	            	store.cartPersistenceService.saveCart(user.getName(), cart);
	            	System.out.println("Come again soon!");
	            	break;
            	case 1:
                	store.orderProcessingService.viewCatalog();
                	store.orderProcessingService.addProductToCart();
	            	break;
            	case 2:
            		store.orderProcessingService.viewCart(cart);
                    break;
            	case 3:
            		store.orderProcessingService.removeProductFromCart(cart);
            		break;
            	case 4:
            		double total = store.orderProcessingService.preCheckoutSummary(cart);
            		if(total > 0) {
            			store.paymentService.checkoutConfirmation(user.getName(), cart);
            		}
            		break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
	}

	@Override
	public void draw() {
		System.out.println(""
				+ "* * * * * * * * * \n"
				+ "*|              |*\n"
				+ "*|  Welcome to  |*\n"
				+ "*|    PERFECT   |*\n"
				+ "*|    OUTFIT    |*\n"
				+ "*|______________|*\n"
				+ "* * * * * * * * * ");
		
	}
}

