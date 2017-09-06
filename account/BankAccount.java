package account;

import java.io.File;
import java.util.Scanner;

public class BankAccount {

	double balance;
	String owner;
	File textFile = new File("test.txt");
	Scanner scnr = new Scanner(textFile);
	while(scnr.hasNextLine()) {
		String line = scnr.nextLine();
		System.out.println(line);
	}
	
	// deposit
	public void deposit(double amount) {
		balance += amount;
	}
	
	// withdraw
	public void withdraw(double amount) {
		balance -= amount;
	}
	public static void main(String[] args) {


	}

}
