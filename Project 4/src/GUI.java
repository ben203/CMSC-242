/**
 * 
 * File: GUI.java 
 * Author: Bedemariam Degef 
 * Date: October 7, 2019 
 * Purpose:This class handles the database interactions
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GUI extends JFrame implements ActionListener {

	// A new frame for the GUI
	private JFrame frame = new JFrame();

	// Options for the dialog boxes
	private JComboBox<String> choose = new JComboBox<>(options);
	private static String[] options = { "Insert", "Delete", "Find", "Update" };
	private static String[] grades = { "A", "B", "C", "D", "F" };
	private static String[] credit = { "3", "6" };

	// Labels on the GUI
	private JLabel id = new JLabel("Id: ");
	private JLabel name = new JLabel("Name: ");
	private JLabel major = new JLabel("Major: ");
	private JLabel selection = new JLabel("Choose Selection: ");

	// Text fields for user input and button to process the request
	private JTextField textFieldForId = new JTextField();
	private JTextField textFieldForname = new JTextField();
	private JTextField textFieldFormajor = new JTextField();
	private JButton computeButton = new JButton("Process Request");

	// A hashmap object to store the data
	private HashMap<String, Student> database = new HashMap<>();

	/**
	 * A constructor that creates the GUI
	 * 
	 */
	public GUI() {
		super("Project4");

		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setLayout(new GridLayout(6, 2));

		frame.add(id);
		frame.add(textFieldForId);

		frame.add(name);
		frame.add(textFieldForname);
		frame.add(major);
		frame.add(textFieldFormajor);
		frame.add(selection);
		frame.add(choose);
		computeButton.addActionListener(this);
		frame.add(computeButton);
		frame.setVisible(true);

	}

	/**
	 * A main method to execute the program
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				new GUI();

			}
		});
	}

	/**
	 * The action performed when the process request button is clicked
	 * 
	 */

	public void actionPerformed(ActionEvent event) {
		// Reads the text inputs
		String id = textFieldForId.getText();
		String name = textFieldForname.getText();
		String major = textFieldFormajor.getText();

		// A new student object is created
		Student st = new Student(name, major);

		// Selected command from the drop box
		String selected = (String) choose.getSelectedItem();

		// Performs selected tasks
		switch (selected) {
		case "Insert":
			if (database.containsKey(id)) {
				JOptionPane.showMessageDialog(null, "The student is already in the database");
			} else {
				database.put(id, st);
				JOptionPane.showMessageDialog(null, "The student is added to the database");
			}

			break;
		case "Delete":
			if (database.containsKey(id)) {
				database.remove(id);
				JOptionPane.showMessageDialog(null, "The student is removed from the database");

			} else {
				JOptionPane.showMessageDialog(null, "The student is not in our database");
			}
			break;

		case "Find":
			if (database.containsKey(id)) {
				st = database.get(id);
				JOptionPane.showMessageDialog(null, st.toString());
			} else {

				JOptionPane.showMessageDialog(null, "The student is not in our database");

			}
			break;
		case "Update":
			if (database.containsKey(id)) {
				String grade = (String) JOptionPane.showInputDialog(null, "Choose Grades: ", "",
						JOptionPane.INFORMATION_MESSAGE, null, grades, "");
				String creditHours = (String) JOptionPane.showInputDialog(null, "Choose Credit: ", "",
						JOptionPane.INFORMATION_MESSAGE, null, credit, "");
				st.courseCompleted(grade.charAt(0), Integer.parseInt(creditHours));

				database.put(id, st);
			} else {

				JOptionPane.showMessageDialog(null, "The student is not in our database");

			}
			break;

		}
	}
}