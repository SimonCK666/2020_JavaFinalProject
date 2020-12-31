
public abstract class Account implements IAccount {
	private String name;
	private int money;
	
	public Account(String name, int money) {
		// create the constructor
		this.money = money;
		this.name = name;
	}
	
	@Override
	public String getName() {
		// override getName method
		return name;
	}
	
	@Override
	public int getMoney() {
		// override getMoney method
		return money;
	}
	
	protected void setMoney(int money) {
		// setMoney method
		this.money = money;
	}
	
	@Override
	// the withdraw is abstract
	public abstract void withdraw(int amount) throws NotEnoughMoneyExpection;
	
	public static void testAccount() {
		// abstract
	}
}
