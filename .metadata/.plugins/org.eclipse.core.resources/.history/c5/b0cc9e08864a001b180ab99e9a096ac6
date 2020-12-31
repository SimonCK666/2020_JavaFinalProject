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
		String str1 = readLine("Type some text: ");
		System.out.println("Text read is: " + str1);
		int i = readPosInt("Type an integer: ");
		System.out.println("Integer read is: " + i);
		String str2 = readLine("Type some text again: ");
		System.out.println("Text read is: " + str2);
	}
}
