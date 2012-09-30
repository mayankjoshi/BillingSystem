package mckinsey.interview.billing.system.discount;

/**
 * Patron Discount. If a Customer is shopping with is from last two years than
 * we call him a Patron. The discount amount is 5%
 * 
 * @author mayjoshi
 * 
 */
public class PatronDiscount implements IDiscount {

	@Override
	public String getType() {

		return PERCENTAGE;
	}

	@Override
	public int getAmount() {

		return 5;
	}

}
