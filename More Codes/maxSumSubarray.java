class maxSumSubarray
{
	public static int maxSumSubarray_util(int[] arr)
	{
		int curr_max = arr[0];
		int max_sum_so_far = arr[0];

		// direct print largest sum of subarray
	/*	for(int i=1; i<arr.length; i++)
		{
		    curr_max = Math.max(arr[i], arr[i]+curr_max);
            max_sum_so_far = Math.max(curr_max, max_sum_so_far);
	 	}
    */
		// print starting and ending index of subarray
        int startIndex = 0;
        int endIndex = 0;
        for(int i=1;i<arr.length; i++)
        {
        	if(arr[i] > arr[i]+curr_max)
        	{
        		curr_max = arr[i];
        		startIndex = i;
        	}
        	else
        	{
        		curr_max = arr[i]+curr_max;
        	}

        	if(max_sum_so_far < curr_max)
        	{
        		max_sum_so_far = curr_max;
        		endIndex = i;
        	}
        	if(startIndex > endIndex)
        	    startIndex = endIndex;	        	
        }

        System.out.println("starting index "+startIndex+" Ending Index "+endIndex);

		return max_sum_so_far;
	}
	public static void main(String[] args) 
	{
		//int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] arr = {1, -2, -3, 0, 7, -8, -2};
		System.out.println("largest sum of subarray : "+maxSumSubarray_util(arr));
		
	}
	} 