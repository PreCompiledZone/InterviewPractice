package practice.interview.questions;

public class FindMiddleElementLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int tmp) {
			data = tmp;
		}
	}

	// traverse double and find using count
	static void printMiddleElementV1(Node head) {
		Node countNode = head;
		int count = 0;
		// find count or length if linked list
		while (countNode != null) {
			countNode = countNode.next;
			count++;
		}

		count = count / 2;
		while (head != null) {
			head = head.next;
			count--;
			if (count == 0) {
				System.out.println("Middle Element by method1 is : " + head.data);
			}
		}

	}

	// using single and double increment nodes
	static void printMiddleElementV2(Node head) {
		Node singleInc = head;
		Node doubleInc = head;

		while (doubleInc != null && doubleInc.next != null) {
			doubleInc = doubleInc.next.next;
			singleInc = singleInc.next;
		}

		System.out.println("Middle element by method2 is : " + singleInc.data);
	}

	public static void main(String[] args) {

		Node n1 = new Node(45);
		Node n2 = new Node(21);
		Node n3 = new Node(1);
		Node n4 = new Node(78);
		Node n5 = new Node(65);
		Node n6 = new Node(9);
		Node n7 = new Node(90);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		printMiddleElementV1(n1);
		printMiddleElementV2(n1);

	}
}
