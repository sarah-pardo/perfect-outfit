package depaul.edu.Products.Shoes;

import depaul.edu.Products.Product;

public class PlainSneakers extends Product{
	public PlainSneakers(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "   _/  ||  \\_\n"
				+ "  |____||____|\n");
	}
}
