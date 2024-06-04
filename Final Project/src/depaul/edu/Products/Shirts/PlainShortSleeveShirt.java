package depaul.edu.Products.Shirts;

import depaul.edu.Products.Product;

public class PlainShortSleeveShirt extends Product{
	public PlainShortSleeveShirt(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "  _____ _____\n"
				+ " /     V     \\\n"
				+ "/__|       |__\\\n"
				+ "   |       |\n"
				+ "   |_______|");
	}
}

