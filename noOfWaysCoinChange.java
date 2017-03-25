import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        long[] table = new long[n+1];
        table[0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=coins[i];j<=n;j++)
                {
                   table[j] +=table[j-coins[i]]; 
                
                }
        }
        System.out.println(table[n]);
    }
}
