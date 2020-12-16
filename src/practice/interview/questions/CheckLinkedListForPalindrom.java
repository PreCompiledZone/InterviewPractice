package practice.interview.questions;

import java.util.Stack;

//using stack
public class CheckLinkedListForPalindrom {

	static class Node {
		int data;
		Node next;

		public Node(int tmp) {
			data = tmp;
		}
	}

	static boolean isPalindrom(Node head) {
		Node tempNode = head;
		Stack<Integer> stack = new Stack<Integer>();

		while (tempNode != null) {
			stack.push(tempNode.data);
			tempNode = tempNode.next;
		}
		while (head != null) {
			if (head.data != stack.pop())
				return false;
			head = head.next;
		}
		return true;
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(7);
		Node n3 = new Node(3);
		Node n4 = new Node(7);
		Node n5 = new Node(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println("Is it palindrom : " + isPalindrom(n1));

	}

}
