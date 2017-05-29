/*
Integer.toString(n,8) // decimal to octal

Integer.toString(n,2) // decimal to binary

Integer.toString(n,16) //decimal to Hex

Integer.parseInt(str, AnyBase) // convert string to AnyBase  


*/

import java.util.*;
class DecimalToBinary
{
	public static String printBinary(double num) 
	{
		if (num >= 1 || num <= 0)
			return "Error";
		StringBuilder result = new StringBuilder();
		result.append("0.");
		while (num > 0) 
		{
			if (result.length() >= 32)
				return "Error";
			double r = num * 2;
			if (r >= 1) 
			{
				result.append("1");
				num = r - 1;
			} else 
			{
				result.append("0");
				num = r;
			}
		}
		return result.toString();
	}
	public static void main(String[] args) 
	{
		System.out.print(printBinary(0.55));		
	}
}