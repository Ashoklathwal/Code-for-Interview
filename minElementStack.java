/*
Using auxilary stack
In this we will store min element in one stack on each push element and all elelment in other stack
But below approach is using only one stack

Important Points:

               --> Stack doesn’t hold actual value of an element if it is minimum so far.
               --> Actual minimum element is always stored in minEle
*/
import java.util.Stack;
class minElementStack
{
	Stack<Integer> stk;
    int minEle ;
    minElementStack()
    {
    	stk = new Stack<Integer>();
    }
    void getMin()
    {
    	if(stk.isEmpty())
		    System.out.println("Stack is empty");
		else
		{
		    System.out.println("minmum element in stack is :"+ minEle);
		}
    }
    void push(int ele)
    {
    	if(stk.isEmpty())
    	{
    		stk.push(ele);
    		minEle = ele;
    	}
    	else
    	{
    		if(ele >= minEle)
    			stk.push(ele);
    		else
    		{
    			stk.push(2*ele - minEle);
    			minEle = ele;
    		}
    	}
    }
	void pop()
	{
		if(stk.isEmpty())
			System.out.println("Stack is empty");
		else
		{
			int temp = stk.pop();
			if(temp >= minEle)
				 System.out.println("poped element is :"+ temp);// min element is still present in stack
			else
				{
					System.out.println("poped element is :"+ minEle);
					minEle = 2*minEle - temp;
                   
				}
		}


	}
	public static void main(String[] args)
	{
		minElementStack stk = new minElementStack();
		
		stk.push(34);
		stk.push(13);
		stk.push(20);
        stk.push(15);
        stk.push(5);
        stk.getMin();
        stk.pop();
        stk.getMin();
        stk.pop();
        stk.getMin();
	}
}