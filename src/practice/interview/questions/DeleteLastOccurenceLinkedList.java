package practice.interview.questions;

public class DeleteLastOccurenceLinkedList {

	static class Node {
		private int key;
		private Node next;

		Node(int tmp) {
			key = tmp;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
		
	}

	// traverse double and find using count
	static void deleteElement(Node head,int element) {
		Node prev = null;
		Node temp = null;
		
		while(head != null)
		{
			if(head.next!=null && head.next.getKey()==element)
	        {
	        prev=head;
	        temp=head.next;
	        }
			head=head.next;
	    }
	    prev.next=temp.next;
	}
	
	static void print(Node head) {
		
		while(head != null)
		{
			System.out.println(head.getKey());
			head = head.next;
	    }
	    
	}
	
	public static void main(String[] args) {

		Node n1 = new Node(65);
		Node n2 = new Node(21);
		Node n3 = new Node(1);
		Node n4 = new Node(21);
		Node n5 = new Node(65);
		Node n6 = new Node(21);
		Node n7 = new Node(90);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		deleteElement(n1, 65);
		print(n1);
		
//		printMiddleElementV1(n1);
//		printMiddleElementV2(n1);

	}
}
