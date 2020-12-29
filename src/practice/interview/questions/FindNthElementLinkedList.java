package practice.interview.questions;

public class FindNthElementLinkedList {

	static class Node {
		int data;
		Node next;

		public Node(int temp) {
			data = temp;
		}
	}

	static Node findNthElementV1(Node head, int n) {
		int length = 0;
		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			length++;
		}

		for (int i = 0; i < length - n; i++) {
			head = head.next;
		}

		return head;
	}

	public static void main(String[] args) {

		Node n1 = new Node(23);
		Node n2 = new Node(56);
		Node n3 = new Node(56);
		Node n4 = new Node(78);
		Node n5 = new Node(98);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		int n = 3;
		
		Node nthNode = findNthElementV1(n1, n);
		System.out.println(n+"th data -> "+nthNode.data);
		
	}

}
