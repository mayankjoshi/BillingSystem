package mckinsey.interview.billing.system.discount;

public class CashBack implements IDiscount {

	@Override
	public String getType() {
		return CASHBACK;
	}

	@Override
	public int getAmount() {

		return 5;
	}

	@Override
	public String getName() {

		return "CASHBACK";
	}

}
