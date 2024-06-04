package depaul.edu.Products.Hats;

import depaul.edu.Products.Product;

public class BaseballHat extends Product{
	public BaseballHat(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "      ___\n"
				+ "   __/___\\\n");
	}
}
