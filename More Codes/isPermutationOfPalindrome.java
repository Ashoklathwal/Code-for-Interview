class isPermutationOfPalindrome
{
	public static void main(String[] args) 
	{
		String str = "tact caas bb"; 
		int countOdd = 0;
        // count frequency of each table
		int[] freqTable = new int['z' - 'a' + 1];
        for(char ch : str.toCharArray())
        {
        	if(ch == ' ')  // it will not work if do like this : if(ch != ' ')
        	{
               // nothing to do
        	}
        	else
        	{	
        	  if(ch >= 'a' && ch <= 'z')
        	   	 freqTable[ch - 'a']++;   
        	  if(freqTable[ch - 'a'] % 2 == 1)
        	   	 countOdd++;
        	  else
        		 countOdd--;
           }
        }
        if(countOdd <= 1)
        	System.out.println("Yes : The given string having a permutation of palindrome");
        else
        	System.out.println("No : The given string does not a permutation of palindrome");		
	}
}