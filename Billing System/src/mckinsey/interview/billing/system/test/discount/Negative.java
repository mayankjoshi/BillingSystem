package mckinsey.interview.billing.system.test.discount;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import mckinsey.interview.billing.system.bill.Bill;
import mckinsey.interview.billing.system.bill.LineItem;
import mckinsey.interview.billing.system.discount.IDiscount;
import mckinsey.interview.billing.system.discount.calculator.DiscountCalculator;
import mckinsey.interview.billing.system.test.TestUtil;

import org.junit.Test;

public class Negative {

	@Test
	public void testZeroGrossBill() {
		Bill bill = TestUtil.createZeroValueBill();
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bill);
		assertTrue("The NetValue should be 0", netAmount == 0);

	}

	@Test
	public void testNegativeGrossBill() {
		Bill bill = TestUtil.createNegativeValueBill();
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bill);
		assertTrue("The NetValue should be -1", netAmount == -1);
	}

	@Test
	public void testNoItemBill() {
		Bill bill = new Bill();
		List<LineItem> items = new ArrayList<LineItem>();
		bill.setLineItem(items);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bill);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}

	@Test
	public void testNullItemBill() {
		Bill bill = new Bill();
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bill);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}

	@Test
	public void testNoDiscountBill() {
		Bill createGroceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		createGroceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				createGroceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testNullDiscountBill() {
		Bill createGroceryOnlyBill = TestUtil.createGroceryOnlyBill();

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				createGroceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testGetNetAmount_With_NullBill() {
		int netAmount = DiscountCalculator.getInstance().getNetAmount(null);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}

	@Test
	public void testGetCashBackDiscount_With_NullBill() {
		int netAmount = DiscountCalculator.getInstance().getCashBackDiscount(null);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}

	@Test
	public void testGetBestApplicableDiscount_With_NullBill() {
		int netAmount = DiscountCalculator.getInstance().getBestApplicableDiscount(null);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}

	@Test
	public void testGetGroceryAmount_With_NullBill() {
		int netAmount = DiscountCalculator.getInstance().getGroceryAmount(null);
		assertTrue("The NetValue should be 0", netAmount == 0);
	}
}
