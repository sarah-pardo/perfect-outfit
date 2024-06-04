package depaul.edu.Products.Pants;

import depaul.edu.Products.Product;

public class StraightLegPants extends Product{
	public StraightLegPants(double price, String name) {
		super(price, name);
	}
	private static final long serialVersionUID = 1L;
	@Override
	public void draw() {
		System.out.println(""
				+ "   |   °   |\n"
				+ "   |   |   |\n"
				+ "   |   |   |\n"
				+ "   |   |   |\n"
				+ "   |   |   |\n"
				+ "   |   |   |\n"
				+ "   |___|___|");
	}
}

