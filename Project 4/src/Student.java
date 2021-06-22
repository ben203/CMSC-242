/**
 * 
 * File: Student.java 
 * Author: Bedemariam Degef 
 * Date: October 7, 2019
 * Purpose:This class defines the student record
 * 
 */

public class Student {
	private String name;
	private String major;
	private int totalCreditsCompleted;
	private int qualityPoints;

	/**
	 * A constructor that creates a new student with 0 GPA
	 * 
	 * @param name
	 * @param major
	 */
	public Student(String name, String major) {
		this.name = name;
		this.major = major;
		this.totalCreditsCompleted = 0;
		this.qualityPoints = 0;
	}

	/**
	 * Updates the total credits completed and quality points
	 * 
	 * @param grade
	 * @param creditHours
	 */
	public void courseCompleted(char grade, int creditHours) {
		this.totalCreditsCompleted = creditHours;
		int Points = 0;
		switch (grade) {
		case 'A':
			Points = 4;
			break;
		case 'B':
			Points = 3;
			break;
		case 'C':
			Points = 2;
			break;
		case 'D':
			Points = 1;
			break;

		case 'F':
			Points = 0;
			break;

		}

		this.qualityPoints = Points * creditHours;

	}

	/**
	 * Overrides toString method and returns a labeled string containing the student
	 * name, major and GPA.
	 * 
	 */
	@Override
	public String toString() {
		double gpa;
		if (totalCreditsCompleted == 0) {
			gpa = 4.0;
		} else {
			gpa = qualityPoints / totalCreditsCompleted;
		}

		return "Name : " + name + "\n Major : " + major + "\n GPA : " + gpa;

	}

}