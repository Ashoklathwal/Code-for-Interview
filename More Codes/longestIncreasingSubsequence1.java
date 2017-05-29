/*
** Find a subsequence in given array in which the subsequence's elements are 
 * in sorted order, lowest to highest, and in which the subsequence is as long as possible
 * 
 * Solution : 
 * Dynamic Programming is used to solve this question. DP equation is 
 * if(arr[i] > arr[j]) { T[i] = max(T[i], T[j] + 1 }
 * 
 * Time complexity is O(n^2).
 * Space complexity is O(n)
*/
import java.util.Arrays;
class longestIncreasingSubsequence1
{
	public static void longestIncreasingSubsequence(int[] arr, int n)
	{
		int[] output = new int[n];
		int[] actualSequence = new int[n];
        // min longest incresing subseuence will be 1
		Arrays.fill(output, 1);

		for(int i=1; i<n; i++)
		{
			for(int j=0; j<i; j++)
			{
				if(arr[j] < arr[i])
				{
					if((output[j] + 1) > output[i])
					{
						output[i] = output[j] + 1;
						actualSequence[i] = j; // actual sequence before me
					}
				}
			}
		}

		System.out.println("longest Increasing Subsequence : "+output[n-1]);

		// find maximum index in output array
		int maxIndex = 0;
		for(int i=0; i<n; i++)
		{
			if(output[i] > output[maxIndex])
				maxIndex = i;
		}
        
        // now find actual subseuence
        int temp = maxIndex;
        System.out.println("actual longest increasing subseuence in reverse order:");
        int newTemp = maxIndex;
        do
        {
        	temp = newTemp;
        	System.out.print(arr[temp]+" ");
        	newTemp = actualSequence[temp];
        }while(temp != newTemp);

	}
	public static void main(String[] args) 
	{
      int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
      int n = arr.length;
      longestIncreasingSubsequence(arr, n);
		
	}
}