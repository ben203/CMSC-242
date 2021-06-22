
/**
 *  
 * File: InsufficientFunds.java  
 * Author: Bedemariam Degef
 * Date: September 11, 2019
 * Purpose: This class is used to throw an error when the balance is below zero 
 * 	
 * 		 
 */

import javax.swing.*;

/**
 * 
 * User defined checked exception which is executed when the balance becomes
 * below zero
 * 
 */

public class InsufficientFunds extends Exception {

	public InsufficientFunds() {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "You have insufficient Funds ");
	}
}