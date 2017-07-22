/*
* Given an array of non negative integers where each element represents the max 
 * number of steps that can be made forward from that element. Write a function to 
 * return the minimum number of jumps to reach the end of the array from first element
 * 
 * Solution 
 * Have 2 for loop. j trails i. If arr[j] + j >= i then you calculate new jump
 * and result.
 * 
 * Space complexity O(n) to maintain result and min jumps
 * Time complexity O(n^2)
 * 
*/
class MinJumps
{
	public static int jump_util(int[] arr)
	{
		int[] result = new int[arr.length]; // store sequence of jumps
		int[] jump = new int[arr.length]; // store min jumps
        // for first element always jumpd will be 0 and after that assume infinity
        for(int i=1;i<arr.length;i++)
        {
        	jump[i] = Integer.MAX_VALUE;
        } 

        for(int i=0;i<arr.length;i++)
        {
        	for(int j=0;j<i;j++)
        	{
        		if(j + arr[j] >= i && jump[j] + 1 < jump[i])
        		{
        			jump[i] = jump[j] + 1;
        			result[i] = j;   
        	    }     		
        	}
        }

        return jump[arr.length-1];

	}
    // if we want to reach at last index
	//  https://leetcode.com/problems/jump-game-ii/
	public static int jump(int[] A) 
	{
	int jumps = 0, curEnd = 0, curFarthest = 0;
	for (int i = 0; i < A.length - 1; i++) 
	{
		curFarthest = Math.max(curFarthest, i + A[i]);
	    System.out.println("i :"+i);
		if (i == curEnd) 
		{
			jumps++;
			curEnd = curFarthest;
		}
	}
	return jumps;
}
	public static void main(String[] args) 
	{
		int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
		System.out.println("Minimum number of jump to reach at end of array : "+jump_util(arr));
		///System.out.println(jump(arr));
	}
}