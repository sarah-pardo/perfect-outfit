package depaul.edu.Products.Hats;

import depaul.edu.Products.Product;

public class CowboyHat extends Product{
	public CowboyHat(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "    /\\ /\\\n"
				+ "    | V |  \n"
				+ " (__|___|__)\n");
	}
}
