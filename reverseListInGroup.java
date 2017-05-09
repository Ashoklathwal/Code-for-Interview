
// Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

/*Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 
*/
public Node groupReverse(Node head, int k)
{
	Node p = null, q = null, r = head;
	int count = 0;
	/* Reverse first k nodes of linked list */
	while(r != null && count < k)
	{
		// order matter
		// p is previous, q is next, r is current 
		p = q;
		q = r;
		r = r.next; // pointing to next node
		q.next = p; // make pointer to previous node
		count++;
	}
	/* r is now a pointer to (k+1)th node 
		Recursively call for the list starting from r.
		And make rest of the list as next of first node */
	if(r != null)
		head.next = groupReverse(r, k)
	// now q is our head
	return q;
}