/*
Time Complexity: O(nk)
Auxiliary Space: O(k)

Given an array of of size n and a number k, find all elements that appear more than n/k times

why the output cant exceed k-1 size ???

think of it as k=2 or k=3

if k=2 and n = 6 then obviously only 1 element can have count more than n/k i.e. >3
similarly by taking k=3, n= 6, there can be 2 numbers with count > 2 etc..

We can extrapolate and see the o/p max is k-1 size
*/

import java.util.Arrays;
class moreThanNdK
{
	static class cell
	{
		int ele;
		int count;
	}
    public static void moreThanNdK_util(int[] arr, int k)
    {
    	// k must be greater than 1 to get some output
    	if(k < 2)
    		return;

    	/* Step 1: Create a temporary array (contains element
       and count) of size k-1. Initialize count of all
       elements as 0 */

       int n = arr.length;
       cell[] temp = new cell[k-1];
       for(int i=0;i<k-1;i++)
       	temp[i] = new cell();

       // Step 2: Process all elements of input array 
        
       for(int i=0;i<n;i++)
       {
       	int j;

       	/* If arr[i] is already present in
           the element count array, then increment its count */
           for(j = 0;j<k-1;j++)
           {
           	if(arr[i] == temp[j].ele)
           	{
           		temp[j].count += 1;
           		break;
           	}
           }

         // If arr[i] is not present in temp[]
           if(j == k-1)
           {
           	int l;

           	/* If there is position available in temp[], then place 
              arr[i] in the first available position and set count as 1*/
              for(l=0;l<k-1;l++)
              {
              	if(temp[l].count == 0)
              	{
              		temp[l].ele = arr[i];
              		temp[l].count = 1;
              		break;
              	}
              }

              /* If all the position in the temp[] are filled, then 
               decrease count of every element by 1 */

               if(l == k-1)
               {
               	for(l=0;l<k-1;l++)
               	{
               		temp[l].count -= 1;
               	}
               }
           } 
       } 
        
        //for(int m=0;m<k-1;m++)
        //	System.out.println(temp[m].ele+" ");

       // Step 3: Check actual counts of potential candidates in temp[]
       for(int i=0;i<k-1;i++)
       {
       	int ac = 0;
       	for(int j=0;j<n;j++)
       	{
       		if(temp[i].ele == arr[j])
       			ac ++;
       	}

       	if(ac > n/k)
       		System.out.println("ele  "+temp[i].ele+"  count   "+ac);
       }

    }
	public static void main(String[] args) 
	{
		int arr[] = {4, 5, 6, 7, 8, 4, 4};
		int k = 3;
		moreThanNdK_util(arr, k);
	}
}