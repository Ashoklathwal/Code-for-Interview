import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    //static long count=0;
    static long merge(int[] arr,int l,int mid,int h)
        {
         int i=l,j=mid+1;
        int a=0;
        long count=0;
        int[] brr=new int[h-l+1];
         while(i<=mid && j<=h)
             {
               if(arr[i]>arr[j])
                   {
                     brr[a++]=arr[j++];
                     count=count+mid-i+1;
                   }
               else
                   {
                     brr[a++]=arr[i++];
                   } 
              }
             //copy remaining elements
             while(i<=mid)
                 brr[a++]=arr[i++];
             while(j<=h)
                 brr[a++]=arr[j++];
      // System.arraycopy(brr,0,arr,l,h-l+1);
        //arr=brr.clone();   
        int k=l;
       for(i=0;i<=h-l;i++)
			   arr[k++]=brr[i];
        return count;
        }
    static long mergesort(int[] arr,int l,int h)
        {
        long count=0;
          if(l<h)
              {
                 int mid=(int)Math.ceil((l+h)/2);
                count+= mergesort(arr,l,mid);
                 count+= mergesort(arr,mid+1,h);
               count+=  merge(arr,l,mid,h);
              } 
        return count;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
         
           int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++)
                arr[arr_i] = in.nextInt();
            
             System.out.println(mergesort(arr,0,n-1));
        }
    }
    
    
}
