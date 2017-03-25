// Time complexity is O(log(n))
import java.util.*;
class pow
{
	public static long powFunPositive(int x, int y)
	{
		if(y == 0) return 1;
		long temp = powFunPositive(x, y/2);
		if(y % 2 ==0 )
			return temp * temp;
		return x * temp * temp;
	}
	public static float powFunNegative(float x, int y)
	{
		if(y == 0) return 1;
		float temp = powFunNegative(x, y/2);
		if(y % 2 ==0 )
			return temp * temp;
		else
		{
			if(y > 0)
				return x * temp * temp;
			return (temp * temp)/x;
		}
		
	}
	public static void main(String[] args)
	{
		int x = 3;
		int  y = 5;
		System.out.println("output when pow is positive " + powFunPositive(x,y));
		float a = 3;
		int b = -5;
		System.out.println("output when pow  is negative " + powFunNegative(a,b)); 
	}
}