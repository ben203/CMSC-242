package Project1;

/**
 * 
 * 
 * File: Employee.java  
 * Author: Bedemariam Degef
 * Date: September 1, 2019
 * purpose: A super class used to store 
 * 			employee name and monthly salary   
 * 
 */

import java.text.NumberFormat;

public class Employee {

	private String name;

	private double monthlySalary;

	// An object created to be used to get wholeDollar format
	NumberFormat wholeDollar = NumberFormat.getCurrencyInstance();

	/**
	 * A constructor used to assign the name and monthly salary
	 * 
	 */
	public Employee(String name, double monthlySalary) {

		this.name = name;
		this.monthlySalary = monthlySalary;
	}

	/**
	 * 
	 * return the annualSalary
	 * 
	 * @return
	 */
	public double annualSalary() {

		return monthlySalary * 12;
	}

	/**
	 * String representation of the employee
	 * 
	 */
 
	public String toString() {

		return  " Name: " + name + " 	" + "Monthly Salary: " + wholeDollar.format(monthlySalary) + "	 ";
	}

}
