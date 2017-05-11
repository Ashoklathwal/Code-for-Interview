import java.util.*;
import java.lang.*;
class sidAndMaxMoney
{
	//check number is prime or not
	public static boolean prime(long num)
	{
		if(num == 1)
		{
			return false;
		}
		for(long i=2;i <= Math.sqrt(num);i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i < t ; i++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int j=0;j<n;j++)
				arr[j]=sc.nextInt();
			int init_start = 0, init_end = 0, start = 0, end = 0, count = 1, max_count = 1;
			for(int j=1;j<n;j++)
			{
				if(arr[j] > arr[j-1])
				{
					count++;
				
				   if(count > max_count)
				      {
					   max_count = count;
					   start = init_start;
				       end = j;
				      }
				}
				else
				{
					init_start = j;
					init_end = j;
					count = 1;
				}
			}
			/*for(int j=start;j<=end;j++)
			{
			    System.out.print(arr[j]+" ");
			}*/
			long sum = 0;
			for(int j=start;j<=end;j++)
			{
				// check primality
				if(prime(arr[j]))
					sum+=arr[j];

			}
			System.out.println(max_count +" "+ sum);
		}
	}
}
/*
3
9
4 2 3 5 1 6 7 8 9
10
2 3 5 7 4 1 6 5 4 8
5
2 2 2 2 2
*/