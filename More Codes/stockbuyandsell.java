import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     for(int i=0;i<t;i++)
	     {
	         
	         int n  = sc.nextInt();
	         int[] arr = new int[n];
	         for(int j=0;j<n;j++)
	            arr[j] = sc.nextInt();
	        maximumProfitMultipleTransactions(arr); 
	        System.out.println();
	     }
	 //code
	 }
public static void maximumProfitMultipleTransactions(int[] arr) 
	{
	    int buy = 0;
	    int sell = 0;
	    int profit = 0;
	    int i=0;
	    int n = arr.length;
	    int b_index = 0;
	    int s_index = 0;
	    int flag = 0;
	    int count = 0;
	    while(i<n-1)
	    {
	        while(i<n-1 && arr[i]>=arr[i+1])
	        {
	                  i++;
	        }
	        if(i >= n-1)
	        {
	            flag  = 1;
	           break;
	        }
	        if(i<n-1)
	        {
	           buy = arr[i];
	           b_index  = i;
	        }
	           i++;
	  // System.out.println(buy);        
	        while(i<n-1 && arr[i] <= arr[i+1])
	           i++;
	           
	        if(i <= n-2 && arr[i] > arr[i+1])
	        {
	           sell = arr[i];
	           s_index = i;
	        }
	      else  if(i == n-1 && arr[i] > buy)    
	         {
	             sell = arr[i];
	             s_index = i;
	         }
	         else
	         {
	             flag  = 1;
	             break;
	         }
	         count++;
	       System.out.print("("+b_index+" "+s_index+")"+" ");
	       
	         //profit += (sell - buy);
	    }
	    if(flag == 1 && count == 0)
	    System.out.print("No Profit");
	   // return profit;
		// Write your code here
	

}
}