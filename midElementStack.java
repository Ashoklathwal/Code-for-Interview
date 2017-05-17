/*
Design a stack with operations on middle element


How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
Push and pop are standard stack operations.

The important question is, whether to use a linked list or array for implementation of stack?

Please note that, we need to find and delete middle element. 

Deleting an element from middle is not O(1) for array.because we have to move all element to the left 
after deleting element

Also, we may need to move the middle pointer up when we push an element and move down when we pop(). 
In singly linked list, moving middle pointer in both directions is not possible.

The idea is to use Doubly Linked List (DLL). We can delete middle element in O(1) time by maintaining mid pointer. 
We can move mid pointer in both directions using previous and next pointers

*/
// using doubly linked list
class midElementStack
{
	Node mid;
	Node top;
	int count;
	class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int data)
		{
			this.data = data;
			next  = null;
			prev = null;
		}
	}

    midElementStack()
    {
    	top = null;
    	mid = null;
        count = 0;
    }
    void push(int data)
    {
    	Node temp = new Node(data);
    	if(top == null)
    	{
    		top = temp;
    		mid = temp;
    		count++;
    		return;
    	}
    	temp.prev = top;
    	top.next = temp;
    	top = temp;
    	count++;
    	if(count%2 == 0) // go to next mid only in alternate turns
    		mid = mid.next;

    }
    int pop()
    {
    	if(top == null)
    		return -1;
    	Node temp = top;
    	top = top.prev;
    	top.next = null;
    	count--;
    	if(count % 2 == 1)
    		mid = mid.prev;
    	return temp.data;
    }
    int peek()
    {
    	if(top == null) return -1;
    		return top.data;
    }
    int findMiddle()
    {
    	return mid.data;
    }
    int deleteMiddle()
    {
    	// order matters
    	Node temp = mid;
    	mid.prev.next = mid.next;
    	mid.next.prev = mid.prev;
    	count--;
    	return temp.data;
    }
	public static void main(String[] args)
	{
		midElementStack stk = new midElementStack();
		stk.push(30);
		stk.push(10);
		stk.push(40);
		stk.push(55);
		stk.push(13);
		stk.push(37);
		stk.push(7);
		System.out.println("mid element :" + stk.findMiddle() +" delMid : "+stk.deleteMiddle());
		System.out.println("poped element : " + stk.pop());
        System.out.println("mid element :" + stk.findMiddle() +" delMid : "+stk.deleteMiddle());

	}
}