package practice.interview.questions;

/**
 * @author akash
 */
public class DivideWithoutOperator {

	public static void main(String[] args) {
		int a = 9;
		int b = 3;

		System.out.println("Result - " + divide(a, b));
	}

	static int divide(int numerator, int denominator) {
		int sign = ((numerator < 0) ^ (denominator < 0)) ? -1 : 1;

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		int quotient = 0;

		while (numerator >= denominator) {
			numerator -= denominator;
			++quotient;
		}

		return sign * quotient;
	}

}
