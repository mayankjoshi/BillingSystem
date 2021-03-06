package mckinsey.interview.billing.system.discount;

/**
 * An Interface that defines the Discount Contract. This interface defines the
 * type of Discount i.e Percentage or cash and the amount
 * 
 * @author mayjoshi
 * 
 */
public interface IDiscount {
	String CASHBACK = "cashBack";
	String PERCENTAGE = "percentage";

	String getType();

	int getAmount();

}
