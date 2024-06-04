package depaul.edu.Util;

import java.util.Scanner;
import java.util.function.Predicate;

public class InputHelper {
	private Scanner scanner;
	public InputHelper(Scanner scanner) {
		this.scanner = scanner;
	}
	public String getStringInput(String prompt, Predicate<String> validator) {
		String userInput = "";
		while (!validator.test(userInput)) {
			System.out.println(prompt);
			userInput = scanner.nextLine();
		}
		return userInput;
	}
	public int getIntFromStringInput(String prompt) {
		Predicate<String> isInt = s -> {
			try {
				Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		};
		String intInput = getStringInput( prompt, isInt);
		return Integer.parseInt(intInput);
	}
}
