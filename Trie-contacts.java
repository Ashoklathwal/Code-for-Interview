import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Trie 
{
    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
            {
              String str1=sc.next();
              if(str1.equals("add"))
                  {
                   String str2=sc.next();
                   int length=str2.length();
                   for(int j=0;j<length;j++)
                       {
                        String sbstr=str2.substring(0,j+1);
                        if(hm.get(sbstr)==null)
                            hm.put(sbstr,1);
                        else
                            hm.put(sbstr,hm.get(sbstr)+1);
                       }
                  }
            else
                {
                 String str2=sc.next();
                 if(hm.containsKey(str2))
                     System.out.println(hm.get(str2));
                  else
                      System.out.println("0");
                }
            }
     }
}
