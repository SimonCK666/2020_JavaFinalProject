
public class Controller {
	// create the protected variable
	protected Bank m;
	
	/*
	 * The m instance variable of the Controller class is protected 
	 * (so that it can be easily used in all the subclasses of Controller).
	 */
	public Controller(Bank m) {
		this.m = m;
	}
}
