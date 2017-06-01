

/*
Naive Approach :
A Simple Solution is to consider every subarray by running two loops. For every subarray, 
count number of zeroes in it. Return the maximum size subarray with m or less zeroes. 
Time Complexity of this solution is O(n2).

best approch :
The main steps are:
– While zeroCounts is less than or equal to m: expand the window to the right (wR++) and update the count zeroCount.
– While zeroCounts exceeds m, shrink the window from left (wL++), update zeroCount;
– Update the widest window along the way. The positions of output zeros are inside the best window.


*/

class flip_0_To_1
{
	public static void flip(int[] arr, int n, int m)
	{
		int wLIndex = 0; // left index of current window
		int wRIndex = 0; // right index of current window
		int zeroCounts = 0; // store count of number of zeros in cuurent window
		int bestWindow = 0;
		int bestLIndex = 0;
		while(wRIndex < n)
		{
			if(zeroCounts <= m)
			{
				if(arr[wRIndex] == 0)
					zeroCounts++;
				wRIndex++;
			}

			if(zeroCounts > m)
			{
				if(arr[wLIndex] == 0)
					zeroCounts--;
				wLIndex++;
			}

			if((wRIndex - wLIndex) > bestWindow)
			{
				bestWindow = wRIndex - wLIndex;
				bestLIndex = wLIndex;
			}
		}

		System.out.print("Indexes of Zeros to be flipped are : ");

		for(int i=0; i < bestWindow; i++)
			{
				if(arr[i + wLIndex] == 0)
					System.out.print((i + wLIndex) +" ");
			}
	    System.out.println();
		System.out.println("Number of 1's after flipping zeros are : "+ bestWindow);
	}
	public static void main(String[] args) 
	{
		int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
		int m = 2; // maximum number of zeros allowed to flip
        int n = arr.length;
		flip(arr, n, m);
		
	}
}