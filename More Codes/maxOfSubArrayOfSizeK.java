import java.util.ArrayDeque;
class maxOfSubArrayOfSizeK
{
	public static void maxOfSubArray(int[] arr, int n, int k)
	{
		// implement in such a way that deque contains max element at front and min at rear
		// we will store the index in deque
		ArrayDeque<Integer> deque = new ArrayDeque<>();
        int i = 0;
        // always keep deque size equal to window size
		for( ; i<k; i++)
		{
			// Remove all element that are smaller than currently added element
			while(!deque.isEmpty() && arr[deque.getFirst()] <= arr[i])
				deque.removeFirst();
			deque.addLast(i);
		}

		for( ; i<n; i++)
		{
			System.out.print(deque.peekFirst()+" "); 
             // Remove element which is outside the window
			while(!deque.isEmpty() && (deque.peekFirst() <= i - k))
				deque.removeFirst();
            // Remove all element that are smaller than currently added element
			while(!deque.isEmpty() && arr[deque.getFirst()] <= arr[i])
				deque.removeFirst();
			deque.addLast(i);

		}
		System.out.print(arr[deque.peekFirst()]+" "); // max element in last window

	}
	public static void main(String[] args) 
	{
		int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k = 3; // window size
		int n = arr.length;
		maxOfSubArray(arr, n, k);
		
	}
}