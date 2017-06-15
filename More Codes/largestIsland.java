import java.io.*;
import java.util.*;

public class largestIsland {
     
    public static int cell(int i, int j, int[][] arr,int n,int m)
        {
        if((i<0 || j<0) || (i>=n || j>=m) || arr[i][j] == 0 || arr[i][j] == -1 )
            return 0;
        arr[i][j] = -1;
        return 1 + cell(i-1,j-1,arr,n,m) + cell(i-1,j,arr,n,m) + cell(i-1,j+1,arr,n,m) + cell(i,j-1,arr,n,m) + cell(i,j+1,arr,n,m) 
                 + cell(i+1,j-1,arr,n,m) + cell(i+1,j,arr,n,m) + cell(i+1,j+1,arr,n,m);
        }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<m;j++)
                {
                arr[i][j] = sc.nextInt();
                }
            }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            {
            for(int j=0;j<m;j++)
                {
                max = Math.max(max,cell(i,j,arr,n,m));
                }
            }
        System.out.println(max);
    }
}