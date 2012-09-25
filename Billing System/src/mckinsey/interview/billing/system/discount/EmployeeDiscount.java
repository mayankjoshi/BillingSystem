package mckinsey.interview.billing.system.discount;

public class EmployeeDiscount implements IDiscount {

	@Override
	public String getType() {

		return "EMPLOYEE";
	}

	@Override
	public int getPercentage() {

		return 30;
	}

}
