/*
Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced. 
Find minimum number of bracket reversals to make the expression balanced.

*/
import java.util.Stack;
import java.lang.Math;
class countMinReversals
{
	static int  countReversals(String str)
	{
		
		// length of expression must be even to make reversals
		if(str.length() % 2 == 1)
			return -1;
		Stack<Character> stk = new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			if(!stk.isEmpty() && str.charAt(i) == '}')
			{ 
				if(stk.peek() == '{')
				{
					stk.pop();
				}
				else
				{
					stk.push(str.charAt(i));
				}
			}
			else
			{
				stk.push(str.charAt(i));
			}
		}
		//length of m+n
		int size = stk.size();
		int count = 0;
		// count openeing brackets at the end of stack
		while(!stk.isEmpty() && stk.peek() == '{')
		{
			stk.pop();
			count++;
		}
		//int m = size - count;
		//int n = count;
		eturn ceil(m/2) + ceil(n/2) which is
    //   return ceil(m/2) + ceil(n/2) which is actually equal to (m+n)/2 + n%2 when m+n is even. count = n
		return (size/2 + count%2);
		//return (int)(Math.ceil(m/2) + Math.ceil(n/2));
	}
	public static void main(String[] args)
	{
		String exp = "}{{}}{{{"; // 3
		System.out.println(countReversals(exp));
	}
}