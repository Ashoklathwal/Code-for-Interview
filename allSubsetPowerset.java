import java.io.*;
class allSubsetPowerset
{
	public void subset(char[] arr)
	{
		System.out.println("*****************All subset are :********************");
		int n=arr.length;
		for(int i=0; i < (1<<n); i++)
		{
			System.out.print("{");
			for(int j=0; j < n; j++)
			{
				if((i & (1<<j)) > 0)
				{
					System.out.print(arr[j]+"  ");
				}
			}
			System.out.println("}");
		}
	}
	public void powerset(char[] arr)
	{
		System.out.println("****************All powerset are : *******************");
		int n=arr.length;
		System.out.print("{");
		for(int i=0; i < (1<<n); i++)
		{
			System.out.print("{");
			for(int j=0; j < n; j++)
			{
				if((i & (1<<j)) > 0)
				{
					System.out.print(arr[j]+"  ");
				}
			}
			System.out.println("}");
		}
		System.out.print("}");
	}
	public static void main(String args[])
	{
		char[] arr={'a','b','c','d'};
		allSubsetPowerset asp = new allSubsetPowerset();
		asp.subset(arr);
		asp.powerset(arr);

	}
}