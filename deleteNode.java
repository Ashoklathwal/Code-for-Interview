// delete first node of linked list

public void deleteFirstNode(Node head)
{
	// list is empty
	if(head == null)
		return;
	if(head.next == null)
		// only one node list cant be made empty
		return;
	Node head1 = head;
	head1=head1.next;
	head = head1;
	System.gc();
}

// delete last node of the linked list


public void deleteLastNode(Node head)
{
	// list is empty
	if(head == null)
		return;
	if(head.next == null)
		// only one node, list can't be made empty
		return;
	Node head1 = head;
	while(head1.next.next != null)
	{
      head1 = head1.next;
	}
	head1.next = null;
	System.gc();
}

// delete node with data x in linked list

public void deleteNodeWithDatax(Node head)
{
	// list is empty
	if(head == null)
		return;
	if(head.next == null)
		// only one node, list can't be made empty
		return;
	Node head1 = head;
	// maintain one previous pointer
	Node prev;
	while(head1.next != null && head1.data != x)
	{
	  prev = head1;	
      head1 = head1.next;
	}
	if(head1.data == x)
	{
		prev.next = head1.next;
	    System.gc();

	}
	else
		// node not found
	
}
