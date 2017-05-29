import java.util.Stack;
import java.util.Arrays;
class maxOfMinOfEveryWindowSize
{
	public static void maxOfMin(int[] arr, int n)
	{
		int[] nextSmaller = new int[n];
		int[] prevSmaller = new int[n];
		Arrays.fill(nextSmaller, n);
		Arrays.fill(prevSmaller, -1);

		// fill prevSmaller  array using approach NGE
		Stack<Integer> Stk = new Stack<>();
		for(int i = 0; i<n; i++)
		{
			while(!Stk.isEmpty() && arr[Stk.peek()] >= arr[i])
				Stk.pop();
			if(!Stk.isEmpty())
				prevSmaller[i] = Stk.peek();

			Stk.push(i);
		}
		Stk.clear();
         // fill nextSmaller  array using approach NGE
		for(int i = n-1; i>=0; i--)
		{
			while(!Stk.isEmpty() && arr[Stk.peek()] >= arr[i])
				Stk.pop();
			if(!Stk.isEmpty())
				nextSmaller[i] = Stk.peek();

			Stk.push(i);
		}

		// store max element in output array
		int[] output = new int[n+1];
		for(int i=0; i<n; i++)
		{
			// length of interval
			int len = nextSmaller[i] - prevSmaller[i] - 1; // tells us element at i^th index is max element in window of size "len" 
			output[len] = Math.max(arr[i], output[len]);
		}
		// fill remaining element in output array whose value zero
		for(int i=n-1; i>=1;i--)
		{
			output[i] = Math.max(output[i], output[i+1]);
		}
		// in the ouput array 1st element will be useless
		System.out.println(Arrays.toString(output));
	}
	public static void main(String[] args) 
	{
		int[] arr = {10, 20, 30, 50, 10, 70, 30};
		int n = arr.length;
		maxOfMin(arr,n); 
	}
}