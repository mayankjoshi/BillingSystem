package mckinsey.interview.billing.system.discount;

public class EmployeeDiscount implements IDiscount {

	@Override
	public String getType() {

		return PERCENTAGE;
	}

	@Override
	public int getAmount() {

		return 30;
	}

	

}
