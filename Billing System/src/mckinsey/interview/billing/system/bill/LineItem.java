package mckinsey.interview.billing.system.bill;

import mckinsey.interview.billing.system.category.ICategory;

public class LineItem {
	private ICategory itemCategory;
	private int rate;
	private int quantity;
	public ICategory getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(ICategory itemCategory) {
		this.itemCategory = itemCategory;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
