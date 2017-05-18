// varition of "reverse of stack" 
// sort stack in ascending order

import java.util.Stack;
class sortStack
{
	static Stack<Integer> stk;
	sortStack()
	{
		stk = new Stack<Integer>();
	}
     // print full stack value from top to bottom
	void printStack()
	{
       for(Integer ele: stk)
       {
       	 System.out.print(ele+" ");
       }
       	
       	System.out.println("");
	}
	void sortInsertAtBottom(int temp)
	{ 
		if(stk.isEmpty() || temp > stk.peek())
			stk.push(temp);
		else
		{
			// hold all the element in function call untill we reach end of stack
			// when we reach end of stack insert elemnt in stack
			int x = stk.pop();
			sortInsertAtBottom(temp);
			// once an element is inserted at bottom push all element of function call in stack
			stk.push(x);
		}

	}
	// reverse the stack using insertAtBottom
	void sort()
	{
		if(stk.isEmpty())
			return;
		else
		{
			// hold all the element in function call untill we reach end of stack
			int temp = stk.pop();
			sort();
			// insert all the element (held in function call ) one by one from bottom to top
			// every item is inserted at bottom
			sortInsertAtBottom(temp);
		}
	}
	public static void main(String[] args)
	{
		sortStack sstk = new sortStack();
        stk.push(34);
        stk.push(26);
        stk.push(30);
        stk.push(41);
        stk.push(22);
        System.out.println("Original stack element ");
        sstk.printStack();
        System.out.println("Reversed stack element ");
        sstk.sort();
        sstk.printStack();
	}
}