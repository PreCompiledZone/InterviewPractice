package interview.test.solutions;

import java.util.Stack;

/**
 * 
 * @author amol
 *
 * Program to Show Arithmetic Expression is balanced or not
 *
 */
public class BalancedParantheses {

	static boolean checkForBalancedParantheses(String expr) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < expr.length(); i++) {
			char x = expr.charAt(i);

			if (x == '(') {
				stack.push(x);
				continue;
			}

			
			
			if (x == ')') {
				if(stack.isEmpty())
					return false;
				else
					stack.pop();
			}

		}

		// empty stack = balanced parantheses
		return (stack.isEmpty());
	}

	public static void main(String[] args) {

		// test case 1
		String test1 = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
		boolean res1 = checkForBalancedParantheses(test1);
		System.out.println("Test case 1 (positive scenario) '" + test1 + "' : " + res1);

		// test case 2
		String test2 = "(2+5)*8/2)";
		boolean res2 = checkForBalancedParantheses(test2);
		System.out.println("Test case 1 (negative scenario) '" + test2 + "' : " + res2);

	}

}
