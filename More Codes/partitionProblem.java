/*
 given an array is it possible to split it up into 2 equal
 sum partitions. Partition need not be equal sized. Just equal sum.
*/
import java.util.*;

class partitionProblem
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
            boolean[] output = new boolean[arr.length];
            int m=arr.length;
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
					output[i-1] = true;
				}
				//System.out.println(arr[i]+" i:"+i+" j:"+j);
			}
			System.out.println("first subset");
			for(i=0;i<arr.length;i++)
			{
				if(!output[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("Second subset");
			for(i=0;i<arr.length;i++)
			{
				if(output[i])
					System.out.print(arr[i]+" ");
			}
	
	}
	public static void main(String[] args) 
	{
		int[] arr = {2,3,7,8,10};
		int sum = 0;
		for(int i=0;i<arr.length;i++)
			sum +=arr[i];
		if((sum&1) == 0)
		{
			System.out.println("array Can be divided into two subset of equal sum");
			sum = sum / 2;
			subsetSumPath_util(arr,sum);
		}
		else
		{   // if sum is odd then partition not possible
			System.out.println("array Can not be divided into two subset of equal sum");
		}
		
	}
}