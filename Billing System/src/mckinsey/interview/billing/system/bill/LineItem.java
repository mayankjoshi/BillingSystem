package mckinsey.interview.billing.system.bill;

/** 
 * The POJO representing the One Item in the Bill
 */
import mckinsey.interview.billing.system.category.ICategory;

public class LineItem {
	private ICategory itemCategory;
	private int rate;
	private int quantity;
	private String sku = "default";

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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
