package depaul.edu.Authentication;

import java.util.ArrayList;
import java.util.function.Predicate;

import depaul.edu.Util.InputHelper;
import depaul.edu.Util.MenuConstants;

public class AuthenticationService {
	private InputHelper inputHelper;

	public AuthenticationService(InputHelper inputHelper) {
		this.inputHelper = inputHelper;
	}
	
	public User authenticate(){
		ArrayList<String> userNames = UserFileReaderWriter.loadUserNames();
		Predicate<String> isValidNewUserName = s -> s.matches("[a-zA-Z]+") && !userNames.contains(s);
		Predicate<String> isValidExistingUserName = s -> s.matches("[a-zA-Z]+") && userNames.contains(s);
        boolean authenticated = false;
        while (!authenticated) {
            int option = inputHelper.getIntFromStringInput(MenuConstants.AUTHENTICATION_PROMPT);
            switch (option) {
                case 1:
                    String newUserName = inputHelper.getStringInput("Enter a new username. \n"
                    		+ "The username can only contain letters (no spaces, numbers or special characters).\n"
                    		+ "Username must not be taken. \n"
                    		+ "Usernames are case sensitive", isValidNewUserName);
                	UserFileReaderWriter.addNewUserToFile(newUserName);
                    authenticated = true;
                    System.out.println("Welcome, " + newUserName + "!");
                	return new User(newUserName);
                case 2:
                	String userName = inputHelper.getStringInput("Enter your username (case sensitive)", isValidExistingUserName);
                    authenticated = true;
                    System.out.println("Welcome back, " + userName + "!");
                    return new User(userName);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
		return null;
	}		
}
