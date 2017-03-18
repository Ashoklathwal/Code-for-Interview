import java.io.*;
class AllPermutationWithOutDuplicateInInput
{
	static String swap(String str, int a, int b)
	{
		char[] arr=str.toCharArray();
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b]  = temp ;
		return String.valueOf(arr);

	}
	static void allPermute(String str, int m, int n)
	{
		if(m ==n)
			System.out.println(str);
		else
		{
			for(int i=m;i<=n;i++)
			{
				str = swap(str,m,i);
				allPermute(str,m+1,n);
			    str = swap(str,m,i); // for backtracking
			}
		}
	}

	public static void main(String args[])
	{
		String str="ABCD";
		int n=str.length();
		allPermute(str,0,n-1);
	}
}
