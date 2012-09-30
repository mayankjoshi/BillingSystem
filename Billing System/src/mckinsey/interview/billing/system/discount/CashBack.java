package mckinsey.interview.billing.system.discount;

/**
 * CashBack class for Cashback amount. For every $100 purchase we give $5
 * discount.
 * 
 * @author mayjoshi
 * 
 */
public class CashBack implements IDiscount {

	@Override
	public String getType() {
		return CASHBACK;
	}

	@Override
	public int getAmount() {

		return 5;
	}

}
