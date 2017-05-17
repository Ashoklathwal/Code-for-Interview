/*

Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence
       of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
*/

import java.util.*;
class infixToPostfix
{
	static int precedence(char ch)
	{
		switch(ch)
		{
			case '+':
			case '-':
			     return 1;
			case '*':
			case '/':
			     return 2;
			case '^':
			     return 3;          
		}
		return -1;
	}
	static boolean isOperand(char ch)
	{
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
	}
    static void postfix(String str)
    {
    	Stack<Character> stk = new Stack<>();
    	for(int i=0;i<str.length();i++)
    	{
    		if(isOperand(str.charAt(i)))
    		{
    			System.out.print(str.charAt(i));
    		}
    		else if(str.charAt(i) == '(')
    		{
    			stk.push(str.charAt(i));
    		}
    		else if(str.charAt(i) == ')')
    		{
    			while(!stk.isEmpty() && stk.peek() != '(')
    			{
    			    System.out.print(stk.pop());
    			}
    			if(!stk.empty() && stk.peek() != '(')
    			{
    			    // invalid expression
    			}
    			if(!stk.empty())
    			{
                   stk.pop();
    			}
    		}
    		else
    		{
    			while(!stk.empty() && (precedence(str.charAt(i)) <= precedence(stk.peek())))
    			{
    				System.out.print(stk.pop());
    			}
    			    stk.push(str.charAt(i));
    		}
    		

    	}
    	// print remaining operator from stack
    		while(!stk.empty())
    		{
    			System.out.print(stk.pop());
    		}
    }
	public static void main(String[] args) 
	{
		infixToPostfix itp = new infixToPostfix();
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; // abcd^e-fgh*+^*+i-
        postfix(exp);    		
	}
}