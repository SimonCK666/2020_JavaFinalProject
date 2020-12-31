import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {
	private static Scanner input = new Scanner(System.in);
	
	/*
	 * The readLine method is static and private, it takes a string as argument, 
	 * and returns another string as result
	 * readPosInt method is static and private, it takes a string as argument, 
	 * and returns a positive integer as result.
	 */
	private static String readLine(String str) {
		System.out.print(str);
	
		// return input
		return input.nextLine();	
	}
	
	private static int readPosInt(String str) {
		int num;
		while (true) {
			try {
				System.out.print(str);
				num = input.nextInt();
				
				input.nextLine();
				if (num < 0) {
					// print out the error
					System.out.println("Positive integers only!");
				} else {
					// return num 
					return num;
				}
			} catch (InputMismatchException e) {
				// print the error message
				System.out.println("You must type an integer!");
				
				input.nextLine();
			}
		}
	}
	
	public static void main(String[] args) {
		// test method
//		String str1 = readLine("Type some text: ");
//		System.out.println("Text read is: " + str1);
//		int i = readPosInt("Type an integer: ");
//		System.out.println("Integer read is: " + i);
//		String str2 = readLine("Type some text again: ");
//		System.out.println("Text read is: " + str2);
		
		Bank UICBank = new Bank("UIC Bank");
		
		while (true) {
			// while true then in the loop
			int i = readPosInt("Type an action (total:1 add:2 list:3 withdraw:4 deposit:5 quit:6): ");
			switch (i) {
			case 1:
				// Action 1
				System.out.println("Total amount of money in the bank: " + UICBank.totalMoney());
				break;

			case 2:
				// Action 2
				int n = readPosInt("Type the account type (credit:1 student:2): ");
				switch (n) {
				case 1:
					String str1 = readLine("Enter the name of the customer: ");
					int num1 = readPosInt("Enter the initial amount of money: ");

					UICBank.addAcount(new CreditAccount(str1, num1));
	
					System.out.println("Credit account for " + str1 + " with " + num1 + " yuan has been added.");
					break;

				case 2:
					String str2 = readLine("Enter the name of the customer: ");
					int num2 = readPosInt("Enter the initial amount of money: ");

					try {
						// add account
						UICBank.addAcount(new StudentAccount(str2, num2));
					} catch (NotEnoughMoneyExpection e) {
						// print out the error
						System.out.println("BUG! This must never happen!");
						// exist
						System.exit(1);
					}
					
					System.out.println("Student account for " + str2 + " with " + num2 + " yuan has been added.");
					break;

				default:
					// if the judgment is not true
					System.out.println("Unknown type of account!");
				}
				break;

			case 3:
				// Action 3
				String str3 = readLine("Enter the name of the customer: ");
				try {
					System.out.println(str3 + " has " + UICBank.getMoney(str3) + " yuan in the bank.");
				} catch (UnknownCustomerException e) {
					// print out the message
					System.out.println(e.getMessage());
				}
				
				break;

			case 4:
				// Action 4
				String str4 = readLine("Enter the name of the customer: ");
				int num4 = readPosInt("Enter the amount of money to withdraw: ");
				try {
					UICBank.withdraw(str4, num4);
				} catch (NotEnoughMoneyExpection | UnknownCustomerException e) {
					// print out the message
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				// Action 5
				String str5 = readLine("Enter the name of the customer: ");
				int num5 = readPosInt("Enter the amount of money to deposit: ");
				try {
					UICBank.withdraw(str5, -num5);
				} catch (NotEnoughMoneyExpection | UnknownCustomerException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				// Action 6
				// print out the goodbye
				System.out.println("Goodbye!");
				// exist
				System.exit(1);

			default:
				// print the error message
				System.out.println("Unknown action!");
			}
		}
	}
}
