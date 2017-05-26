/*
EXAMPLE
pale, ple -) true
pales, pale -) true
pale, bale -) true
pale, bae -) false

Approach :
           if both strings are same then oneEditReplacement 
           if both strings are one length different the oneEditInsert 

Replacement: Consider two strings, such as bale and pale, that are one replacement away. Yes, that
             does mean that you could replace a character in bale to make pale. But more precisely, it means that
             they are different only in one place.
Insertion:   The strings apple and aple are one insertion away. This means that if you compared the
             strings, they would be identical-except for a shift at some point in the strings.
Removal:     The strings apple and aple are also one removal away, since removal is just the inverse of
             insertion.
*/

class oneEditAway
{
	public static boolean oneEditReplacement(String s1, String s2)
	{
		boolean foundDifference = false;
		for(int i=0; i<s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				if(foundDifference)
					return false;
				foundDifference = true;
			}
		}
		return true;
	}

	public  static boolean oneEditInsert(String s1, String s2)
	{
		int index1 = 0;
		int index2 = 0;
		while(index1 < s1.length() && index2 < s2.length())
		{
			if(s1.charAt(index1) != s2.charAt(index2))
			{
				if(index1 != index2)
				{
					return false;
				}
				if(s1.length() > s2.length())
					index2++;
				else
					index1++;
			}
			else
			{
				index1++;
				index2++;
			}
		}
		return true;
	}
	public static boolean oneEdit(String s1, String s2)
	{
		if(s1.length() == s2.length())
			return oneEditReplacement(s1, s2);
		else if((s1.length() + 1) == s2.length())
			return oneEditInsert(s1, s2);
		else if((s1.length() - 1) == s2.length())
			return oneEditInsert(s1, s2);
		return false;

	}
	public static void main(String[] args) 
	{
		String s1 = "pales";
		String s2 = "palesa";
		System.out.println(oneEdit(s1, s2));
	}
}