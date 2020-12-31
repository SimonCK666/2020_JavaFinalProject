import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList<IAccount> accounts;
	
	// an arraylist of ModelListener
	private ArrayList<ModelListener> modelListeners;
	
	// an arraylist of history
	private ArrayList<Integer> history;
	
	// a private file instance variable
	private File file;

	
	public Bank(String name) {
		// create new constructor
		this.name = name;
		
		// create the bin file
		file = new File(name + ".bin");
		
		// if file exist
		if(file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				accounts = (ArrayList<IAccount>) ois.readObject();
				history = (ArrayList<Integer>) ois.readObject();
				
				// close file
				fis.close();
				ois.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				
				System.exit(0);
			}
		} else {
			accounts = new ArrayList<IAccount>();
			history = new ArrayList<Integer>();
			
			// add history
			history.add(0);
		}
		
		// accounts = new ArrayList<IAccount>();
		
		// Question 7
		// let modelListeners to a object
		modelListeners = new ArrayList<ModelListener>();
	}
	
	public void addAcount(IAccount account) {
		// add account method
		accounts.add(account);
		
		history.add(totalMoney());
		
		notifyListeners();
	}
	
	// Question 7
	public void addListeners(ModelListener modelListener) {
		// add items to the arraylist
		modelListeners.add(modelListener);
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
	
	// Question 12
	// add a getHistory method
	public ArrayList<Integer> getHistory() {
		return history;
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
		
		// add history
		history.add(totalMoney());
		
		notifyListeners();
	}
	
	private void notifyListeners() {
		// notify listener
		for (ModelListener modelListeners : modelListeners) {
			// update
			modelListeners.update();
		}
	}
	
	public void saveData() {
		// save data method
		try {
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			
			out.writeObject(accounts);
			out.writeObject(history);
			
			// close
			out.close();
			fo.close();
		} catch (IOException e) {
			e.printStackTrace();
			
			// exit
			System.exit(0);
		}
	}
	
	public static void testBank() {
		Bank b = new Bank("B");
		
		// test totalMoney method at the beginning
		System.out.println(b.totalMoney() == 0);
		
		try {
			b.getMoney("Simon");
		} catch (UnknownCustomerException e) {
			// print out the error message
			System.out.println(e.getMessage().equals("Customer Simon unknown."));
		}
		
		try {
			// through withdraw function
			b.withdraw("Simon", 20);
		} catch (NotEnoughMoneyExpection | UnknownCustomerException e) {
			// print out the error message
			System.out.println(e.getMessage().equals("Customer Simon unknown."));
		}
		
		b.addAcount(new CreditAccount("Simon", 100));
		try {
			// add the credit account
			b.addAcount(new StudentAccount("Tim", 100));
		} catch (NotEnoughMoneyExpection e) {
			e.printStackTrace();
		}
		
		// test the total money
		System.out.println(b.totalMoney() == 200);

	}
	
	
}
