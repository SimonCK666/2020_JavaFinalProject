
public class ControllerGetMoney extends Controller {
	public ControllerGetMoney(Bank m) {
		// create the constructor
		super(m);
	}
	
	/*
	 * The getMoney method takes the name of a bank customer as argument. 
	 * The getMoney method of the controller then calls the getMoney method
	 *  of the bank to get the amount of money currently stored in the bank 
	 *  account that belongs to that customer.
	 */
	
	public String getMoney(String name) {
		try {
			// return getMoney
			return "" + m.getMoney(name);
		} catch (UnknownCustomerException e) {
			// return getMessage
			return e.getMessage();
		}
	}
}

