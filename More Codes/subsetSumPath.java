/*
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total. Another variation is given an array is it possible to split it up into 2 equal
 * sum partitions. Partition need not be equal sized. Just equal sum.
 *
 * Time complexity - O(input.size * total_sum)
 * Space complexity - O(input.size*total_sum)
*/
import java.util.*;

class subsetSumPath
{
	public static void subsetSumPath_util(int[] arr, int sum)
	{
		boolean[][] T = new boolean[arr.length+1][sum+1];
		// if sum is 0
		for(int i=0;i<=arr.length;i++)
			T[i][0] = true;

		for(int i=1;i<=arr.length;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(j < arr[i-1])
					T[i][j] = T[i-1][j];
				else
					T[i][j] = T[i-1][j] || T[i-1][j-arr[i-1]];
			}
		}
		//for(boolean[] temp : T)
		//	System.out.println(Arrays.toString(temp));

		System.out.println(T[arr.length][sum]);
		if(T[arr.length][sum])
		{
			System.out.println("sum possible");
			int i=arr.length;
			int j=sum;
			while(j>0)
			{
				if(T[i][j] == T[i-1][j])
				{
					i--;
					
				}
				else
				{
					j = j - arr[i-1];
					System.out.print(arr[i-1]+" ");
				}
				//System.out.println(arr[i]+" i:"+i+" j:"+j);
			}
		}
		else
		{
			System.out.println("sum not possible");
		}
	}
	public static void main(String[] args) 
	{
		int[] arr = {2,3,7,8,10};
		int sum = 11;
		subsetSumPath_util(arr,sum);
	}
}