import java.util.*;
class maxSumk_kMatrix
{
	public static void maxSumk_kMatrix_util(int[][] mat, int k)
	{
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] temp = new int[rows][cols];

		for(int j=0;j<cols;j++)
		{
			int sum = 0;
			for(int i=0;i<k;i++)
			{
				sum += mat[i][j];
			}
			temp[0][j] = sum;

		    for(int i=1;i<rows-k+1;i++)
		    {
		    	sum += mat[i+k-1][j] - mat[i-1][j];
		        temp[i][j] = sum;
		    }		
		}

		int max_sum = Integer.MIN_VALUE;
		int index_i = 0;
		int index_j = 0;

		for(int i=0;i<rows-k+1;i++)
		{
			int sum = 0;
			for(int j=0;j<k;j++)
			{
				sum += mat[i][j];
			}

			if(max_sum < sum)
			{
				max_sum = sum;
				index_i = i;
				index_j = 0;
			}

		    for(int j=1;j<cols-k+1;j++)
		    {
		    	sum += mat[i][j+k-1] - mat[i][j-1];
		        if(max_sum < sum)
		        {
		        	max_sum = sum;
		        	index_i = i;
		        	index_j = j;
		        }
		    }		
		}

        
        int toatal_sum = 0;
        for(int i=index_i;i<index_i+k;i++)
        {
        	for(int j=index_j;j<index_j+k;j++)
        	{
        		toatal_sum += mat[i][j];
        		System.out.print(mat[i][j]+" ");
        	}
        	System.out.println();
        }

        System.out.println("total sum is : "+toatal_sum);
		//for(int[] arr : temp)
		//	System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) 
	{
		int mat[][] =   {{1, 1, 1, 1, 1},
                         {2, 2, 2, 2, 2},
                         {3, 8, 6, 7, 3},
                         {4, 4, 4, 4, 4},
                         {5, 5, 5, 5, 5}};
        int k = 3;
        maxSumk_kMatrix_util(mat, k);
		
	}
}