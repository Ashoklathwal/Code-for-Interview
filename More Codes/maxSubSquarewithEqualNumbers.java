/*
Given a N x N matrix, determine the maximum K such that K x K is a submatrix with all 
equal elements i.e., all the elements in this submatrix must be same.

If Ai, j is equal to {Ai-1, j, Ai, j-1, Ai-1, j-1}, 
   all the three values:
    DPi, j = min(DPi-1, j, DPi, j-1, DPi-1, j-1) + 1
Else
    DPi, j = 1  // Matrix Size 1 

The answer would be the maximum of all DPi, j's

http://www.geeksforgeeks.org/finding-the-maximum-square-sub-matrix-with-all-equal-elements/
*/

import java.util.*;
class maxSubSquarewithEqualNumbers
{
	public static void maxSubSquarewithEqualNumbers_util(int[][] arr, int m, int n)
	{
		int[][] table = new int[m][n];
		
		int max_value = 0;
		for(int i=1;i<m;i++)
		{
			for(int j=1; j<n;j++)
			{
				if(i == 0 || j == 0)
					table[i][j] = 1;
				else
				{
				     if(arr[i][j] == arr[i][j-1] && arr[i][j] == arr[i-1][j-1] && arr[i][j] == arr[i-1][j])
			        	{
				        	table[i][j] = 1 + Math.min(table[i][j-1],Math.min(table[i-1][j-1],table[i-1][j]));
					        max_value = Math.max(max_value, table[i][j]);
				        }
				     else
				       {
				         	table[i][j] = 1;
				       }
				}
			}
		}
		//for(int[] ar : table)
		//	System.out.println(Arrays.toString(ar));

		System.out.println("Size of max size submatrix with equal numbers"+ max_value);   
        
	}
	public static void main(String[] args) 
	{
		int m = 6, n = 6;
		int[][] arr =  { {2, 2, 3, 3, 4, 4},
                         {5, 5, 7, 7, 7, 4},
                         {1, 2, 7, 7, 7, 4},
                         {4, 4, 7, 7, 7, 4},
                         {5, 5, 5, 1, 2, 7},
                         {8, 7, 9, 4, 4, 4}};

        maxSubSquarewithEqualNumbers_util(arr,m,n);                 
		
	}
}