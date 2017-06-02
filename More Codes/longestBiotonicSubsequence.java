/*

Solution : 
 * Dynamic Programming is used to solve this question. DP equation is 
 * Time complexity is O(n^2).
 * Space complexity is O(3*n)

Longest bitonoc sub sequence is sus sequence in whic firstly element is in increasing followed be decreasing order\;
Idea:
  1)  first find longest increasing subsequence, start from starting from input array
      if(arr[i] > arr[j] && i > j) { LIS[i] = max(LIS[i], LIS[j] + 1 }
  2)  first find longest decreaing subsequence, start from  ending from input array
      if(arr[i] > arr[j] && i < j) { LDS[i] = max(LDS[i], LDS[j] + 1 }
  3) Take diffrence between LIS and LDS arrays and subtract one at each array then we get resultant array
  4) find maximum value in resultant array that will be our longest bitonic subsequence    


*/

import java.util.Arrays;
class longestBiotonicSubsequence
{
	public static int longestBiotonicSubsequence_util(int[] arr)
	{
		int n = arr.length;
		int[] LIS = new int[n];
		int[] LDS = new int[n];
		// min length should be one
		Arrays.fill(LIS, 1);
		Arrays.fill(LDS, 1);
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[j] < arr[i])
				{
					LIS[i] = Math.max(LIS[i], LIS[j]+1);
				}
			}
		}

		for(int i=n-2; i>=0; i--)
		{
			for(int j=n-1; j>i; j--)
			{
				if(arr[j] < arr[i])
				{
					LDS[i] = Math.max(LDS[i], LDS[j]+1);
				}
			}
		}

		//ouput array
		int[] output = new int[n];
		for(int i=0; i<n; i++)
		{
			output[i] = LIS[i] + LDS[i] - 1; // 1 is subtracting because  one element is count twice i.e, the last element in LIS and 1st element in LDS is same 
		}

		int maxValue = 0;
                for(int i=0; i<n; i++)
		{
		  if(output[i] > maxValue)
		      maxValue = output[i];
		}
		//System.out.println("longest Bitonic Subsequence : "+maxValue);
       return maxValue;


	}
	public static void main(String[] args) 
	{
		int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println("length of longest Bitonic Subsequence : "+longestBiotonicSubsequence_util(arr));
		
	}
}	