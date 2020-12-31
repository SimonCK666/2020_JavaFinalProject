import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<IAccount> accounts;
	
	public Bank(String name) {
		// create new constructor
		this.name = name;
		accounts = new ArrayList<IAccount>();
	}
	
	public void addAcount(IAccount account) {
		// add account method
		accounts.add(account);
	}
	
	public int totalMoney() {
		// create a variable to sum the total money
		int tm = 0;
		for(IAccount accounts: accounts) {
			tm += accounts.getMoney();
		}
		// return total money
		return tm;
	}
	
	public int getMoney(String name) throws UnknownCustomerException {
		for (IAccount accounts : accounts) {
			if (name.equals(accounts.getName())) {
				// return the money
				return accounts.getMoney();
			}
		}
		
		// if the judgment is not true, throw this 
		throw new UnknownCustomerException("Customer " + name + " unknown.");
	}
	
	public void withdraw(String name, int amount) throws NotEnoughMoneyExpection, UnknownCustomerException {
		boolean nameExist = false;
		
		// if name exist
		for (IAccount accounts : accounts) {
			if (name.equals(accounts.getName())) {
				accounts.withdraw(amount);
				nameExist = true;
				break;
			}
		}
		
		if (nameExist == false) {
			// throw the exception
			throw new UnknownCustomerException("Customer " + name + " unknown.");
		}
	}
	
	public static void testBank() {
		Bank b = new Bank("B");
		
		// test totalMoney method at the beginning
		System.out.println(b.totalMoney() == 0);
		
		try {
			b.getMoney("Simon");
		} catch (UnknownCustomerException e) {
			System.out.println(e.getMessage().equals("Customer Simon unknown."));
		}
		
		try {
			b.withdraw("Simon", 20);
		} catch (NotEnoughMoneyExpection | UnknownCustomerException e) {
			System.out.println(e.getMessage().equals("Customer Simon unknown."));
		}
		
		b.addAcount(new CreditAccount("Simon", 100));
		try {
			b.addAcount(new StudentAccount("Tim", 100));
		} catch (NotEnoughMoneyExpection e) {
			e.printStackTrace();
		}
		System.out.println(b.totalMoney() == 200);

	}
	
	
}
