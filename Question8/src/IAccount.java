
public interface IAccount {
	// getName method
	public String getName();
	// getMoney method
	public int getMoney();
	// withdraw method
	public void withdraw(int amount) throws NotEnoughMoneyExpection;
}
