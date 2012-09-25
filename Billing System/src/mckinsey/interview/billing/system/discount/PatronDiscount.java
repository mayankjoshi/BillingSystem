package mckinsey.interview.billing.system.discount;

public class PatronDiscount implements IDiscount {

	@Override
	public String getType() {
		
		return "PATRON";
	}

	@Override
	public int getPercentage() {
		
		return 5;
	}

}
