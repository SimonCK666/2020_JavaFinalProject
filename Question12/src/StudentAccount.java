
public class StudentAccount extends Account {
	public StudentAccount(String name, int money) throws NotEnoughMoneyExpection {
		// extends the variables
		super(name, money);
		/*
		 * if the amount of money given as argument is strictly less than zero then the constructor must throw
		 * the NotEnoughMoneyExpection with the message
		 */
		if (money < 0) {
			throw new NotEnoughMoneyExpection("Cannot create student account with negative amount of money");
		}
	}
	
	@Override
	public void withdraw(int amount) throws NotEnoughMoneyExpection{
		if (this.getMoney() - amount < 0) {
			// the exception
			throw new NotEnoughMoneyExpection("Cannot withdraw " + amount + " yuan from account, only " + this.getMoney() + " yuan is available.");
		} else {
			this.setMoney(this.getMoney() - amount);
		}
	}
	
	public static void testStudentAccount() {
		try {
			// create the new object
			StudentAccount sa = new StudentAccount("Simon", -100);
		} catch (NotEnoughMoneyExpection e){
			// print out the error
			System.out.println(e.getMessage().equals("Cannot create student account with negative amount of money."));

		}
		try {
			// create the new object
			StudentAccount sa2 = new StudentAccount("Simon", 100);
			System.out.println(sa2.getName() == "Simon");
			System.out.println(sa2.getMoney() == 100);
			sa2.setMoney(50);
			System.out.println(sa2.getMoney() == 50);
			sa2.withdraw(0);
			System.out.println(sa2.getMoney() == 0);
			
		} catch(NotEnoughMoneyExpection e) {
			// print out the error
			System.out.println(e.getMessage().equals("Cannot withdraw 50 yuan from account, only 0 yuan is available."));
		}
	}
}
