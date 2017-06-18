/*
Given an array of 2n elements of which n elements are same and the remaining n elements are all different. 
Write a  program to find out the value which is present n times in the array. 
There is no restriction on the elements in the array. They are random (In particular they not sequential)

Approach :
          first traverse all element if adjacent element are equal print that element and return
          otherwise cheak first 4 element.
*/

class N_same
{
	public static void N_same_util(int[] arr, int m)
	{
		int n = m/2;
		for(int i=1;i<m;i++)
		{
			if(arr[i-1] == arr[i])
			{
				System.out.println(arr[i]);
				return;
			}
		}

		if(arr[0] == arr[2] || arr[0] == arr[3])
		{
			System.out.println(arr[0]);
				return;
		}
        
        if(arr[1] == arr[3])
		{
			System.out.println(arr[1]);
				return;
		}

	}
	public static void main(String[] args) 
	{
		int[] arr = {2,3,4,5,6,1,1,1,1,1}; 
		int m = 10;
		N_same_util(arr, m);
	}
}