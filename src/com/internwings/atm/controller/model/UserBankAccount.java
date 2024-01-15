package com.internwings.atm.model;

public class UserBankAccount {
	
	private long acc_number;
	private String acc_holderName;
	private double acc_balance;
	public long getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(long acc_number) {
		this.acc_number = acc_number;
	}
	public String getAcc_holderName() {
		return acc_holderName;
	}
	public void setAcc_holderName(String acc_holderName) {
		this.acc_holderName = acc_holderName;
	}
	public double getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(double acc_balance) {
		this.acc_balance = acc_balance;
	}

}
