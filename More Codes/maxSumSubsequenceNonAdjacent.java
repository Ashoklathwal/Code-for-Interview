/**
 * Date 02/06/2017
 * @author Ashok lathwal
 *
 * Find maximum sum for non adjacent elements.
 * Variation is finding maximum sum non adjacent elements assuming its a circular array.
 * So first element cannot be with last element.
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 */

class maxSumSubsequenceNonAdjacent
{
	public static int sumNonAdjacent(int[] arr)
	{
		int[] sum = new int[arr.length]; // store the max sum upto particular element
		sum[0] = arr[0];
		sum[1] = Math.max(arr[0],arr[1]);
		for(int i=2; i<arr.length; i++)
		{
			int temp = Math.max(arr[i], arr[i] + sum[i-2]);
			sum[i] = Math.max(temp, sum[i-1]);
		}
		return sum[arr.length-1];

		
		/**
		  * variation to this problem : if array is circular then
          * Find maximum sum from left to right ignoring first element.
          * Find maximum sum from right to left ignoring last element.
          * Maximum of two will be the answer. It gurantees that both first and last element
          * will be not selected together.
       */
		
	}
	public static void main(String[] args) 
	{
		int[] arr = {10, 5, 3, -3, -2, 6, 10};
		System.out.println("max Sum with Non Adjacent element : "+sumNonAdjacent(arr));
		
	}
}