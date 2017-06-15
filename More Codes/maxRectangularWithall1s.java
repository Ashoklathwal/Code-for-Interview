/*
* 
 * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 * 
 * Maintain a temp array of same size as number of columns. 
 * Copy first row to this temp array and find largest rectangular area
 * for histogram. Then keep adding elements of next row to this temp
 * array if they are not zero. If they are zero then put zero there.
 * Every time calculate max area in histogram.
 * 
 * Time complexity - O(rows*cols)
 * Space complexity - O(cols) - if number of cols is way higher than rows
 * then do this process for rows and not columns.
 *
*/

import java.util.*;
class maxRectangularWithall1s
{

	public static void maxRectangularWithall1s_util(int[][] arr, int m, int n)
	{
		int[] hist = new int[n];

        int max_value = 0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j] == 1)
				   hist[j] += arr[i][j];
				else
					hist[j] = 0;
			}

			max_value = Math.max(max_value, larRecArea(hist));
		}

		System.out.println("Largest Rectangular area With all 1s "+max_value);
	}

	static int larRecArea(int[] hist)
	{
		int n = hist.length;
		Stack<Integer> stk = new Stack<>();
		int max_area = 0;
		int curr_max_area = 0; 
        int i=0;
        int top = 0;
        while(i < n)
        {
        	if(stk.isEmpty() || hist[stk.peek()] <= hist[i])
        	{
        		stk.push(i++); // storing the index
        	}
        	else
        	{
        		top = stk.pop();
        		curr_max_area = hist[top]*(stk.isEmpty() ? i : i - stk.peek() -1);
        		if(curr_max_area > max_area)
        			max_area = curr_max_area;
        	}
        }
        // if element are remaining in stack perform upper else area
        while(!stk.isEmpty())
        {
        		top = stk.pop();
        		curr_max_area = hist[top]*(stk.isEmpty() ? i : i - stk.peek() -1);
        		if(curr_max_area > max_area)
        			max_area = curr_max_area;
        }
        return max_area;
	}

	public static void main(String[] args) 
	{
		int m = 6;
		int n = 4;
		int[][] arr = {{1,1,1,0},
                       {1,1,1,1},
                       {0,1,1,0},
                       {0,1,1,1},
                       {1,0,0,1},
                       {1,1,1,1}};
		
		maxRectangularWithall1s_util(arr,m,n);
	}
}