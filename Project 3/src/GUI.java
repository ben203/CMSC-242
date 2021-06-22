
/**
 * 
 * File: GUI.java 
 * Author: Bedemariam Degef 
 * Date: September 20, 2019 
 * Purpose:This class is used to design the GUI
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;

public class GUI extends JFrame implements ActionListener {

	/**
	 * 
	 * Different objects are created in order to be added to the GUI frame
	 * 
	 */
	private JFrame frame = new JFrame();
	private JRadioButton recursiveButton = new JRadioButton("Recursive");
	private JRadioButton iterativeButton = new JRadioButton("Iterative");
	private JButton computeButton = new JButton("Compute");
	private JTextField textField = new JTextField();
	private JTextField resultTextField = new JTextField();
	private JTextField efficiencyTextField = new JTextField();
	private ButtonGroup group = new ButtonGroup();

	/**
	 * 
	 * A constructor creates the GUI
	 * 
	 */
	public GUI() {

		frame.setTitle("Project 3");

		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		group.add(recursiveButton);
		group.add(iterativeButton);
		iterativeButton.setSelected(true);

		iterativeButton.setActionCommand("iterative");
		recursiveButton.setActionCommand("recursive");
		computeButton.setActionCommand("compute");
		iterativeButton.addActionListener(GUI.this);
		recursiveButton.addActionListener(GUI.this);
		computeButton.addActionListener(GUI.this);

		frame.setLayout(new GridLayout(6, 2, 3, 3));

		frame.add(new JLabel(""));
		frame.add(iterativeButton);
		frame.add(new JLabel(""));
		frame.add(recursiveButton);
		frame.add(new JLabel("Enter n:"));
		frame.add(textField);
		frame.add(new JLabel(""));
		frame.add(computeButton);
		frame.add(new JLabel("Result:"));
		frame.add(resultTextField);
		frame.add(new JLabel("Efficiency:"));
		frame.add(efficiencyTextField);
		frame.addWindowListener(new WindowAdapterImpl());
		 
		frame.setVisible(true);
		pack();
		 
	}

	/**
	 *
	 * The action performed when the button is clicked
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();

		String result = "";
		String input = textField.getText();
		if (event.equals("compute")) {

			if (input.matches("\\d+") && Integer.parseInt(input) >= 0) {

				if (iterativeButton.isSelected()) {
					result = "" + Sequence.computeIterative(Integer.parseInt(input));
				} else if (recursiveButton.isSelected()) {
					result = "" + Sequence.computeRecursive(Integer.parseInt(input));
				}
				resultTextField.setText(result);
				efficiencyTextField.setText("" + Sequence.getEfficiency());

			} else {
				JOptionPane.showMessageDialog(frame, "Please enter a valid numerical value");
				textField.setText("");
			}
		}

	}

	/**
	 * 
	 * A class that computes the efficiency values of n from 0 to 10 and write them
	 * on a file
	 * 
	 */
	private static class WindowAdapterImpl extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			try {
				int iterative;
				int recursive;

				FileWriter file = new FileWriter("Efficiency.txt");

				for (int n = 0; n <= 10; n++) {
					Sequence.computeIterative(n);
					iterative = Sequence.getEfficiency();
					Sequence.computeRecursive(n);
					recursive = Sequence.getEfficiency();

					file.write(n + "," + iterative + "," + recursive + "\n");
				}
				file.close();
			} catch (Exception IO) {
				System.err.println("There was a problem writing the sequences on file");
				System.exit(0);
			}
		}
	}

	/**
	 * 
	 * A main method to execute the program
	 * 
	 */
	public static void main(String[] args) {
		 new GUI();

	}

}