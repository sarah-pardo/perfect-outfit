package depaul.edu.Products.Hats;

import depaul.edu.Products.Product;

public class TopHat extends Product{
	public TopHat(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "     _____\n"
				+ "     |   |\n"
				+ "     |   |\n"
				+ "   __|___|__\n");
	}
}

