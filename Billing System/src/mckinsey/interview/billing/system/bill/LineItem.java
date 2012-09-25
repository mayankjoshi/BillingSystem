package mckinsey.interview.billing.system.bill;

import mckinsey.interview.billing.system.category.ICategory;

public class LineItem {

	private String itemCode;
	private ICategory itemCategory;
	private String sku;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public ICategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ICategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
