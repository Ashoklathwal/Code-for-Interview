/*
We can sum the bits in same positions for all the numbers and take modulo with N = 3. 
The bits for which sum is not multiple of N, are the bits of number with single occurrence.
Let us consider the example array {5, 5, 5, 8}. The 101, 101, 101, 1000
Sum of first bits%3 = (1 + 1 + 1 + 0)%N = 0;
Sum of second bits%3 = (0 + 0 + 0 + 0)%N = 0;
Sum of third bits%3 = (1 + 1 + 1 + 0)%N = 0;
Sum of fourth bits%3 = (1)%N = 1;
Hence number which appears once is 1000

Time complexity = O(n)
Space Complexity = O(1)
*/
class occur_N_timeExceptOne
{
	public static void getSingleNumber(int[] arr, int N)
	{
		int INT_SIZE = 32;
		int singleNumber = 0;
		int x;
		int sum;
		// iterate through every bit from right to left
		for(int i=0; i< INT_SIZE; i++)
		{
			// find sum of set bit at i^th position in all array element
			x =  (1 << i);
			sum = 0;
			for(int j=0; j<arr.length; j++)
			{
				if((arr[j] & x) > 0)
					sum++;
			}
			//System.out.println(sum);
            // the bit with sum not multiple of N are the bits of single occurance.
            if((sum % N) > 0)
            	singleNumber = (singleNumber | x); 
            //System.out.println(singleNumber);
		}

		System.out.println(singleNumber);
	}
	public static void main(String[] args) 
	{
		int[] arr = {5,5,4,8,4,5,8,9,4,8};
		int N = 3; // here all numbers occurs 3 time cxcept one number so modulo by N = 3. if all number occurs 10 times except one then take modulo with N = 10
		getSingleNumber(arr, N);
	}
}