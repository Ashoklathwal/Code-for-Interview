import java.util.*;
class stringCompression
{
	/* Problem Description:
    Compress a given string "aabbbccc" to "a2b3c3"
   constraint: in-place compression, no extra space to be used
   assumption : output size will not exceed input size..
   ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.*/
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str1 = "aaabbcccDDDDD"; // a3b3c3D5
		StringBuffer str=new StringBuffer(str1);
		StringBuffer str2=new StringBuffer();
		int start = 0, count = 1;
		int i = 0;
		// count continious occurance of eaach character
		for(i = 0; i < str.length() - 1; i++)
		{
			if(str.charAt(i) == str.charAt(i+1))
			{
				count += 1;
			}
			else
			{
				System.out.print(str.charAt(i)+""+count);
				//str.replace(start,i+1,str.charAt(i)+""+count);
				start = i+1;
				count = 1;
			}
		}
		// for last character
		if(str.charAt(str.length()-2) == str.charAt(str.length()-1))
		{
			System.out.print(str.charAt(i)+""+count);
			//str.replace(start,str.length()-1,str.charAt(i)+""+count);
		}
		else
		{
			System.out.print(str.charAt(i+1)+""+count);
		    //str.replace(str.length()-2,str.length(),str.charAt(i+1)+""+count);
		}
		//System.out.println(str);
	}
}