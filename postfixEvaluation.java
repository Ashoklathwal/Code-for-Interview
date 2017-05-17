/*
Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. 
      Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer
*/

import java.util.Stack;
class postfixEvaluation
{
	static boolean isOperand(int num)
	{
		return (num>=0 && num<=9);
	}
	static void evaluate(String str)
	{
		Stack<Integer> stk = new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if(isOperand(str.charAt(i)-'0'))
				stk.push(str.charAt(i)-'0');
			else
			{
				if(!stk.isEmpty())
				{
				int val1 = stk.pop();
				int val2 = stk.pop();
				switch(str.charAt(i))
				  {
				  	case '+': stk.push(val2 + val1); break;
				  	case '-': stk.push(val2 - val1); break;
				  	case '*': stk.push(val2 * val1); break;
				  	case '/': stk.push(val2 / val1); break;
				  	case '^': stk.push(val2 ^ val1); break;

				  }
			    }
			}

		}
		if(!stk.isEmpty())
		{
			System.out.println(stk.peek());
		}
    	}
	public static void main(String[] args)
	{
		String exp = "231*+9-";  //  -4
		evaluate(exp);
	}
}