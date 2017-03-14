import java.util.*;
public class mergeSort {
	// merging the 2 arrays
	//static int a=0;
	/*static int count=0; 
	static void	merge(int[] arr,int l,int mid,int r)
		{
			// find size of 2 subarrays
		int n1=mid-l+1;
		int n2=r-mid;
	     //int count=0;
		// create 2 subarrays
		int[] L=new int[n1];
		int[] R=new int[n2];
		// copy the elements into 2 subarrays
		for(int i=0;i<n1;i++){
			L[i]=arr[l+i];
		}
		for(int j=0;j<n2;j++){
			R[j]=arr[mid+1+j];
		}
		//initiall indicies of 2 subarrays
		int i=0;
		int j=0;
		// initial index of final array
		int k=l;
		// merge these 2 subarrays after sorting the data in final single arrays 
		while(i<n1 && j<n2)
		{
			if(L[i]<=R[j])
			{
				arr[k++]=L[i++];
			}
			else
			{
				arr[k++]=R[j++];
				count=count+(n1-i);
			}
		}
		// copy the remaining array
		while(i<n1)
		{
			arr[k++]=L[i++];
		}
		while(j<n2)
		{
			arr[k++]=R[j++];
		}
	
		}
	*/
	
	static void	merge(int[] arr,int []B,int l,int mid,int r)
	{
		
		int i=l,j=mid+1;
	int a=l;
		while(i<=mid && j<=r)
		{
			if(arr[i]>arr[j])
				B[a++]=arr[j++];
			else
				B[a++]=arr[i++];
		}
		// ramining element should be copy
		while(i<=mid)
		{
			B[a++]=arr[i++];
		}
		while(j<=r)
		{
			B[a++]=arr[j++];
		}
		for(i=l;i<=r;i++)
			arr[i]=B[i];
		
	}
	 // sort the array
	  void sort(int[] arr,int[]B,int l,int r ){
		if(l==r){
			//return;
			//System.out.println(arr[l]);
		}
		else if(l<r)
		{
			//find middle element to divide the array in 2 parts
		int	mid=(l+r)/2;
			sort(arr,B,l,mid);
			sort(arr,B,mid+1,r);
			// merge the 2 halves
			merge(arr,B,l,mid,r);
		}
		
	}
	
	// printing the array
	static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	// Driver method 
	public static void main(String args[]){
		int arr[]={9,8,7,6,-11,4,3,0,2,55,12,13,-2};
		System.out.println("Enter the Array u want to sort");
		printArray(arr);
		int[] B=new int[arr.length];
	    mergeSort mg=new mergeSort();
		mg.sort(arr,B, 0, arr.length-1);
		System.out.println("Sorted array is:");
		printArray(arr);
		//System.out.println("number of inversion pairs is "+count);
	
	}

}