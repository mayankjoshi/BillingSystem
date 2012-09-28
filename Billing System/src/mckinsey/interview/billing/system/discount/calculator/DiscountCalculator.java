package mckinsey.interview.billing.system.discount.calculator;

import java.util.Iterator;
import java.util.List;

import mckinsey.interview.billing.system.bill.Bill;
import mckinsey.interview.billing.system.bill.LineItem;
import mckinsey.interview.billing.system.category.Grocery;
import mckinsey.interview.billing.system.category.ICategory;
import mckinsey.interview.billing.system.discount.IDiscount;

/**
 * This class calculates the Discount considering all the possible rules sets.
 * 
 * @author mayjoshi
 * 
 */
public final class DiscountCalculator {
	/**
	 * Making sure that the Class is Singleton
	 */
	private static DiscountCalculator calculator = new DiscountCalculator();

	private DiscountCalculator() {

	}

	public static DiscountCalculator getInstance() {
		return calculator;
	}

	/**
	 * This method will calculate the Net Amount after considering all the
	 * discounts for both percentage as well as cashback. It takes bill as an
	 * argument and then calculates the discount amount.
	 * 
	 * @param bill
	 * @return
	 */
	public int getNetAmount(final Bill bill) {
		if (bill == null) {
			throw new IllegalArgumentException("Bill can not be null");
		}
		int grossAmount = bill.getGrossAmount();
		int groceryAmount = getGroceryAmount(bill);
		// Amount on which discount to be applied
		int discountOn = (grossAmount - groceryAmount);
		if (discountOn == 0) {
			// This means that bill only has groceries and they are not
			// subject to discount, but we still need to apply the cashback
			int cashBackDiscount = getCashBackDiscount(bill);
			// Now deduct cashBack
			int cashBackAmount = (grossAmount / 100)
					* cashBackDiscount;
			int netPayable = (grossAmount - cashBackAmount);
			bill.setNetAmount(netPayable);
			return netPayable;
		}
		int bestApplicableDiscount = getBestApplicableDiscount(bill);
		// Now get discountAmount
		int discountedAmount = ((bestApplicableDiscount * discountOn) / 100);
		// Now get deduct the discountedAmount
		int amountAfterApplyingDiscount = (discountOn - discountedAmount);
		// Now get and apply CashBack
		int cashBackDiscount = getCashBackDiscount(bill);
		// Now deduct cashBack
		int cashBackAmount = (amountAfterApplyingDiscount / 100)
				* cashBackDiscount;
		int netPayable = (amountAfterApplyingDiscount - cashBackAmount);
		bill.setNetAmount(netPayable);
		return netPayable;
	}

	public int getCashBackDiscount(final Bill bill) {
		int cashBack = 0;
		List<IDiscount> discounts = bill.getDiscounts();
		for (Iterator<IDiscount> iterator = discounts.iterator(); iterator
				.hasNext();) {
			IDiscount iDiscount = iterator.next();
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
			IDiscount iDiscount = iterator.next();
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
			LineItem lineItem = iterator.next();
			ICategory itemCategory = lineItem.getItemCategory();
			if (itemCategory instanceof Grocery) {
				groceryAmount += (lineItem.getRate() * lineItem.getQuantity());
			}

		}

		return groceryAmount;
	}

}
