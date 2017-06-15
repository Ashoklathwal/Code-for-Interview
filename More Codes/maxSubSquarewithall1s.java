/*
Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else 
            S[i][j] = 0
2) Find the maximum entry in S[R][C]
3) Using the value and coordinates of maximum entry in S[i], print 
   sub-matrix of M[][]

*/

import java.util.*;
class maxSubSquarewithall1s
{
	public static void maxSubSquarewithall1s_util(int[][] arr, int m, int n)
	{
		int[][] table = new int[m][n];
		for(int i=0;i<m;i++)
		   table[i][0] = arr[i][0];
		for(int i=0;i<n;i++)
		   table[0][i] = arr[0][i];
        
        int count = 1;
        int max_i = 0;
        int max_j = 0;
		for(int i=1;i<m;i++)
		{
			for(int j=1; j<n;j++)
			{
				if(arr[i][j] == 1)
				{
					table[i][j] = 1 + Math.min(table[i][j-1],Math.min(table[i-1][j-1],table[i-1][j]));
					if(count < table[i][j])
					{
					  count = table[i][j];
					  max_i = i;
					  max_j = j;
				    }
				}
				else
				{
					table[i][j] = 0;
				}
			}
		}
		//for(int[] ar : table)
		//	System.out.println(Arrays.toString(ar));

		System.out.println("Size of max size submatrix with all 1's "+count+"   max_i  "+max_i+"  max_j  "+max_j);   
        System.out.println();
		for(int i = max_i; i >= (max_i-count+1);i--)
		{
		   for(int j = max_j; j >= (max_j-count+1);j--)
		   {
		   	 System.out.print(arr[i][j]+" ");
		   }	
		   System.out.println();
		} 
	}
	public static void main(String[] args) 
	{
		int m = 6, n = 5;
		int[][] arr =  {{0, 1, 1, 0, 1}, 
                         {1, 1, 0, 1, 0}, 
                         {0, 1, 1, 1, 0},
                         {1, 1, 1, 1, 0},
                         {1, 1, 1, 1, 1},
                         {0, 0, 0, 0, 0}};

        maxSubSquarewithall1s_util(arr,m,n);                 
		
	}
}