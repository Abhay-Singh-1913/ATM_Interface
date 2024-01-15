package com.internwings.atm.view;

import java.util.Scanner;
import com.internwings.atm.controller.ATMController;
import com.internwings.atm.model.UserBankAccount;

public class ATM_Machine {

	static ATMController controller = new ATMController();
	static Scanner myInput = new Scanner(System.in);
	static UserBankAccount userAccount = new UserBankAccount();

	static {
		System.out.println("///////////////////////////////////////////////////");
		System.out.println("/////                                         /////");
		System.out.println("/////-------------WELCOME TO BANK-------------/////");
		System.out.println("/////                                         /////");
		System.out.println("///////////////////////////////////////////////////");
		System.out.println();
		System.out.println("-----Create your Bank Account here-----");
		System.out.println(" =================================== ");
		System.out.println("|       Please enter you data       |");
		System.out.println(" =================================== ");
		System.out.print("| Enter Account Number : ");
		long acc_no = myInput.nextLong();
		myInput.nextLine();
		System.out.println(" =================================== ");
		System.out.print("| Enter Account holder name : ");
		String holder_name = myInput.nextLine();
		userAccount.setAcc_holderName(holder_name);
		System.out.println(" =================================== ");
		System.out.print("| Enter Account balance : ");
		double balance = myInput.nextDouble();
		myInput.nextLine();
		userAccount.setAcc_balance(balance);
		System.out.println(" =================================== ");
	}
	static {
		System.out.println("//////////////////////////////////////////////////////////");
		System.out.println("/////                                                /////");
		System.out.println("/////-------------WELCOME TO ATM MACHINE-------------/////");
		System.out.println("/////                                                /////");
		System.out.println("//////////////////////////////////////////////////////////");
	}

	public static void main(String[] args) {
		final String red = "\u001b[31;1m";
		final String white = "\u001b[37;1m";
		final String green = "\u001b[32;1m";
		final String reset = "\u001b[0m";
		final String yellow = "\u001b[33m";
		

		boolean Flag = true;
		while (Flag) {
			System.out.println(yellow);
			System.out.println(" ___________________________________ ");
			System.out.println("|                                   |");
			System.out.println("   ====Welcome " + userAccount.getAcc_holderName() + "====");
			System.out.println("|___________________________________|");
			System.out.println("|                                   |");
			System.out.println("|        1. Check Balance           |");
			System.out.println("|                                   |");
			System.out.println("|        2. Deposite Cash           |");
			System.out.println("|                                   |");
			System.out.println("|        3. Withdraw Cash           |");
			System.out.println("|                                   |");
			System.out.println("|        0. Exit                    |");
			System.out.println("|___________________________________|" + reset);
			System.out.println(white);
			System.out.println(" =================================== ");
			System.out.print("| Enter Your Choice : ");
			byte choice = myInput.nextByte();
			myInput.nextLine();
			System.out.println(" =================================== ");
			System.out.println();

			switch (choice) {

			case 0:
				myInput.close();
				Flag = false;
				System.exit(0);
				break;
			case 1:
				System.out.println(" =================================== ");
				System.out.println("|   Current Balance : " + checkBalance());
				System.out.println(" =================================== ");
				System.out.println();
				break;

			case 2:

				double deposit_amount = myInput.nextDouble();
				myInput.nextLine();
				deposit(deposit_amount);
				break;

			case 3:

				break;

			default:
				System.out.println(red);
				System.out.println(" =================================== ");
				System.out.println("| Invalid choice, please try again  |");
				System.out.println(" =================================== ");
				System.out.println(reset);
				break;
			}

		}
	}
	
	public static double deposit(double deposite_balance) {
		double balance = userAccount.getAcc_balance();
		double new_balance = balance + deposite_balance;
		userAccount.setAcc_balance(new_balance);
		return new_balance;
	}
	
	public static boolean withdrawing(double withdraw_balance) {
		double balance = userAccount.getAcc_balance();
		if (balance >= withdraw_balance) {
			double new_balance = balance - withdraw_balance;
			userAccount.setAcc_balance(new_balance);
			return true;
		}
		return false;
	}
	
	public static double checkBalance() {
		return userAccount.getAcc_balance();
	}

}
