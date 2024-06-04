package depaul.edu.OrderProcessing;

import java.util.ArrayList;

import depaul.edu.Products.Product;

public enum Cart {
	INSTANCE;
	private ArrayList<Product> products; 
	public ArrayList<Product> getProducts(){
		return products;
	}; 
	public void setProducts(ArrayList<Product> products){
		this.products = products;
	};
	public double getTotal() {
		double total = 0;
		for (int i=0; i<products.size(); i++) {
			total += products.get(i).getPrice();
		}
		return total;
	}
	public void addProduct(Product newItem) {
		this.products.add(newItem);
	}
	public void removeProduct(Product itemToRemove) {
		this.products.remove(itemToRemove);
	}
	public void removeProduct(int indexOfItemToRemove) {
		this.products.remove(indexOfItemToRemove);
	}
	public boolean isEmpty() {
		return products.size() ==0;
	}
	public String getSummary() {
		String summary = "";
		for(Product product : this.getProducts()) {
			summary += product.toString() + "\n";
		}
		return summary;
	}
}
