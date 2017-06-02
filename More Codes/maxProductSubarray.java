class maxProductSubarray
{
	public static int maxProduct(int[] nums) 
    {
        int min_so_far = nums[0];
        int max_so_far = nums[0];
        int curr_max = nums[0];
        int curr_min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) 
        {
                if(nums[i] > 0)
                {
                    curr_max = Math.max(nums[i], nums[i] * max_so_far);
                    curr_min = Math.min(nums[i] , nums[i] * min_so_far);

                } 
                else 
                {
                    curr_max = Math.max(nums[i],  nums[i] * min_so_far);
                    curr_min = Math.min(nums[i] , nums[i] * max_so_far);
                }
                max_so_far = curr_max;
                min_so_far = curr_min;
            result = Math.max(result,max_so_far);
        }
        return result;
    }
	public static void main(String[] args) 
	{
		//int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] arr = {1, -2, -3, 0, 7, -8, -2};
		System.out.println("largest product of subarray : "+maxProduct(arr));
		
	}
} 