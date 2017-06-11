import java.io.*;
import java.util.*;
class subarraySum 
{
    static void subarray(int arr[],int x)
    {
        int n=arr.length;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int rem=0,sum=0,i;
        for(i=0; i<n; i++)
        {
            sum += arr[i];
            if(sum == x)
                { 
                    System.out.println("0"+"--->"+i);
                    break;
                }
            rem = sum-x;
            if(h.containsKey(rem))
                {
                    System.out.println(h.get(rem)+1 + " ---> " +i);
                    break;
                }
            else
            {
                h.put(sum,i);
            }
        }
        
    }
	public static void main (String[] args) 
    {
	  int arr[] = {1,4,20,3,10,5};
	  subarray(arr,33);
	}
}