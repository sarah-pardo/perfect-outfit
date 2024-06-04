package depaul.edu.OrderProcessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import depaul.edu.Products.Product;
import depaul.edu.Util.Paths;

public class CartPersistenceService {

	@SuppressWarnings("unchecked")
	public void loadCart(String username, Cart cart) {
		File cartFile = new File(Paths.USER_CART_FOLDER_PATH + username + "_cart.dat");
		if (cartFile.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(cartFile))) {
				Object stream = in.readObject();
				if(stream instanceof ArrayList<?>) {
					ArrayList<?> unknownTypelist = (ArrayList<?>) stream;
					 if (!unknownTypelist.isEmpty() && unknownTypelist.get(0) instanceof Product) {
		                    ArrayList<Product> products = (ArrayList<Product>) unknownTypelist;
		                    cart.setProducts(products);
		                } else {
		                    System.out.println("User's cart file does not contain valid product data.");
		                }
				}else {
					System.out.println("User's cart file was incorrect type.");
				}
	        } catch (FileNotFoundException e) {
				System.out.println("User's cart file was not found!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error loading user's cart file!");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Product class not found!");
				e.printStackTrace();
			}
			catch (ClassCastException e) {
	            System.out.println("Type mismatch when reading user's cart file!");
	            e.printStackTrace();
	        }
		}
	}
	
	public void saveCart(String username, Cart cart) {
		if (!cart.getProducts().isEmpty()) {
			File cartFile = new File(Paths.USER_CART_FOLDER_PATH + username + "_cart.dat");
			if (!cartFile.exists()) {
	            try {
	                cartFile.createNewFile();
	            } catch (IOException e) {
	                System.out.println("Error creating user's cart file!");
	                e.printStackTrace();
	                return;
	            }
	        }
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Paths.USER_CART_FOLDER_PATH + username + "_cart.dat"))) {
		        out.writeObject(cart.getProducts());
		    } catch (FileNotFoundException e) {
		    	System.out.println("User's cart file was not found!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error writing to user's cart file!");
				e.printStackTrace();
			}
		}
	}
	
	public void clearCart(String username, Cart cart) {
		cart.setProducts(new ArrayList<Product>());
		File cartFile = new File(Paths.USER_CART_FOLDER_PATH + username + "_cart.dat");
		if (cartFile.exists()) {
			cartFile.delete();
		}
	}
}
