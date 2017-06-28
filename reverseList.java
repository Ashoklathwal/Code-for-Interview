/*Input : Head of following linked list  
       1->2->3->4->NULL
Output : Linked list should be changed to,
       4->3->2->1->NULL

Input : Head of following linked list  
       1->2->3->4->5->NULL
Output : Linked list should be changed to,
       5->4->3->2->1->NULL*/

public Node reverse(Node head)
{
	Node p = null, q = null, r = head;
	while(r != null)
	{
		// order matter
		// p is previous, q is next, r is current 
		p = q;
		q = r;
		r = r.next; // pointing to next node
		q.next = p; // make pointer to previous node
		//q.prev = q; // This line will be added in case of doubly linked list
	}
	head = q;
	return head;
}

// Recursive method

public Node Reverse(Node node)
{
    if (node == null || node.next == null) return node; 

    Node secondElem = node.next;

    // bug fix - need to unlink node from the rest or you will get a cycle
    node.next = null;

    // then we reverse everything from the second element on
    Node reverseRest = Reverse(secondElem);

    // then we join the two lists
    secondElem.Next = node;

    return reverseRest;
}
