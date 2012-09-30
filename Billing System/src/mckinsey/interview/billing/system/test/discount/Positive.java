package mckinsey.interview.billing.system.test.discount;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import mckinsey.interview.billing.system.bill.Bill;
import mckinsey.interview.billing.system.discount.AffiliationDiscount;
import mckinsey.interview.billing.system.discount.CashBack;
import mckinsey.interview.billing.system.discount.EmployeeDiscount;
import mckinsey.interview.billing.system.discount.IDiscount;
import mckinsey.interview.billing.system.discount.PatronDiscount;
import mckinsey.interview.billing.system.discount.calculator.DiscountCalculator;
import mckinsey.interview.billing.system.test.TestUtil;

import org.junit.Test;

public class Positive {

	// ---------------- Single Discount Types-------------------//
	@Test
	public void testEmployeeDiscount_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(employeeDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);

	}

	@Test
	public void testEmployeeDiscount_WithOnlyNonGroceries() {
		Bill nonGroceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(employeeDiscount);
		nonGroceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				nonGroceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testEmployeeDiscount_WithBoth() {
		Bill bothBill = TestUtil.createBothGroceryAndNonGroceryBill();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(employeeDiscount);
		bothBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bothBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testAffiliatedDiscount_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);

	}

	@Test
	public void testAffiliatedDiscount_WithOnlyNonGroceries() {
		Bill nonGroceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(affiliationDiscount);
		nonGroceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				nonGroceryOnlyBill);
		assertTrue("The NetValue should be 797", netAmount == 797);
	}

	@Test
	public void testAffiliatedDiscount_WithBoth() {
		Bill bothBill = TestUtil.createBothGroceryAndNonGroceryBill();
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(affiliationDiscount);
		bothBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bothBill);
		assertTrue("The NetValue should be 797", netAmount == 797);
	}

	@Test
	public void testPatronDiscount_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		PatronDiscount patronDiscount = new PatronDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(patronDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testPatronDiscount_WithOnlyNonGroceries() {
		Bill nonGroceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		PatronDiscount patronDiscount = new PatronDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(patronDiscount);
		nonGroceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				nonGroceryOnlyBill);
		assertTrue("The NetValue should be 841", netAmount == 841);
	}

	@Test
	public void testPatronDiscount_WithBoth() {
		Bill bothBill = TestUtil.createBothGroceryAndNonGroceryBill();
		PatronDiscount patronDiscount = new PatronDiscount();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		discounts.add(patronDiscount);
		bothBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(bothBill);
		assertTrue("The NetValue should be 841", netAmount == 841);
	}

	// ---------------- Double Discount Types-------------------//
	@Test
	public void testPatron_And_Employee_Discount_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testPatron_And_Employee_Discount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testPatron_And_Employee_Discount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 797", netAmount == 797);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 797", netAmount == 797);

	}

	@Test
	public void testEmployee_And_Affiliated_Discount_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);
		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);
		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	// ---------------- Triple Discount Types-------------------//

	@Test
	public void testEmployee_Patron_Affiliated_Discount_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testThreeEmployeeDiscount_WithGrocery() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount1 = new EmployeeDiscount();
		discounts.add(employeeDiscount1);

		EmployeeDiscount employeeDiscount2 = new EmployeeDiscount();
		discounts.add(employeeDiscount2);

		EmployeeDiscount employeeDiscount3 = new EmployeeDiscount();
		discounts.add(employeeDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);

	}

	@Test
	public void testThreeEmployeeDiscount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount1 = new EmployeeDiscount();
		discounts.add(employeeDiscount1);

		EmployeeDiscount employeeDiscount2 = new EmployeeDiscount();
		discounts.add(employeeDiscount2);

		EmployeeDiscount employeeDiscount3 = new EmployeeDiscount();
		discounts.add(employeeDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);

	}

	@Test
	public void testThreeEmployeeDiscount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();
		EmployeeDiscount employeeDiscount1 = new EmployeeDiscount();
		discounts.add(employeeDiscount1);

		EmployeeDiscount employeeDiscount2 = new EmployeeDiscount();
		discounts.add(employeeDiscount2);

		EmployeeDiscount employeeDiscount3 = new EmployeeDiscount();
		discounts.add(employeeDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 620", netAmount == 620);
	}

	@Test
	public void testThreePatronDiscount_WithGrocery() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount1 = new PatronDiscount();
		discounts.add(patronDiscount1);

		PatronDiscount patronDiscount2 = new PatronDiscount();
		discounts.add(patronDiscount2);

		PatronDiscount patronDiscount3 = new PatronDiscount();
		discounts.add(patronDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testThreePatronDiscount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount1 = new PatronDiscount();
		discounts.add(patronDiscount1);

		PatronDiscount patronDiscount2 = new PatronDiscount();
		discounts.add(patronDiscount2);

		PatronDiscount patronDiscount3 = new PatronDiscount();
		discounts.add(patronDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 841", netAmount == 841);
	}

	@Test
	public void testThreePatronDiscount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount1 = new PatronDiscount();
		discounts.add(patronDiscount1);

		PatronDiscount patronDiscount2 = new PatronDiscount();
		discounts.add(patronDiscount2);

		PatronDiscount patronDiscount3 = new PatronDiscount();
		discounts.add(patronDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 841", netAmount == 841);
	}

	@Test
	public void testThreeAffiliationDiscount_WithGrocery() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount1 = new AffiliationDiscount();
		discounts.add(affiliationDiscount1);

		AffiliationDiscount affiliationDiscount2 = new AffiliationDiscount();
		discounts.add(affiliationDiscount2);

		AffiliationDiscount affiliationDiscount3 = new AffiliationDiscount();
		discounts.add(affiliationDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 885", netAmount == 885);
	}

	@Test
	public void testThreeAffiliationDiscount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount1 = new AffiliationDiscount();
		discounts.add(affiliationDiscount1);

		AffiliationDiscount affiliationDiscount2 = new AffiliationDiscount();
		discounts.add(affiliationDiscount2);

		AffiliationDiscount affiliationDiscount3 = new AffiliationDiscount();
		discounts.add(affiliationDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 797", netAmount == 797);
	}

	@Test
	public void testThreeAffiliationDiscount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount1 = new AffiliationDiscount();
		discounts.add(affiliationDiscount1);

		AffiliationDiscount affiliationDiscount2 = new AffiliationDiscount();
		discounts.add(affiliationDiscount2);

		AffiliationDiscount affiliationDiscount3 = new AffiliationDiscount();
		discounts.add(affiliationDiscount3);

		groceryOnlyBill.setDiscounts(discounts);
		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);
		assertTrue("The NetValue should be 797", netAmount == 797);
	}

	// ---------------- Single Discount Types with CashBack-------------------//
	@Test
	public void testEmployeeDiscount_And_CashBack_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 762", netAmount == 762);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 762", netAmount == 762);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 801", netAmount == 801);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 801", netAmount == 801);
	}

	// ---------------- Double Discount Types with CashBack-------------------//
	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 762", netAmount == 762);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 762", netAmount == 762);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	// ---------------- Triple Discount Types with CashBack-------------------//

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 590", netAmount == 590);
	}

	@Test
	public void testThreeCashBackDiscount_WithGrocery() {
		Bill groceryOnlyBill = TestUtil.createGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testThreeCashBackDiscount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	@Test
	public void testThreeCashBackDiscount_WithBoth() {
		Bill groceryOnlyBill = TestUtil.createBothGroceryAndNonGroceryBill();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 845", netAmount == 845);
	}

	// -----Single Discount Types with CashBack less than 100----------------//
	@Test
	public void testEmployeeDiscount_And_CashBack_LessThan100_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_LessThan100_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 63", netAmount == 63);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 28", netAmount == 28);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_LessThan100_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_LessThan100_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 81", netAmount == 81);
	}

	@Test
	public void testAffiliatedDiscount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 28", netAmount == 28);
	}

	@Test
	public void testPatronDiscount_And_CashBack_LessThan100_WithOnlyGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testPatronDiscount_And_CashBack_LessThan100_WithOnlyNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);
		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 86", netAmount == 86);
	}

	@Test
	public void testPatronDiscount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 38", netAmount == 38);
	}

	// --- Double Discount Types with CashBack Less than 100------------//
	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_LessThan100_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_LessThan100_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 63", netAmount == 63);
	}

	@Test
	public void testPatron_And_Employee_Discount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 28", netAmount == 28);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_LessThan100_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_LessThan100_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 81", netAmount == 81);
	}

	@Test
	public void testPatron_And_Affiliated_Discount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 36", netAmount == 36);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_LessThan100_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_LessThan100_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 63", netAmount == 63);
	}

	@Test
	public void testEmployee_And_Affiliated_Discount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 28", netAmount == 28);
	}

	// ------ Triple Discount Types with CashBack Less Than 100 --------------//

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_LessThan100_WithGroceries() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_LessThan100_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 63", netAmount == 63);
	}

	@Test
	public void testEmployee_Patron_Affiliated_Discount_And_CashBack_LessThan100_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 28", netAmount == 28);
	}

	@Test
	public void testThreeCashBack_LessThan100_Discount_WithGrocery() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillLessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testThreeCashBack_LessThan100_Discount_WithNonGroceries() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 90", netAmount == 90);
	}

	@Test
	public void testThreeCashBack_LessThan100_Discount_WithBoth() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBilllessThan100();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack1 = new CashBack();
		discounts.add(cashBack1);

		CashBack cashBack2 = new CashBack();
		discounts.add(cashBack2);

		CashBack cashBack3 = new CashBack();
		discounts.add(cashBack3);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 40", netAmount == 40);
	}

	// Single Discount with $1 value of Bill

	@Test
	public void testEmployeeDiscount_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);

	}

	@Test
	public void testEmployeeDiscount_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testEmployeeDiscount_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscountt = new PatronDiscount();
		discounts.add(patronDiscountt);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscountt = new PatronDiscount();
		discounts.add(patronDiscountt);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscountt = new PatronDiscount();
		discounts.add(patronDiscountt);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	// Single Discount with Cash Back with $1 value of Bill

	@Test
	public void testEmployeeDiscount_And_CashBack_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testEmployeeDiscount_And_CashBack_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testPatronDiscount_And_CashBack_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_And_CashBack_WithGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_And_CashBack_WithNonGroceriesOnly$1Bll() {
		Bill groceryOnlyBill = TestUtil.createNonGroceryOnlyBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	@Test
	public void testAffiliationDiscount_And_CashBack_WithBoth$1Bll() {
		Bill groceryOnlyBill = TestUtil
				.createBothGroceryAndNonGroceryBillOf$1();
		List<IDiscount> discounts = new ArrayList<IDiscount>();

		AffiliationDiscount affiliationDiscount = new AffiliationDiscount();
		discounts.add(affiliationDiscount);

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		groceryOnlyBill.setDiscounts(discounts);

		int netAmount = DiscountCalculator.getInstance().getNetAmount(
				groceryOnlyBill);

		assertTrue("The NetValue should be 1", netAmount == 1);
	}

	// -------- API testing------------

	@Test
	public void testGetGroceryAmount_With_Only_GroceryBill() {
		Bill bill = TestUtil.createGroceryOnlyBill();
		int groceryAmount = DiscountCalculator.getInstance().getGroceryAmount(
				bill);

		assertTrue("The NetValue should be 885", groceryAmount == 885);
	}

	@Test
	public void testGetGroceryAmount_With_Only_Non_GroceryBill() {
		Bill bill = TestUtil.createNonGroceryOnlyBill();
		int groceryAmount = DiscountCalculator.getInstance().getGroceryAmount(
				bill);

		assertTrue("The NetValue should be 0", groceryAmount == 0);
	}

	@Test
	public void testGetGroceryAmount_With_BothBill() {
		Bill bill = TestUtil.createBothGroceryAndNonGroceryBill();
		int groceryAmount = DiscountCalculator.getInstance().getGroceryAmount(
				bill);

		assertTrue("The NetValue should be 885", groceryAmount == 885);
	}

	@Test
	public void testGetBestApplicableDiscount_With_No_Discount() {
		Bill bill = TestUtil.createGroceryOnlyBill();
		int bestApplicableDiscount = DiscountCalculator.getInstance()
				.getBestApplicableDiscount(bill);
		assertTrue("The NetValue should be 0", bestApplicableDiscount == 0);
	}

	@Test
	public void testGetBestApplicableDiscount_With_Employee_Discount() {
		Bill bill = TestUtil.createGroceryOnlyBill();

		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		bill.setDiscounts(discounts);

		int bestApplicableDiscount = DiscountCalculator.getInstance()
				.getBestApplicableDiscount(bill);

		assertTrue("The NetValue should be 30", bestApplicableDiscount == 30);
	}

	@Test
	public void testGetBestApplicableDiscount_With_Employee_And_Patron_Discount() {
		Bill bill = TestUtil.createGroceryOnlyBill();

		List<IDiscount> discounts = new ArrayList<IDiscount>();

		EmployeeDiscount employeeDiscount = new EmployeeDiscount();
		discounts.add(employeeDiscount);

		PatronDiscount patronDiscount = new PatronDiscount();
		discounts.add(patronDiscount);

		bill.setDiscounts(discounts);

		int bestApplicableDiscount = DiscountCalculator.getInstance()
				.getBestApplicableDiscount(bill);

		assertTrue("The NetValue should be 30", bestApplicableDiscount == 30);
	}

	@Test
	public void testGetcashBack() {
		Bill bill = TestUtil.createGroceryOnlyBill();

		List<IDiscount> discounts = new ArrayList<IDiscount>();

		CashBack cashBack = new CashBack();
		discounts.add(cashBack);

		bill.setDiscounts(discounts);

		int cashBackDiscount = DiscountCalculator.getInstance().getCashBackDiscount(bill);
		
		assertTrue("The NetValue should be 30", cashBackDiscount == 5);
	}

}
