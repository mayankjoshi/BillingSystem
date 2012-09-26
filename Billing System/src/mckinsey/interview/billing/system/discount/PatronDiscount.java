package mckinsey.interview.billing.system.discount;

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
