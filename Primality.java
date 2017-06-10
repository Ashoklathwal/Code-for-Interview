/*
  generate all prime numbers or within range
static int[] primeGen(int q)
         {
           int[] arr = new int[q];
           BigInteger bi = BigInteger.valueOf(1);
        for(int i=0; i<q; i++)
        {
            bi = bi.nextProbablePrime();
            arr[i] = bi.intValue();
        }
      //   System.out.println(Arrays.toString(arr));
                return arr;
         }
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++)
        {
            int n = in.nextInt();
            boolean flag=true;
            if(n==1)
                {
                 flag=false;
                }
            for(int i=2;i<=Math.sqrt(n);i++)
                {
                  if(n%i==0)
                      {
                        flag=false;
                          break;
                      }
                }
            if(flag)
                 System.out.println("Prime");
            else
                System.out.println("Not prime");
        }
    }
}
