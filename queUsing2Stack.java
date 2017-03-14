import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Stack<Integer> stk1=new Stack<>();
        Stack<Integer> stk2=new Stack<>();
        for (int i = 0; i < n; i++)
        {
            int operation = scan.nextInt();
            if (operation == 1) 
               { // enqueue
                  stk1.push(scan.nextInt());
               }  
            else if (operation == 2) 
               { // dequeue
                  if(!stk2.isEmpty())
                      stk2.pop();
                 else
                    {
                     while(!stk1.isEmpty())
                         {
                           stk2.push(stk1.pop());
                          }
                           if(!stk2.isEmpty())
                               stk2.pop();
                    }
               } 
            else if (operation == 3 ) 
                    { // print/peek
                          if(!stk2.isEmpty())
                             System.out.println(stk2.peek());
                   else
                      {
                       while(!stk1.isEmpty())
                          {
                            stk2.push(stk1.pop());
                          }
                           if(!stk2.isEmpty())
                              System.out.println(stk2.peek());
                     }
                      
                   }
            else
                {}
        }
        scan.close();
    }
}
