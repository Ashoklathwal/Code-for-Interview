/*
Given a singly linked list, swap kth node from beginning with kth node from end. 
Swapping of data is not allowed, only pointers should be changed. This requirement
 may be logical in many situations where the linked list data part is huge
  (For example student details line Name, RollNo, Address, ..etc). 
  The pointers are always fixed (4 bytes for most of the compilers).

  Let X be the kth node from beginning and Y be the kth node from end. Following are the interesting cases that must be handled.
1) X and Y don’t exist (k is more than number of nodes in linked list)
2)  X and Y are same
3) X is next to Y
4) Y is next to X
*/
class swapLinkedList
{
	Node head;
    class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}

	// count totalNodes in list
    int countNodes()
    {
    	int count = 0;
    	Node curr = head;
    	while(curr != null)
    	{
    		count++;
    		curr = curr.next;
    	}
    	return count;
    }

	// swap nodes
	void swap(int k)
	{
		// count total nodes in linked list
		int totalNodes = countNodes();
        // 1. check k is valid or not          
        if(k > totalNodes)
        	return;
        // 2. if x(Kth node from begining of list) and y(kth node from end of linked list) are same
        if(2*k-1 == totalNodes)
        	return;
        // 3 and 4.
        // finding kth node from begining of list and prev of kth node because we need to update pointer
        // of prev-> next 
        Node x = head;
        Node x_prev = null;
        for(int i=1;i<k;i++)
        {
        	x_prev = x;
        	x = x.next;
        }
        // finding kth node from the ending of list
        Node y = head;
        Node y_prev = null;
        for(int i=1;i < totalNodes - k + 1;i++)
        {
        	y_prev = y;
        	y = y.next;
        }
        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement 
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if(x_prev != null)
        	x_prev.next = y;
        // same for y_prev
        if(y_prev != null)
        	y_prev.next = x;
        // now break loop which made by y_prev and x and make final linked list
        Node temp = x.next;
        x.next = y.next;
        y.next =temp;

        // if k = 1 or last node
        if(k == 1)
        	head = y;
        if(k == totalNodes)
        	head = x;

	}

	// push data in linked list(adding data in back of list)
	void push(int data)
	{
		Node new_node = new Node(data);
	    new_node.next = head;
	    head = new_node;	

	}

	// print linked list
	void printList()
	{
		Node curr = head;
		while(curr != null)
		{
			System.out.print(curr.data+ " ");
			curr = curr.next;
		}
		System.out.println("");
	}
	public static void main(String[] args)
	{
		swapLinkedList list = new swapLinkedList();
		for(int i = 8; i >= 1; i--)
			list.push(i);
		System.out.println("Original linkedList");
		list.printList();
		System.out.println("");
		for(int i = 1;i <= 8;i++)
		{
			System.out.println("Modified list for k = " + i);
			list.swap(i);
            list.printList();
            System.out.println(""); 
		} 
	}
}