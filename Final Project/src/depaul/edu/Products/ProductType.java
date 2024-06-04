package depaul.edu.Products;

public enum ProductType {
	BASEBALL_HAT(14.99, "baseball hat"),
	TOP_HAT(19.99, "top hat"),
	COWBOY_HAT(24.99, "cowboy hat"),
	PLAIN_SHORTSLEEVE_SHIRT(14.99, "plain short sleeve shirt"),
	STRIPED_SHORTSLEEVE_SHIRT(19.99, "striped short sleeve shirt"),
	STRAIGHT_LEG_PANTS(24.99, "straight legged pants"),
	BELL_BOTTOM_JEANS(29.99, "bell bottom jeans"),
	COWBOY_BOOTS(49.99, "cowboy boots"),
	PLAIN_SNEAKERS(24.99, "plain sneakers");
	
	private final String displayName;
	private final double listPrice;

	ProductType(double listPrice, String displayName) {
		this.listPrice = listPrice;
		this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public Double getListPrice() {
        return listPrice;
    }
	
}
