import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static int series(int n)
       {
        int[] srs=new int[37];
        srs[0]=0;
        srs[1]=1;
        srs[2]=2;
        srs[3]=4;
        for(int i=4;i<=n;i++)
            {
             srs[i] = srs[i-1] + srs[i-2] + srs[i-3];
            }
        return srs[n];
          /*
          if(n == 0) return 0;
          else if(n == 1) return 1;
          else if(n == 2) return 2;
          else if(n == 3) return 4;
          else return (series(n-1) + series(n-2) + series(n-3));
          */
        }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++)
        {
            int n = in.nextInt();
            System.out.println(series(n));
        }
    }
}
