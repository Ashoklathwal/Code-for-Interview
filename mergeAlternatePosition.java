//Merge a linked list into another linked list at alternate positions

public Node alterMerge(Node A, Node B) 
{
		Node temp = A;// it will be needed to get the head of the new list
	       // for saving the next pointer
	        Node a_next;
	        Node b_next;
		while (A != null && B != null) 
		{
			a_next = A.next;
		        b_next = B.next;
			
			A.next = B;
			B.next = a_next;
			
			A = a_next;
			B = b_next;
		}
	        print(temp); // followed by 
	       if(B != null)
	       {
		     print(B);  
	       }
	
}
