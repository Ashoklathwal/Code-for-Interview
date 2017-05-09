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
	}
	head = q;
	return head;
}