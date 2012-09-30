package mckinsey.interview.billing.system.category;

/**
 * Category Class for non Groceries Category
 * 
 * @author mayjoshi
 * 
 */
public class NonGrocery implements ICategory {

	private String nongroceryName = "NONGROCERY";

	@Override
	public String getCategoryName() {

		return nongroceryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		this.nongroceryName = categoryName;

	}

}
