class maxSumRectangularMatrix
{
	public static void maxSumRectangularMatrix_util(int[][] arr)
	{
		int rows = arr.length;
		int cols = arr[0].length;
		int[] temp = new int[rows];

		//int i= 0, j = 0;
		int max_sum = 0;
		int max_left = 0, max_right = 0, max_up = 0, max_down = 0;

		for(int left=0;left<cols;left++)
		{
			for(int i=0;i<rows;i++)
			{
				temp[i] = 0;
			}

			for(int right=left;right<cols;right++)
			{
				for(int i=0;i<rows;i++)
				{
					temp[i] += arr[i][right];
				}

				// kadane algorithm(Not work if all elements are negative so its assume that atlest one element is zero or greater than zero)

				int k_curr_sum = 0, k_max_sum = 0;
				int k_start = 0, k_end = 0, k_curr_start = 0;
				for(int i=0;i<temp.length;i++)
				{
					k_curr_sum += temp[i];
					if(k_curr_sum < 0)
					{
						k_curr_sum = 0;
						k_curr_start = i+1;
					}

					if(k_max_sum < k_curr_sum)
					{
						k_max_sum = k_curr_sum;
						k_start = k_curr_start;
						k_end = i;
					}

				}
				// assign value of max_sum, max_up, max_down from kadane and max_left, max_right

				if(max_sum < k_max_sum)
				{
					max_sum = k_max_sum;
					max_left = left;
					max_right = right;
					max_up = k_start;
					max_down = k_end;
				}

			}
		}

		System.out.println("max Sum of Rectangular sub-Matrix : "+max_sum); 
		System.out.println();

		for(int i=max_up;i<=max_down;i++)
		{
			for(int j=max_left;j<=max_right;j++)
			{
				System.out.print(arr[i][j]+"   ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int arr[][] = {{ 2,  1, -3, -4,  5},
                       { 0,  6,  3,  4,  1},
                       { 2, -2, -1,  4, -5},
                       {-3,  3,  1,  0,  3}};
        maxSumRectangularMatrix_util(arr);               
		
	}
}