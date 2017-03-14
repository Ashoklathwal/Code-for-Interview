import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<m;i++)
            {
               String str=in.next();
               if(hm.get(str)==null)
                   hm.put(str,1);
               else
                   hm.put(str,hm.get(str)+1);
            }
       // for(Map.Entry<String,Integer> mt:hm.entrySet())
         //  System.out.println(mt.getKey()+" "+mt.getValue());
        boolean flag=false;
        for(int i=0;i<n;i++)
           {
            String str=in.next();
            if(hm.containsKey(str))
                {
                if(hm.get(str)>0)
                     hm.put(str,hm.get(str)-1);
                else
                     hm.remove(str);
                }
             else
                 {
                   flag=true;
                   break;
                 }
           }
        if(flag)
            System.out.println("No");
        else
            System.out.println("Yes");
        
    }
}
