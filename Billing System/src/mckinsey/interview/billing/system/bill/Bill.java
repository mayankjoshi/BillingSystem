package mckinsey.interview.billing.system.bill;

import java.util.List;

import mckinsey.interview.billing.system.discount.IDiscount;

public class Bill {

	private List<LineItem> lineItem;
	private int grossAmount;
	private int netAmount;
	private List<IDiscount> discounts;

	public List<LineItem> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<LineItem> lineItem) {
		this.lineItem = lineItem;
	}

	public int getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(int grossAmount) {
		this.grossAmount = grossAmount;
	}

	public int getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(int netAmount) {
		this.netAmount = netAmount;
	}

	public List<IDiscount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<IDiscount> discounts) {
		this.discounts = discounts;
	}

}
