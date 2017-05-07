// add element of 2 linked list and return head of resultant linked list
// given head(first,second) of both linked list 
AddLinkedList(Node first, Node second)
{
	Node result= null; // resultant linked list
	Node head = null; // head of resultant linked list
	Node temp = null;
	int carry = 0, sum ;
	while(first != null || second!= null)
	{
		sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
		carry = (sum >= 10 ? 1 : 0);
		sum = sum % 10;
		temp = new Node(sum);
		// if this is first node of resulting list
		if(head == null)
			head = temp;
		else
			result.next = temp;
        // for next insertion of node
		result = temp;
		if(first != null)
			first = first.next;
		if(second != null)
			second = second.next;
	} 
	// for last carry (if any)
	if(carry > 0)
		result.next = new Node(carry);
	return head; // return head of resultant list
}