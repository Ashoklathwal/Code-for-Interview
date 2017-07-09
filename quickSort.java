import java.util.*;
public class quickSort {
	// partition method
	static int partition(int[] arr,int p,int q)
	{
	int x=arr[p];
	int i=p;
	int j;
	for(j=i+1;j<=q;j++)
	{
		if(arr[j]<=x)
		{
			i++;
			// swapping of 2 element
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
	}
	int temp=arr[i];
	arr[i]=arr[p];
	arr[p]=temp;
		return i;
	
		
	}
	//quick sort method
	static void qSort(int[] arr,int l,int r)
	{
		if(l<r)
		{
		//int p=r;
		int k=partition(arr,l,r);
		//System.out.println(arr[k]);
		qSort(arr,l,k-1);
		qSort(arr,k+1,r);
		}
	}
	// printing the array
	static void printArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
public static void main(String args[])
{
     int[] arr={34,67,1,6,3,90,5};
	//int[] arr = {25, 70, 42, 91, 16, 45, 9, 21, 44};
	System.out.println("The given array is:");
	printArray(arr);
	qSort(arr,0,arr.length-1);
	System.out.println("The sorted array is:");
	printArray(arr);
}


}
