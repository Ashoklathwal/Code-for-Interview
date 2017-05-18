
import java.util.Stack;
class reverseStack
{
	static Stack<Integer> stk;
	reverseStack()
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
	void insertAtBottom(int temp)
	{ 
		if(stk.isEmpty())
			stk.push(temp);
		else
		{
			// hold all the element in function call untill we reach end of stack
			// when we reach end of stack insert elemnt in stack
			int x = stk.pop();
			insertAtBottom(temp);
			// once an element is inserted at bottom push all element of function call in stack
			stk.push(x);
		}

	}
	// reverse the stack using insertAtBottom
	void reverse()
	{
		if(stk.isEmpty())
			return;
		else
		{
			// hold all the element in function call untill we reach end of stack
			int temp = stk.pop();
			reverse();
			// insert all the element (held in function call ) one by one from bottom to top
			// every item is inserted at bottom
			insertAtBottom(temp);
		}
	}
	public static void main(String[] args)
	{
		reverseStack restk = new reverseStack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        System.out.println("Original stack element ");
        restk.printStack();
        System.out.println("Reversed stack element ");
        restk.reverse();
        restk.printStack();
	}
}