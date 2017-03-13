// it will take O(4^n) time
import java.util.*;
class AllPossibleString
{
	public static char table[][]={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public static void allPossibleCombinination(char[][] table, int start,int end, int[] arr, char[] output)
    {
    	if(start == end)
    	{
    		for(int i=0; i < output.length; i++)
                System.out.print(output[i]);
    	    //System.out.println();
    	    return;
    	    // return will take us out of method
    	}
    	for(int i=0;i<table[arr[start]].length; i++)
    	{
    		//System.out.println(table[arr[start]].length);
    		output[start] = table[arr[start]][i];
    		allPossibleCombinination(table,start+1,end,arr,output);
    	}	
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=3;
		int arr[]={2,3,4};
		//first i will remove the 0 and 1 from the array it will take o(n) time
		//System.out.println(Arrays.deepToString(table)); 
		char output[]=new char[n+1];
		output[n]='\0';
		allPossibleCombinination(table,0,n,arr,output);
    
	}
    	
}