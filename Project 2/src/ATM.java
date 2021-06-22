
/** 
 * 
 * File: ATM.java Author: 
 * Bedemariam Degef 
 * Date: September 11, 2019 
 * Purpose:This class is used for the layout design and function of the GUI
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ATM extends JFrame {

	// Window and text field size
	private static final int WINDOW_WIDTH = 380;
	private static final int WINDOW_HEIGHT = 230;
	private static final int TEXT_WIDTH = 200;
	private static final int TEXT_HEIGHT = 30;

	// The four buttons for the GUI
	private JButton withdrawButton = new JButton("Withdraw");
	private JButton depositButton = new JButton("Deposit");
	private JButton transferToButton = new JButton("Transfer");
	private JButton balanceButton = new JButton("Balance");

	// Objects for the checking and savings account
	private static Account checking = new Account();
	private static Account savings = new Account();

	// Radio buttons for the two objects
	private JRadioButton checkingRadio = new JRadioButton("Checking");
	private JRadioButton savingsRadio = new JRadioButton("Savings");

	private JTextField textField = new JTextField("");// A text field for the input
	private ButtonGroup radioButtons = new ButtonGroup();// A button groups for the radio buttons
	private JOptionPane frame = new JOptionPane();// A frame for the JOptionPane window

	// Currency format
	private static DecimalFormat df = new DecimalFormat("$0.00");

	/**
	 * A constructor that creates the GUI and initialize the objects
	 * 
	 * @param checkingStartingBalance
	 * @param savingsStartingBalance
	 */
	public ATM(double checkingStartingBalance, double savingsStartingBalance) {

		super("ATM Machine");// Name of the GUI
		setLayout(new GridBagLayout());// Sets the type of layout
		GridBagConstraints layout = new GridBagConstraints();// Creates new grid layout
		layout.gridy = 1;
		setFrame(WINDOW_WIDTH, WINDOW_HEIGHT);// set the size of the displayed window

		// Creating the panels in order to add them to the JFrame
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();

		// Adding the button and text panels to the JFrame
		add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
		add(textPanel, layout);
		textPanel.setLayout(new GridLayout(1, 1));

		// Adding the buttons and radio buttons to the panel
		buttonPanel.add(withdrawButton);
		buttonPanel.add(depositButton);
		buttonPanel.add(transferToButton);
		buttonPanel.add(balanceButton);
		buttonPanel.add(checkingRadio);
		buttonPanel.add(savingsRadio);

		// Adding all radio buttons to radio button group
		radioButtons.add(checkingRadio);
		radioButtons.add(savingsRadio);

		checkingRadio.setSelected(true);// Selects the checking radio button
		textField.setPreferredSize(new Dimension(TEXT_WIDTH, TEXT_HEIGHT));// sets the size of the text field
		textPanel.add(textField);// Adding the text field to the Panel

		// Initialize the two objects with the starting balance
		checking.setBalance(checkingStartingBalance);
		savings.setBalance(savingsStartingBalance);

		// Performs the action listeners
		withdrawButton.addActionListener(new WithdrawButtonListener());
		depositButton.addActionListener(new DepositButtonListener());
		transferToButton.addActionListener(new TransferToButtonListener());
		balanceButton.addActionListener(new BalanceButtonListener());

	}

	// Sets the window size for the GUI
	private void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Tries to convert the input into a double and throws an error if it fails
	public double getEntryValue() {
		try {
			return Double.parseDouble(textField.getText());
		} catch (NumberFormatException e) {
			System.out.println("Caught in main ");

			return 0;
		}
	}

	/**
	 * An action listener for the withdrawal button in order to withdraw the amount
	 * provided by the user when clicked
	 *
	 */

	class WithdrawButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				if (getEntryValue() > 0 && getEntryValue() % 20 == 0) {

					if (checkingRadio.isSelected()) {
						checking.withdraw(getEntryValue());
						JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) + " withdrawn from Checking.");
					} else if (savingsRadio.isSelected()) {
						savings.withdraw(getEntryValue());
						JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) + " withdrawn from Savings.");
					}
					textField.setText("");
				} else
					JOptionPane.showMessageDialog(frame, "Please enter a valid amount with $20 increments.");
				textField.setText("");
			} catch (InsufficientFunds insufficientFunds) {
				System.out.println("Caught in main.");
			}
		}
	}

	/**
	 * An action listener for the deposit button in order to deposit the amount
	 * provided by the user when clicked
	 *
	 */

	class DepositButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (getEntryValue() > 0) {

				if (checkingRadio.isSelected()) {
					checking.deposit(getEntryValue());
					JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) + " deposited into Checking.");
				} else if (savingsRadio.isSelected()) {
					savings.deposit(getEntryValue());
					JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) + " deposited into Savings.");
				}
				textField.setText("");
			} else
				JOptionPane.showMessageDialog(frame, "Please enter a numeric amount");
			textField.setText("");
		}
	}

	/**
	 * An action listener for the transfer button in order to transfer the amount
	 * provided by the user into the selected account type when clicked
	 *
	 */
	class TransferToButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				if (getEntryValue() > 0) {

					if (checkingRadio.isSelected()) {

						savings.transferFrom(getEntryValue());
						checking.transferTo(getEntryValue());
						JOptionPane.showMessageDialog(frame,
								df.format(getEntryValue()) + " transferred from Savings to Checking.");
					} else if (savingsRadio.isSelected()) {
						checking.transferFrom(getEntryValue());
						savings.transferTo(getEntryValue());
						JOptionPane.showMessageDialog(frame,
								df.format(getEntryValue()) + " transferred from Checking to Savings.");
					}
					textField.setText("");
				} else
					JOptionPane.showMessageDialog(frame, "Please enter a numeric amount");
				textField.setText("");
			} catch (InsufficientFunds insufficientFunds) {
				System.out.println("Caught in main.");
			}
		}
	}

	/**
	 * An action listener for the balance button in order to check the account's
	 * balance when clicked
	 *
	 */

	class BalanceButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (checkingRadio.isSelected()) {
				JOptionPane.showMessageDialog(frame,
						"Your checking account balance is: " + df.format(checking.getBalance()));
			} else if (savingsRadio.isSelected()) {
				JOptionPane.showMessageDialog(frame,
						"Your savings account balance is: " + df.format(savings.getBalance()));
			}
		}
	}

	// The main method will run the GUI
	public static void main(String[] args) {

		ATM frame = new ATM(100, 100);
		frame.setVisible(true);

	}

}
