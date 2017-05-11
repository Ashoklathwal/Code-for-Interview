public  void evenOddSegregate(Node head)
{
	Node current = head;
	Node end = head;
	Node prev = null;

	// first go to end
	while(end.next != null)
		end = end.next;

	Node new_end = end;

	// consider all odd node before first event node and move all odd those node at the end
	while(current.data % 2 != 0 && current != end)
	{
		new_end.next = current;
		current = current.next;
		new_end.next.next = null;
	}

	// if there is any even node
	if(current.data % 2 == 0)
	{
		while(current != end)
		{
			if(current.data % 2 == 0)
			{
				prev = current;
				current = current.next;
			}
			else
			{
				// order matter
				prev.next = current.next;
				current.next = null
				new_end.next = current;
				new_end = current;
				current = prev.next;
			}
		}
	}
	else
	{
		prev = current;
	}
	// for last(end) node
	if(end % 2 != 0)
	{
		prev.next = end.next;
		end.next = null;
		new_end.next = end;
		new_end = end;
	}
}