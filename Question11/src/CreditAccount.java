
public class CreditAccount extends Account {
	public CreditAccount(String name, int money) {
		// extends the variables
		super(name, money);
	}
	
	@Override
	public void withdraw(int amount) {
		//subtract the amount of money from the amount of money currently stored in the account
		this.setMoney(super.getMoney() - amount);
	}
	
	public static void testCreditAccount() {
		CreditAccount ca = new CreditAccount("Simon", 10);
		
		// test getMoney method
		System.out.println(ca.getMoney() == 10);
		// test getName method
		System.out.println(ca.getName() == "Simon");
		
		// test setMoney method
		ca.setMoney(20);
		// test getMoney method
		System.out.println(ca.getMoney() == 20);
		
		// test withdraw method
		ca.withdraw(5);
		System.out.println(ca.getMoney());
		
	}
}