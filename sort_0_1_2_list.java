

/*
Given a linked list of 0s, 1s and 2s, sort it.

Following steps can be used to sort the given linked list.
1) Traverse the list and count the number of 0s, 1s and 2s. Let the counts be n1, n2 and n3 respectively.
2) Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1 and finally n3 nodes with 2.

*/

Node sort(Node root)
{
	int count[] = {0, 0, 0};
	Node temp = root;
	// count number of 0's, 1's, 2's and store in count array
	while(temp != null)
	{
		count[temp.data]++;
		temp = temp.next;
	}
	int i = 0;
	temp = root;
	while(temp != null && i < 3)
	{
		if(count[i] > 0)
		{
			temp.data = i;
			count[i]--;
			temp = temp.next;
		}
		else
		{
			i++;
		}
	}
}