package mckinsey.interview.billing.system.category;

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
