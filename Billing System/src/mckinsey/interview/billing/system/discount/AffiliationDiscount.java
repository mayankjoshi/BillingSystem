package mckinsey.interview.billing.system.discount;

/**
 * Affiliation Discount. Total Discount og 10%
 * 
 * @author mayjoshi
 * 
 */
public class AffiliationDiscount implements IDiscount {

	@Override
	public String getType() {

		return PERCENTAGE;
	}

	@Override
	public int getAmount() {

		return 10;
	}

}
