// Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.
import java.util.Stack;
class valid_substring
{
	static int validSubString(String str)
	{
		Stack<Integer> stk = new Stack<>();
		stk.push(-1);// provide base for valid substring
		int result = 0;
		int curr_length = 0;
        for(int i=0;i<str.length();i++)
        {
        	if(str.charAt(i) == '(')
        	{
        		stk.push(i); // storing the index in stack
        	}
        	else if(str.charAt(i) == ')')
        	{
        		stk.pop();
        		if(!stk.isEmpty())
        			result = Math.max((i - stk.peek()), result);
        		else
        			stk.push(i); // for providing the base for next valid substring
        	}
        }
        return result;
	}
	public static void main(String[] args)
	{
		String str="()(())(()";
		System.out.println("Length of valid substring : "+validSubString(str));
	}
}