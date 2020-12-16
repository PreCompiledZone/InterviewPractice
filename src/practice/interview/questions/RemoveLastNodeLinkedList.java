package practice.interview.questions;

public class RemoveLastNodeLinkedList {

	static class Node {
		int data;
		Node next;

		public Node(int tmp) {
			data = tmp;
		}
	}

	static void printLinkedList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	static Node removeLastElement(Node head) {
		if (head == null || head.next == null)
			return null;

		while (head.next.next != null) {
			head = head.next;
		}

		head.next = null;

		return head;
	}

	public static void main(String[] args) {

		Node n1 = new Node(41);
		Node n2 = new Node(18);
		Node n3 = new Node(78);
		Node n4 = new Node(6);
		Node n5 = new Node(55);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		System.out.println("Printing linked list initially -> ");
		printLinkedList(n1);

		// remove last element from linked list
		removeLastElement(n1);
		System.out.println("After removal of last node");
		printLinkedList(n1);
	}

}
