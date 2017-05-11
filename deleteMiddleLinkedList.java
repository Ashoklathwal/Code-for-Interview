/*Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then 
linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. 
For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

If the input linked list is NULL, then it should remain NULL.

If the input linked list has 1 node, then this node should be deleted and new head should be returned.


*/
// using slow pointer and fast pointer approach

public void deleteMiddleLinkedList(Node head)
{
	Node slow_pointer = head, fast_pointer = head;
	Node current = head;
	// if one element delete it
	if(current.next == null)
		current = null
	// if 2 elements delete both
	if(current.next.next == null)
		current = null;
	Node prev;
	while(fast_pointer != null && fast_pointer.next != null)
	{
		prev = slow_pointer;
		slow_pointer = slow_pointer.next;
		fast_pointer = fast_pointer.next.next;
	}
	// i am deleting 2nd middle element
	if(fast_pointer == null)
	{
	   prev.next = slow_pointer.next;	// odd number of node in list
	}
	else if(fast_pointer.next == null)
	{
       prev.next = slow_pointer.next.next; // even number of nodes in linked list
	}
	
}