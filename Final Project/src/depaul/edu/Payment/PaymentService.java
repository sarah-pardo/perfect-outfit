package depaul.edu.Payment;

import java.util.function.Predicate;

import depaul.edu.OrderProcessing.Cart;
import depaul.edu.OrderProcessing.CartPersistenceService;
import depaul.edu.Util.InputHelper;

public class PaymentService {
	private InputHelper inputHelper;
	private CartPersistenceService cartPersistenceService;
	public PaymentService(InputHelper inputHelper, CartPersistenceService cartPersistenceService) {
		super();
		this.inputHelper = inputHelper;
		this.cartPersistenceService = cartPersistenceService;
	}

	public void checkoutConfirmation(String username, Cart cart) {
        int option = inputHelper.getIntFromStringInput("Enter 1 to confirm cart and proceed to checkout.\n"
        		+ "Enter 0 to go back.");
        switch (option) {
            case 1:
            	processOrder(username, cart);
            	cartPersistenceService.clearCart(username, cart);
            	break;
            case 0:
            	break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
	}
	public void processOrder(String username, Cart cart) {
		Predicate<String> containsOnlyLettersAndPunctuation = s -> s.matches("[a-zA-Z., ]+");
		Predicate<String> isSixteenDigitNumber = s -> s.trim().replaceAll("\\s", "").matches("\\d{16}");
		System.out.println("Follow the prompts to enter your shipping address:");
		int streetNumber = inputHelper.getIntFromStringInput("Street number:");
		String streetName = inputHelper.getStringInput("Street name:", containsOnlyLettersAndPunctuation);
		String city = inputHelper.getStringInput("City:", containsOnlyLettersAndPunctuation);
		String state = inputHelper.getStringInput("State:", containsOnlyLettersAndPunctuation);
		String creditCard = inputHelper.getStringInput("Please enter your 16 digit credit card number:", isSixteenDigitNumber);
		creditCard = creditCard.trim().replaceAll("\\s", "");
		System.out.println("Your order is on its way! Here is the summary:");
		System.out.println(username + "'s order:");
		System.out.println(streetNumber + " " + streetName + "\n" + city + ", " + state);
		System.out.println("Payment method: Credit card XXXX XXXX XXXX " + creditCard.substring(creditCard.length() -4));
		System.out.println(cart.getSummary());
	}
}
