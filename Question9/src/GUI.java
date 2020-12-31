
public class GUI {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Bank UICBank = new Bank("UIC Bank");
				CreditAccount account = new CreditAccount("Simon", 10000);
				
				// add account to the UICBank
				UICBank.addAcount(account);
				
				ControllerSimple c = new ControllerSimple(UICBank);
				new ViewSimple(UICBank, c);
				
				ControllerGetMoney cg = new ControllerGetMoney(UICBank);
				new ViewGetMoney(UICBank, cg);
			}
		});
	}
}


/*

	you should see a window that shows the total amount of money in 
	all the bank accounts of the bank. This total amount must be zero, 
	since the bank (model object) you just created above does not contain 
	any account!

*/

/*

As a test, in the run method of the anonymous class, you can try to 
manually add to your bank (model object) some student accounts and 
credit accounts to check that your GUI displays the correct total 
amount of money in all the bank accounts of the bank.

*/