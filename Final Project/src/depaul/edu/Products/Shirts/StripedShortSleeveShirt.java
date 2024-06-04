package depaul.edu.Products.Shirts;

import depaul.edu.Products.Product;

public class StripedShortSleeveShirt extends Product{
	public StripedShortSleeveShirt(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "  _____ _____\n"
				+ " /_____V_____\\\n"
				+ "/__|_______|__\\\n"
				+ "   |_______|\n"
				+ "   |_______|");
	}
}

