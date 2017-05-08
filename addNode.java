// add the node with value x in linked list at the end

public Node insertAtEnd(Node head, int x)
{
	Node temp = new Node(x);
	if(head == null)
	{
		head = temp;
		return head;
	}
	Node head1 = head;
	while(head1 != null)
	{
		head1 = head1.next;
	}
	head1.next = temp;
    return head;
} 

// add node with value x in starting of linked list

public Node insertAtBegining(Node head, int x)
{
	Node temp = new Node(x);
	if(head == null)
	{
		head = temp;
		return head;
	}
	
    temp.next = head;
	head = temp;
    return head;
} 

// add node with value x after a node with data y

public Node insertAfterNodeWithValuey(Node head, int x, int y)
{
	Node temp = new Node(x);
	if(head == null)
	{
		// no y exist
		return head;
	}
	Node head1 = head;
	// if node is in between
	while(head1.data != y && head1.next != null)
	{
		head1 = head1.next;
	}
	if(head1.data == y)
	{
		// order matter
		temp.next = head1.next;
		head1.next = temp;

	}
	}
    return head;
} 