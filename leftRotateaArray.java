import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b=new int[n];
        System.arraycopy(a,k,b,0,n-k);
        System.arraycopy(a,0,b,n-k,k);
        for(int i:b)
            System.out.print(i+" ");
    }
}
