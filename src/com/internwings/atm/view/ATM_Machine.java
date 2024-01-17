package com.internwings.atm.view;

import java.util.Scanner;
import com.internwings.atm.model.UserBankAccount;

public class ATM_Machine {

	static Scanner myInput = new Scanner(System.in);
	static UserBankAccount userAccount = new UserBankAccount();

	static {
		System.out.println("///////////////////////////////////////////////////");
		System.out.println("/////                                         /////");
		System.out.println("/////------------ WELCOME TO BANK ------------/////");
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
		System.out.print("| Enter some amount to deposit: ");
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
			System.out.println(" ==== Welcome " + userAccount.getAcc_holderName() + " to MENU ====");
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
				System.exit(0);
				Flag = false;
				break;
			case 1:
				System.out.println(green);
				System.out.println(" =================================== ");
				System.out.println("|   Current Balance : " + checkBalance());
				System.out.println(" =================================== ");
				System.out.println(reset);
				break;

			case 2:
				System.out.println(" =================================== ");
				System.out.print("| Enter some amount to deposit: ");
				double deposit_amount = myInput.nextDouble();
				myInput.nextLine();
				System.out.println(" =================================== ");
				if (deposit(deposit_amount)) {
					System.out.println(green);
					System.out.println(" =================================== ");
					System.out.println("| Your Transaction done Successfully|");
					System.out.println(" =================================== ");
					System.out.println(reset);
				} else {
					System.out.println(red);
					System.out.println(" =================================== ");
					System.out.println("|     Your Transaction Failed       |");
					System.out.println(" =================================== ");
					System.out.println(reset);
				}
				
				break;

			case 3:
				System.out.print("| Enter some amount to withdraw: ");
				double withdraw_amount = myInput.nextDouble();
				myInput.nextLine();
				if (withdrawing(withdraw_amount)) {
					System.out.println(green);
					System.out.println(" =================================== ");
					System.out.println("| Your Transaction done Successfully|");
					System.out.println(" =================================== ");
					System.out.println(reset);
				} else {
					System.out.println(red);
					System.out.println(" =================================== ");
					System.out.println("|     Your Transaction Failed       |");
					System.out.println(" =================================== ");
					System.out.println(reset);
				}
				break;

			default:
				System.out.println(red);
				System.out.println(" =================================== ");
				System.out.println("| Invalid choice, please try again  |");
				System.out.println(" =================================== ");
				System.out.println(reset);
				break;
			}
			System.out.println(yellow);
			System.out.println(" =================================== ");
			System.out.println("|       Thank you vist again        |");
			System.out.println(" =================================== ");
			System.out.println(reset);

		}
	}
	
	public static boolean deposit(double deposite_balance) {
		if (deposite_balance != 0) {
			double balance = userAccount.getAcc_balance();
			double new_balance = balance + deposite_balance;
			userAccount.setAcc_balance(new_balance);
			return true;
		}
		return false;
		
	}
	
	public static boolean withdrawing(double withdraw_balance) {
		if (withdraw_balance != 0) {
			double balance = userAccount.getAcc_balance();
			if (balance >= withdraw_balance) {
				double new_balance = balance - withdraw_balance;
				userAccount.setAcc_balance(new_balance);
				return true;
			}
		}
		return false;
	}
	
	public static double checkBalance() {
		return userAccount.getAcc_balance();
	}

}
