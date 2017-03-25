import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) 
    {
        int count=0;
      int[] arr=new int[26];
      int[] brr=new int[26];
      for(int i=0;i<first.length();i++)
          arr[first.charAt(i)-97]++;
      for(int i=0;i<second.length();i++)
          brr[second.charAt(i)-97]++;
      for(int i=0;i<26;i++)
          count+=Math.abs(arr[i]-brr[i]);
      return  count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
