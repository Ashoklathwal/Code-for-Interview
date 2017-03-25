import java.io.*;
import java.util.*;
class square_root
{
	public static float finding_square_root(int n)
	{
		float  x = n;
		float  y = 1;
		float e = (float)0.0001;
		while(x - y > e )
		{
			x = (x + y)/2;
			y = n/x;
		}
		return x;
	}
	public static void main(String[] args) 
	{
		//Scanner sc=new Scanner(System.in);
		//int n=sc.nextInt();
		int n=50;
		System.out.printf("%.2f", finding_square_root(n));
	}
}