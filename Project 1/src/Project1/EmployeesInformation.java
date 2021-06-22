package Project1;

/**
 * 
 * 
 * File: EmployeeInformation.java  
 * Author: Bedemariam Degef
 * Date: September 1, 2019
 * purpose: Read and display employee information 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class EmployeesInformation {

	public static void main(String[] args) throws ParseException {

		Employee[] employees2014 = new Employee[10];// used to store 2014 employees info
		Employee[] employees2015 = new Employee[10];// used to store 2014 employees info

		Employee employee = null;

		int count2014 = 0; // used to count 2014 employees
		int count2015 = 0; // used to count 2015 employees
		double annualSalary2014 = 0;// used to calculate 2014 employees annual salary
		double annualSalary2015 = 0;// used to count 2015 employees annual salary
		Scanner file = null;
		String annualSale;
		String stock;
		try {
			file = new Scanner(new File("Employees.rtf"));// Opening and reading the file

			/**
			 * The while loop checks every Strings in the file and adds it to the
			 * appropriate array
			 * 
			 */
			while (file.hasNext())

			{
				 

				String year = file.next();
				String position = file.next();
				String name = file.next();
				String monthlySalary = file.next();

				if (year.equals("2014") && position.equals("Employee")) {
					NumberFormat a = NumberFormat.getInstance(); 
					double monthly_Salary = a.parse(monthlySalary).doubleValue();
					employee = new Employee(name, monthly_Salary);

					employees2014[count2014] = employee;

					count2014++;
					annualSalary2014 += employee.annualSalary();
					file.nextLine();
				}
				if (year.equals("2014") && position.equals("Salesman")) {
					annualSale = file.next();
					NumberFormat b = NumberFormat.getInstance(); 
					double monthly_Salary = b.parse(monthlySalary).doubleValue();
					double annual_Sale  = b.parse(annualSale).doubleValue();
					employee = new Salesman(name, monthly_Salary, annual_Sale);
					employees2014[count2014] = employee;
					count2014++;
					annualSalary2014 += employee.annualSalary();
					file.nextLine();
				}
				if (year.equals("2014") && position.equals("Executive")) {
					stock = file.next();
					NumberFormat c = NumberFormat.getInstance(); 
					double monthly_Salary = c.parse(monthlySalary).doubleValue();
					double stock_P  = c.parse(stock).doubleValue();
					employee = new Executive(name, monthly_Salary, stock_P);
					employees2014[count2014] = employee;
					count2014++;
					annualSalary2014 += employee.annualSalary();
					file.nextLine();
				}
				if (year.equals("2015") && position.equals("Employee")) {
					NumberFormat d = NumberFormat.getInstance();
					double monthly_Salary = d.parse(monthlySalary).doubleValue();
					employee = new Employee(name, monthly_Salary);
					employees2015[count2015] = employee;

					count2015++;
					annualSalary2015 += employee.annualSalary();
					file.nextLine();

				}
				if (year.equals("2015") && position.equals("Salesman")) {
					annualSale = file.next();
					NumberFormat e = NumberFormat.getInstance(); 
					double monthly_Salary = e.parse(monthlySalary).doubleValue();
					double annual_Sale  = e.parse(annualSale).doubleValue();
					employee = new Salesman(name, monthly_Salary, annual_Sale);
					employees2015[count2015] = employee;
					count2015++;
					annualSalary2015 += employee.annualSalary();
					file.nextLine();

				}
				if (year.equals("2015") && position.equals("Executive")) {
					stock = file.next();
					NumberFormat f = NumberFormat.getInstance(); 
					double monthly_Salary = f.parse(monthlySalary).doubleValue();
					double stock_P  = f.parse(stock).doubleValue();
					employee = new Executive(name, monthly_Salary, stock_P);
					employees2015[count2015] = employee;
					count2015++;
					annualSalary2015 += employee.annualSalary();
					file.nextLine();

				}

			}
			
			 file.close();

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Displays 2014 Employees
		System.out.println("Employees from 2014");
		System.out.println();
		for (Employee e : employees2014) {

			if (e==null) {
				
				System.out.print("");
			}
			else{
				System.out.println("2014"+"\t"+e.getClass().getName()+"\t"+e.toString());
			}

		}

		// calculate and display average salary for 2014 employees
		Double averageSalary2014 = annualSalary2014 / employees2014.length;
		System.out.println("The average salary in 2014 is " + averageSalary2014);

		// Displays 2015 Employees
		System.out.println();
		System.out.println("Employees from 2015");
		System.out.println();

		for (Employee e : employees2015) {
	if (e==null) {
				
		System.out.print("");
			}else {
			System.out.println("2015"+"\t"+e.getClass().getName()+"\t"+e.toString());
			}
		}
		// calculate and display average salary for 2015 employees
		Double averageSalary2015 = annualSalary2015 / employees2015.length;
		System.out.println("The average salary in 2014 is " + averageSalary2015);

	
		System.out.println(employees2014[0]);
	

	}

}
