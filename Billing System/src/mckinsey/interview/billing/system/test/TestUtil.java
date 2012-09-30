package mckinsey.interview.billing.system.test;

import java.util.ArrayList;
import java.util.List;

import mckinsey.interview.billing.system.bill.Bill;
import mckinsey.interview.billing.system.bill.LineItem;
import mckinsey.interview.billing.system.category.Grocery;
import mckinsey.interview.billing.system.category.NonGrocery;

public final class TestUtil {

	public static Bill createGroceryOnlyBill() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(2);
		item.setRate(150);
		item.setSku("Cabbage");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new Grocery());
		item2.setQuantity(1);
		item2.setRate(45);
		item2.setSku("Ginger");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new Grocery());
		item3.setQuantity(3);
		item3.setRate(80);
		item3.setSku("Onion");
		itemList.add(item3);

		LineItem item4 = new LineItem();
		item4.setItemCategory(new Grocery());
		item4.setQuantity(2);
		item4.setRate(150);
		item4.setSku("Cabbage");
		itemList.add(item4);

		Bill bill = new Bill();
		bill.setLineItem(itemList);
		bill.setGrossAmount(885);
		return bill;

	}

	public static Bill createNonGroceryOnlyBill() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new NonGrocery());
		item.setQuantity(2);
		item.setRate(150);
		item.setSku("FloorMat");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new NonGrocery());
		item2.setQuantity(1);
		item2.setRate(45);
		item2.setSku("DoorMats");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new NonGrocery());
		item3.setQuantity(3);
		item3.setRate(80);
		item3.setSku("Deo");
		itemList.add(item3);

		LineItem item4 = new LineItem();
		item4.setItemCategory(new NonGrocery());
		item4.setQuantity(2);
		item4.setRate(150);
		item4.setSku("perfume");
		itemList.add(item4);

		Bill bill = new Bill();
		bill.setLineItem(itemList);
		bill.setGrossAmount(885);
		return bill;
	}

	public static Bill createBothGroceryAndNonGroceryBill() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(2);
		item.setRate(150);
		item.setSku("Cabbage");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new Grocery());
		item2.setQuantity(1);
		item2.setRate(45);
		item2.setSku("Ginger");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new Grocery());
		item3.setQuantity(3);
		item3.setRate(80);
		item3.setSku("Onion");
		itemList.add(item3);

		LineItem item4 = new LineItem();
		item4.setItemCategory(new Grocery());
		item4.setQuantity(2);
		item4.setRate(150);
		item4.setSku("Cabbage");
		itemList.add(item4);

		Bill bill = new Bill();
		bill.setLineItem(itemList);

		LineItem item5 = new LineItem();
		item5.setItemCategory(new NonGrocery());
		item5.setQuantity(2);
		item5.setRate(150);
		item5.setSku("FloorMat");
		itemList.add(item5);

		LineItem item6 = new LineItem();
		item6.setItemCategory(new NonGrocery());
		item6.setQuantity(1);
		item6.setRate(45);
		item6.setSku("DoorMats");
		itemList.add(item6);

		LineItem item7 = new LineItem();
		item7.setItemCategory(new NonGrocery());
		item7.setQuantity(3);
		item7.setRate(80);
		item7.setSku("Deo");
		itemList.add(item7);

		LineItem item8 = new LineItem();
		item8.setItemCategory(new NonGrocery());
		item8.setQuantity(2);
		item8.setRate(150);
		item8.setSku("perfume");
		itemList.add(item8);

		bill.setLineItem(itemList);

		bill.setGrossAmount(1770);

		return bill;
	}

	public static Bill createGroceryBillLessThan100() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(1);
		item.setRate(30);
		item.setSku("Cabbage");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new Grocery());
		item2.setQuantity(1);
		item2.setRate(30);
		item2.setSku("Ginger");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new Grocery());
		item3.setQuantity(1);
		item3.setRate(30);
		item3.setSku("Onion");
		itemList.add(item3);

		Bill bill = new Bill();
		bill.setLineItem(itemList);

		bill.setLineItem(itemList);

		bill.setGrossAmount(90);

		return bill;
	}

	public static Bill createNonGroceryOnlyBilllessThan100() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new NonGrocery());
		item.setQuantity(1);
		item.setRate(30);
		item.setSku("FloorMat");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new NonGrocery());
		item2.setQuantity(1);
		item2.setRate(30);
		item2.setSku("DoorMats");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new NonGrocery());
		item3.setQuantity(1);
		item3.setRate(30);
		item3.setSku("Deo");
		itemList.add(item3);

		Bill bill = new Bill();
		bill.setLineItem(itemList);
		bill.setGrossAmount(90);
		return bill;
	}

	public static Bill createBothGroceryAndNonGroceryBilllessThan100() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(1);
		item.setRate(10);
		item.setSku("Cabbage");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new Grocery());
		item2.setQuantity(1);
		item2.setRate(10);
		item2.setSku("Ginger");
		itemList.add(item2);

		LineItem item3 = new LineItem();
		item3.setItemCategory(new Grocery());
		item3.setQuantity(1);
		item3.setRate(10);
		item3.setSku("Onion");
		itemList.add(item3);

		LineItem item4 = new LineItem();
		item4.setItemCategory(new Grocery());
		item4.setQuantity(1);
		item4.setRate(20);
		item4.setSku("Cabbage");
		itemList.add(item4);

		Bill bill = new Bill();
		bill.setLineItem(itemList);

		LineItem item5 = new LineItem();
		item5.setItemCategory(new NonGrocery());
		item5.setQuantity(1);
		item5.setRate(20);
		item5.setSku("FloorMat");
		itemList.add(item5);

		LineItem item6 = new LineItem();
		item6.setItemCategory(new NonGrocery());
		item6.setQuantity(1);
		item6.setRate(10);
		item6.setSku("DoorMats");
		itemList.add(item6);

		LineItem item7 = new LineItem();
		item7.setItemCategory(new NonGrocery());
		item7.setQuantity(1);
		item7.setRate(10);
		item7.setSku("Deo");
		itemList.add(item7);

		bill.setLineItem(itemList);

		bill.setGrossAmount(90);

		return bill;
	}

	public static Bill createGroceryBillOf$1() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(1);
		item.setRate(1);
		item.setSku("Cabbage");
		itemList.add(item);

		Bill bill = new Bill();
		bill.setLineItem(itemList);

		bill.setLineItem(itemList);

		bill.setGrossAmount(1);

		return bill;
	}

	public static Bill createNonGroceryOnlyBillOf$1() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new NonGrocery());
		item.setQuantity(1);
		item.setRate(1);
		item.setSku("FloorMat");
		itemList.add(item);
		Bill bill = new Bill();
		bill.setLineItem(itemList);
		bill.setGrossAmount(1);
		return bill;
	}

	public static Bill createBothGroceryAndNonGroceryBillOf$1() {
		List<LineItem> itemList = new ArrayList<LineItem>();

		LineItem item = new LineItem();
		item.setItemCategory(new Grocery());
		item.setQuantity(1);
		item.setRate(1);
		item.setSku("Cabbage");
		itemList.add(item);

		LineItem item2 = new LineItem();
		item2.setItemCategory(new NonGrocery());
		item2.setQuantity(1);
		item2.setRate(1);
		item2.setSku("Ginger");
		itemList.add(item2);

		Bill bill = new Bill();
		bill.setLineItem(itemList);

		bill.setGrossAmount(2);

		return bill;
	}

	public static Bill createNegativeValueBill() {
		Bill bill = new Bill();
		bill.setGrossAmount(-1);
		return bill;

	}

	public static Bill createZeroValueBill() {
		Bill bill = new Bill();
		bill.setGrossAmount(0);
		return bill;
	}

}
