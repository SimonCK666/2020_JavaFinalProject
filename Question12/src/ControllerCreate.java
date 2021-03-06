
public class ControllerCreate extends Controller {
	public ControllerCreate(Bank m) {
		// create the constructor
		super(m);
	}
	
	public String create(String name, String amount, int type) {
		if(type == 0) {
			// if type is zero, then add account
			try {
				m.addAcount(new CreditAccount(name, Integer.parseInt(amount)));
			} catch (NumberFormatException e) {
				// return message
				return e.getMessage();
			}
			return null;
		} else {
			// if type is not zero
			try {
				m.addAcount(new StudentAccount(name, Integer.parseInt(amount)));
			} catch (NumberFormatException | NotEnoughMoneyExpection e) {
				// return message
				return e.getMessage();
			}
			return null;
		}
	}
}
