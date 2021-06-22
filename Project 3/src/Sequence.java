/**
 * 
 * File: Sequence.java 
 * Author: Bedemariam Degef 
 * Date: September 20, 2019
 * Purpose:This class calculates the sequence using iterative and recursive ways
 * 
 */
public class Sequence {

	private static int efficiency = 0; // efficiency count

	/**
	 * 
	 * Computing the values iteratively and updating the efficiency count with the
	 * number of iterations of the loop
	 * 
	 * @param n
	 * @return
	 */
	public static int computeIterative(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int current = 1;
		int previous = 0;
		int result = 0;
		efficiency = 0;

		for (int i = 1; i < n; i++) {
			result = (current * 2) + previous;
			previous = current;
			current = result;
			efficiency++;
		}
		return result;
	}

	/**
	 * 
	 * Computing the values recursively and updating the efficiency count with every
	 * method call
	 * 
	 * @param n
	 * @return
	 */
	public static int computeRecursive(int n) {
		efficiency++;

		if (n == 0) {

			return 0;
		}
		if (n == 1) {

			return 1;
		}

		return ((2 * computeRecursive(n - 1)) + (computeRecursive(n - 2)));
	}

	/**
	 * 
	 * Efficiency getter in order to be used when writing the values on a file
	 * 
	 */

	static int getEfficiency() {
		return efficiency;
	}
}