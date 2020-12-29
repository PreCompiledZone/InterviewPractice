package practice.interview.questions;

public class RemoveDuplicateSortedLinkedList {

	static class Node
	{
		int data;
		Node next;
		public Node(int tmp) {
			data = tmp;
		}
	}
	
	static void removeDuplicate(Node head)
	{
		while(head != null)
		{
			Node temp = head;
			
			while(temp != null && temp.data == head.data)
			{
				temp = temp.next;
			}
			
			head.next = temp;
			head = head.next;	
		}
	}
	
	static void print(Node head)
	{
		while(head != null)
		{
			System.out.println(head.data);
			head = head.next;
		}
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
		
		System.out.println("Before deleting duplicate : ");
		print(n1);
		
		removeDuplicate(n1);
		System.out.println("After deleting duplicate : ");
		print(n1);
		
	}
}
