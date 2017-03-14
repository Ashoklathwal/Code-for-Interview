import java.util.*;
import java.lang.*;
class parseStrToInteger
{
	//function which parse string to integer
	public static int strToInt(String str)
	{
		//for checking negative numbers
		boolean neg = false;
		int start=0;
		int number = 0;
		if(str.charAt(0) == '-')
		{
			neg = true;
			start = 1;
		}
		for(int i=start; i < str.length(); i++)
		{
			number *= 10;
			number += str.charAt(i) - '0';
            //number += (int)str.charAt(i);
		}
		if(neg)
			number = -number;
		return number;


	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str="abcd";
		String StringThatCouldBeANumberOrNot = "26263He"; //will throw exception
        String StringThatCouldBeANumber = "26263"; //will not throw exception
        int foo1=0,foo2=0;
    try {
         foo1 = Integer.parseInt(StringThatCouldBeANumberOrNot);
        } catch (NumberFormatException e)
        {
          //Will Throw exception!
          //do something! anything to handle the exception.
        }

    try {
         foo2 = Integer.parseInt(StringThatCouldBeANumber);
        } catch (NumberFormatException e) 
        {
          //No problem this time, but still it is good practice to care about exceptions.
          //Never trust user input :)
         //Do something! Anything to handle the exception.
        }
		 System.out.println(foo1+"   "+foo2);
		 System.out.println(strToInt(StringThatCouldBeANumberOrNot)+"   "+strToInt(StringThatCouldBeANumber));
	}
}