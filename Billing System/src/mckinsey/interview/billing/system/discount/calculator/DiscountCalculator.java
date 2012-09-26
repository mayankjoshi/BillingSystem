package mckinsey.interview.billing.system.discount.calculator;

import java.util.Iterator;
import java.util.List;

import mckinsey.interview.billing.system.bill.Bill;
import mckinsey.interview.billing.system.bill.LineItem;
import mckinsey.interview.billing.system.category.Grocery;
import mckinsey.interview.billing.system.category.ICategory;
import mckinsey.interview.billing.system.discount.IDiscount;

public final class DiscountCalculator {

	private static DiscountCalculator calculator = new DiscountCalculator();

	private DiscountCalculator() {

	}

	public DiscountCalculator getInstance() {
		return calculator;
	}

	public int getTotalDiscount(final Bill bill) {
		int discount = 0;
		// Get Gross Amount
		int grossAmount = bill.getGrossAmount();
		// Get Grocery Amount as we will not apply discount on Groceries.
		int groceryAmount = getGroceryAmount(bill);
		// Amount on which discount to be applied
		int discountOn = (grossAmount - groceryAmount);
		// Get best Applicable Discount. This is in percentage.
		int bestApplicableDiscount = getBestApplicableDiscount(bill);
		// Now get discountAmount
		int discountedAmount = (bestApplicableDiscount / 100) * discountOn;
		// Now get deduct the discountedAmount
		int amountAfterApplyingDiscount = (discountOn - discountedAmount);
		// Now get and apply CashBack
		int cashBackDiscount = getCashBackDiscount(bill);
		// Now deduct cashBack
		int cashBackAmount = (amountAfterApplyingDiscount / 100)
				* cashBackDiscount;
		int netPayable = (amountAfterApplyingDiscount - cashBackAmount);
		return discount;
	}

	public int getCashBackDiscount(final Bill bill) {
		int cashBack = 0;
		List<IDiscount> discounts = bill.getDiscounts();
		for (Iterator<IDiscount> iterator = discounts.iterator(); iterator
				.hasNext();) {
			IDiscount iDiscount = (IDiscount) iterator.next();
			if (iDiscount.getType().equals(IDiscount.CASHBACK)) {
				return iDiscount.getAmount();
			}

		}

		return cashBack;

	}

	/**
	 * This will give the highest applicable Discount on a bill. A Bill may be
	 * eligible for all three discounts but which one to apply is what is
	 * calculated in this method. The assumption is that we will apply the
	 * highest discount. This method will only consider the Discounts of type
	 * Percentage
	 * 
	 * @param bill
	 * @return
	 */
	public int getBestApplicableDiscount(final Bill bill) {
		List<IDiscount> discounts = bill.getDiscounts();
		int currentDiscount = 0;
		for (Iterator<IDiscount> iterator = discounts.iterator(); iterator
				.hasNext();) {
			IDiscount iDiscount = (IDiscount) iterator.next();
			if (iDiscount.getType().equals(IDiscount.PERCENTAGE)) {
				int amount = iDiscount.getAmount();
				if (amount > currentDiscount) {
					currentDiscount = amount;
				}
			}

		}
		return currentDiscount;
	}

	public int getGroceryAmount(final Bill bill) {
		List<LineItem> lineItemList = bill.getLineItem();
		int groceryAmount = 0;
		for (Iterator<LineItem> iterator = lineItemList.iterator(); iterator
				.hasNext();) {
			LineItem lineItem = (LineItem) iterator.next();
			ICategory itemCategory = lineItem.getItemCategory();
			if (itemCategory instanceof Grocery) {
				groceryAmount += (lineItem.getRate() * lineItem.getQuantity());
			}

		}

		return groceryAmount;
	}

}
