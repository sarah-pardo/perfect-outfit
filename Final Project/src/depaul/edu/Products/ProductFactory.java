package depaul.edu.Products;

import depaul.edu.Products.Hats.*;
import depaul.edu.Products.Shirts.*;
import depaul.edu.Products.Pants.*;
import depaul.edu.Products.Shoes.*;

public class ProductFactory {
	public static Product getProduct(ProductType type) {
		switch (type) {
			case BASEBALL_HAT:
				return new BaseballHat(ProductType.BASEBALL_HAT.getListPrice(), ProductType.BASEBALL_HAT.getDisplayName());
			case TOP_HAT:
				return new TopHat(ProductType.TOP_HAT.getListPrice(), ProductType.TOP_HAT.getDisplayName());
			case COWBOY_HAT:
				return new CowboyHat(ProductType.COWBOY_HAT.getListPrice(),  ProductType.COWBOY_HAT.getDisplayName());
			case PLAIN_SHORTSLEEVE_SHIRT:
				return new PlainShortSleeveShirt(ProductType.PLAIN_SHORTSLEEVE_SHIRT.getListPrice(), ProductType.PLAIN_SHORTSLEEVE_SHIRT.getDisplayName());
			case STRIPED_SHORTSLEEVE_SHIRT:
				return new StripedShortSleeveShirt(ProductType.STRIPED_SHORTSLEEVE_SHIRT.getListPrice(), ProductType.STRIPED_SHORTSLEEVE_SHIRT.getDisplayName());
			case STRAIGHT_LEG_PANTS:
				return new StraightLegPants(ProductType.STRAIGHT_LEG_PANTS.getListPrice(), ProductType.STRAIGHT_LEG_PANTS.getDisplayName());
			case BELL_BOTTOM_JEANS:
				return new BellbottomJeans(ProductType.BELL_BOTTOM_JEANS.getListPrice(), ProductType.BELL_BOTTOM_JEANS.getDisplayName());
			case COWBOY_BOOTS:
				return new CowboyBoots(ProductType.COWBOY_BOOTS.getListPrice(), ProductType.COWBOY_BOOTS.getDisplayName());
			case PLAIN_SNEAKERS:
				return new PlainSneakers(ProductType.PLAIN_SNEAKERS.getListPrice(), ProductType.PLAIN_SNEAKERS.getDisplayName());
			default:
				System.out.println("Sorry, we do not have that item in stock.");
				return null;		
		}
	}
}
