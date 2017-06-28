// Java program to implement merge sort in singly linked list

// Linked List Class
class LinkedList {

	static Node head; // head of list

	/* Node Class */
	static class Node {

		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}

	// Split a doubly linked list (DLL) into 2 DLLs of
	// half sizes
	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);
		//print(node);
		//print(second);

		// Recur for left and right halves
		node = mergeSort(node);
		second = mergeSort(second);

		// Merge the two sorted halves
		return merge(node, second);
	}

	Node merge(Node first, Node second) {
        // If first linked list is empty
        if (first == null) {
            return second;
        }
 
        // If second linked list is empty
        if (second == null) {
            return first;
        }
 
        // Pick the smaller value
        if (first.data < second.data) {
            first.next = merge(first.next, second);
           
            return first;
        } else {
            second.next = merge(first, second.next);
            
            return second;
        }
    }

	// Driver program to test above functions
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.head = new Node(10);
		list.head.next = new Node(30);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(20);
		list.head.next.next.next.next.next = new Node(5);
		
		
		Node node = null;
		node = list.mergeSort(head);
		System.out.println("Linked list after sorting :");
		list.print(node);

	}
}

// This code has been contributed by Mayank Jaiswal
