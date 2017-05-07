// Java program to detect and remove loop in linked list

class LinkedList 
{
	static Node head;
	static class Node 
	{
		int data;
		Node next;
		Node(int d) 
		{
			data = d;
			next = null;
		}
	}
	// Function that detects loop in the list
	void detectAndRemoveLoop(Node node) 
	{
		Node slow = node;
		Node fast = node.next;
		// Search for loop using slow and fast pointers
		while (slow != null && slow.next != null && fast != null && fast.next != null && fast.next.next != null) 
		{
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		/* If loop exists */
		if (slow == fast) 
		{
			slow = node;
			while (slow != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			/* since fast->next is the looping point */
			fast.next = null; /* remove loop */
		}
	}
	// Function to print the linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	// Driver program to test above functions
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		list.head = new Node(50);
		list.head.next = new Node(20);
		list.head.next.next = new Node(15);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(10);
		// Creating a loop for testing 
		head.next.next.next.next.next = head.next.next;
		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}
}
