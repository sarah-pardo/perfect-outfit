package depaul.edu.Products;

import java.io.Serializable;

public abstract class Product implements Drawable, Serializable {
	private static final long serialVersionUID = 1L;
	private double price;
	private String name;
	public Product(double price, String name) {
		this.price = price;
		this.name = name;
	}
	@Override
	public abstract void draw();
	@Override
	public String toString() {
		return "$" + price +" "+ name;
	}
	public void print() {
		System.out.println(this.toString());
		draw();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
