
public class Problem_20 {
	// Node is a linked list data structure
	static class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	static int Solve(Node head1,Node head2)
	{
		int c1 = getLength(head1);
		int c2 = getLength(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return getIntesectionNode(d, head1, head2);
		}
		else {
			d = c2 - c1;
			return getIntesectionNode(d, head2, head1);
		}
	}
	// returns size of linked list
	public static int getLength(Node head) {
		int length = 0;
		while(head.next!=null) {
			head = head.next;
			length++;
		}
		return length;
	}
	// returns value at intersection node
	public static int getIntesectionNode(int d,Node node1,Node node2) {
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for (i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		//System.out.println(d);
		return -1;
	}
	
	public static void main(String[] args) {
				// creating linked list 1
				Node head1 = new Node(1);
				head1.next = new Node(2);
				head1.next.next = new Node(3);
				head1.next.next.next = new Node(4);
				head1.next.next.next.next = new Node(5);

				// creating linked list 2
				Node head2 = new Node(10);
				head2.next = new Node(15);
				head2.next.next = new Node(4);
				head2.next.next.next = new Node(5);

				System.out.println("The intersection node is " + Solve(head1, head2));
	}

}
