/*
Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. 
C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved
*/
class IsInterleaved
{
	public static boolean isInterleaved_util(String A, String B, String C)
	{
		int i = 0, j=0, k=0;
		while(k < C.length())
		{
			if(i < A.length() && A.charAt(i) == C.charAt(k))
			{
				i++;
				k++;
			}
			else if(j < B.length() && B.charAt(j) == C.charAt(k))
			{
				j++;
				k++;
			}
			// If doesn't match with either A or B, then return false
			else
			{
				return false;
			}
		}
        // If A or B still have some characters, then length of
	    // C is smaller than sum of lengths of A and B, so 
	    // return false
		if(i != A.length() || j != B.length())
			return false;	
		return true;
	}
	public static void main(String[] args) 
	{
		String A = "AB";
        String B = "CD";
        String C = "ACBG";
		if(isInterleaved_util(A , B , C) == true)
		    System.out.println(C + " is interleaved of " + A + " and " + B);
	    else
		    System.out.println(C + " is not interleaved of " + A + " and " + B);
	}
}