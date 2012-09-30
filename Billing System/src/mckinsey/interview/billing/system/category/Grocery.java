package mckinsey.interview.billing.system.category;

/**
 * Category Class for Grocery
 * 
 * @author mayjoshi
 * 
 */
public class Grocery implements ICategory {

	private String groceryName = "GROCERY";

	@Override
	public String getCategoryName() {

		return groceryName;
	}

	@Override
	public void setCategoryName(final String categoryName) {
		groceryName = categoryName;

	}

}
