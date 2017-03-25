import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean isBalanced(String str)
    {
     Stack<Character> stk=new Stack<>();
        for(int i=0;i<str.length();i++)
            {
            if(str.charAt(i)=='(' || str.charAt(i)=='{' || str.charAt(i)=='[')
                stk.push(str.charAt(i));
            else if(!stk.isEmpty() && (str.charAt(i)==')' && stk.peek()=='(' || str.charAt(i)=='}' && stk.peek()=='{' || str.charAt(i)==']' && stk.peek()=='['))
                       stk.pop();
                 else
                 {
                  stk.push(str.charAt(i));
                 }
            }
        if(stk.isEmpty())
            return true;
        return false;
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String str = in.next();
            System.out.println( (isBalanced(str)) ? "YES" : "NO" );
        }
    }
}
