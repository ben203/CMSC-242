package Project1;

/**
 * 
 * 
 * File: Employee.java  
 * Author: Bedemariam Degef
 * Date: September 1, 2019
 * purpose: A subclass class used to get appropriate  
 * 			compensation for an executive employee  
 * 
 */

import java.text.NumberFormat;

public class Executive extends Employee {

	private double stockPrice;

	// An object created to be used to get wholeDollar format
	NumberFormat wholeDollar = NumberFormat.getCurrencyInstance();

	/**
	 * 
	 * A constructor used to assign the name, monthly salary and stock price for the
	 * executive employee
	 * 
	 * @param name
	 * @param monthlySalary
	 * @param stockPrice
	 */

	public Executive(String name, double monthlySalary, double stockPrice) {
		super(name, monthlySalary);
		this.stockPrice = stockPrice;

	}

	/**
	 * 
	 * An override method to determine the annual salary
	 * 
	 */
	@Override
	public double annualSalary() {
		double income = 0;
		if (stockPrice > 50) {

			income = super.annualSalary() + 30000;
		} else {
			income = super.annualSalary();
		}
		return income;
	}

	/**
	 * 
	 * An override method used to represent the executive employee
	 * 
	 */

	@Override
	public String toString() {

		return  super.toString() + "	 " + "Stock Price: " + wholeDollar.format(stockPrice);
	}

}
