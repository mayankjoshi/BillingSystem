package mckinsey.interview.billing.system.discount;

public class AffiliationDiscount implements IDiscount {

	@Override
	public String getType() {
		
		return "AFFILIATION";
	}

	@Override
	public int getPercentage() {
		
		return 10;
	}

}
