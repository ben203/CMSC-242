/**
 * 
 * File: Account.java 
 * Author: Bedemariam Degef 
 * Date: September 11, 2019 
 * Purpose:This class is used to deal with the balance of the account
 * 
 */
public class Account {

	private static int count;// count the number of withdraws
	private double balance;// Instance variable to store the balance

	public Account() {

	}

	// Setter method for the balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// Getter method of the balance
	public double getBalance() {
		return this.balance;
	}

	/**
	 * 
	 * Throws InsufficientFunds exception if balance becomes below zero otherwise
	 * deducts the withdrawal amount from the balance in addition after four
	 * withdrawals from either account a service charge of $1.50 is applied
	 * thereafter
	 * 
	 * @param withdrawAmount
	 * @throws InsufficientFunds
	 */

	public void withdraw(double withdrawAmount) throws InsufficientFunds {

		if (this.balance - withdrawAmount < 0) {
			throw new InsufficientFunds();
		}

		this.balance = this.balance - withdrawAmount;
		count++;
		if (count > 4) {

			this.balance = this.balance - 1.5;

		}

	}

	/**
	 * 
	 * Adds the deposited amount to the balance
	 * 
	 * @param depositAmount
	 */
	public void deposit(double depositAmount) {
		this.balance = this.balance + depositAmount;
	}

	/**
	 * 
	 * Adds the transferAmount amount to the balance
	 * 
	 * @param transferAmount
	 */

	public void transferTo(double transferAmount) {
		this.balance = this.balance + transferAmount;
	}

	/**
	 * 
	 * Throws InsufficientFunds exception if balance becomes below zero otherwise
	 * deducts the transfer amount from the balance
	 * 
	 * @param transferAmount
	 * @throws InsufficientFunds
	 */
	public void transferFrom(double transferAmount) throws InsufficientFunds {

		if (this.balance - transferAmount < 0) {
			throw new InsufficientFunds();
		}

		this.balance = this.balance - transferAmount;
	}
}