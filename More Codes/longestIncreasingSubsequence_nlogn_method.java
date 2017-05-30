import java.util.Arrays;
class longestIncreasingSubsequence_nlogn_method
{
	public static int ceilIndex(int[] input, int[] tempIndex, int end, int s)
	{
		int start = 0;
		int mid;
		int len = end;
		while(start <= end)
		{
			mid = (start + end) / 2;
			if(mid < len && input[tempIndex[mid]] < s && s <= input[tempIndex[mid+1]])
			{
				return mid + 1; 
			} 
			else if(input[tempIndex[mid]] < s)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
	public static void longestIncreasingSubsequence(int[] input, int n)
	{
		//store the index of min of last value of an Increasing subsequence of particular length
		// store intermidate results
		// value be sorted not index
		int[] tempIndex = new int[n];
		// store the index of actual sequence and start from max index from tempIndex and use backtracking in actual sequence we can find our actual sequence
		int[] actualSquence = new int[n]; 
		Arrays.fill(actualSquence, -1);

		tempIndex[0] = 0;

		int len = 0; // keep track of actual longest Increasing subSequence

		for(int i=1; i<n; i++)
		{
			if(input[i] < input[tempIndex[0]]) //if input[i] is less than 0th value of TempIndex then replace it there.
			{
				tempIndex[0] = i;
			}
			else if(input[i] > input[tempIndex[len]]) //if input[i] is greater than last value of TempIndex then append it in TempIndex
			{
				len ++;
				tempIndex[len] = i;
				actualSquence[tempIndex[len]] = tempIndex[len - 1];
			}
			else
			{
				int index = ceilIndex(input, tempIndex, len, input[i]);
				tempIndex[index] = i;
				actualSquence[tempIndex[index]] = tempIndex[index - 1];
			}
		}

		System.out.println("Length of longest Increasing Subsequence : "+ (len+ 1));
        
        System.out.println("longest Increasing Subsequence in reverse order is : ");
		int maxIndex = tempIndex[len];
		while(maxIndex != -1)
		{
			System.out.print(input[maxIndex]+" ");
			maxIndex = actualSquence[maxIndex];
		}
	} 
	public static void main(String[] args) 
	{
		int[] input = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
		int n = input.length;
		longestIncreasingSubsequence(input, n);
		
	}
}