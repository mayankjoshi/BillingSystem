package mckinsey.interview.billing.system.discount;

public interface IDiscount {
	String CASHBACK = "cashBack";
	String PERCENTAGE = "percentage";

	String getType();

	int getAmount();

	String getName();

}
