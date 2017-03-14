import java.util.*;
public class quickSort {
	// partition method
	static int partition(int[] arr,int p,int q)
	{
	int x=arr[q];
	int i=p-1;
	int j;
	for(j=p;j<=q-1;j++)
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
	int temp=arr[i+1];
	arr[i+1]=arr[q];
	arr[q]=temp;
		return i+1;
	
		
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
	System.out.println("The given array is:");
	printArray(arr);
	qSort(arr,0,arr.length-1);
	System.out.println("The sorted array is:");
	printArray(arr);
}


}