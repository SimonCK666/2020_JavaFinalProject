
public class ControllerWithdraw extends Controller {
	public ControllerWithdraw(Bank m) {
		// create constructor
		super(m);
	}
	
	public String withdraw(String name, String amount) {
		try {
			// change the String to int
			m.withdraw(name, Integer.parseInt(amount));
			// return null
			return null;
		} catch (NumberFormatException | NotEnoughMoneyExpection | UnknownCustomerException e) {
			// return message
			return e.getMessage();
		}
	}
}
