package Project1;

/**
 * 
 * 
 * File: Employee.java  
 * Author: Bedemariam Degef
 * Date: September 1, 2019
 * purpose: A subclass class used to get appropriate  
 * 			compensation for an salesman employee  
 * 
 */

import java.text.NumberFormat;

public class Salesman extends Employee {

	private double annualSale;

	// An object created to be used to get wholeDollar format
	NumberFormat wholeDollar = NumberFormat.getCurrencyInstance();

	/**
	 * 
	 * The constructor assigns the name and monthly, yearly salaries of the sales
	 * man employee
	 * 
	 * @param name
	 * @param monthlySalary
	 * @param annualSale
	 */
	public Salesman(String name, double monthlySalary, double annualSale) {
		super(name, monthlySalary);

		this.annualSale = annualSale;
	}

	/**
	 * 
	 * An override method used to calculate the annual salary for the salesman
	 * employee
	 * 
	 */
	@Override
	public double annualSalary() {
		double income = 0;
		if (super.annualSalary() / .02 < 20000) {
			income = super.annualSalary() + (super.annualSalary() / .02);
		}

		else {
			income = super.annualSalary() + 20000;
		}

		return income;
	}

	/**
	 * 
	 * An override method used to represent the salesman employee
	 * 
	 */
	@Override
	public String toString() {

		return super.toString() + " 	" + "Annual Sales: " + wholeDollar.format(annualSale);
	}

	public double getannualSale() {

		return annualSale;
	}

}
