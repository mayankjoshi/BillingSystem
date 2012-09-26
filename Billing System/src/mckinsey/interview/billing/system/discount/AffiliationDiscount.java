package mckinsey.interview.billing.system.discount;

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
