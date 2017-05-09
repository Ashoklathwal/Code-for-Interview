//Merge a linked list into another linked list at alternate positions

list1.merge(list2);

void merge(LinkedList q)
{
	Node p_curr = head, q_curr = q.head; // poitning to first node to both list
	Node p_next, q_next; // for saving next pointer
	while(p_curr != null && q_curr != null)
	{
		// save next pointer
		p_next = p_curr.next;
		q_next = q_curr.next;

		// make q_curr as next of p_curr
		// order matters
		q_curr.next = p_curr.next; //  change next pointer of q_curr
		p_curr.next = q_curr;  // change next pointer of p_curr

		// update current position for next iteration
		p_curr = p_next;
		q_curr = q_next

	}
	q.head = q_curr;

}