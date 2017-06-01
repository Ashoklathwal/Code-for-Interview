/*
Method 1 ( Brute Force ) 
The simple approach is to check each substring whether the substring is a palindrome or not.
We can run three loops, the outer two loops pick all substrings one by one by fixing the 
corner characters, the inner loop checks whether the picked substring is palindrome or not.

Time complexity: O ( n^3 )
Auxiliary complexity: O ( 1 )

Method : 2
Idea is that :
             Generate all even length && odd length palindrome by taking one by one character 
             and keep track of longest palindrome so far.
             Steps to generate even length palindrome :
               fix 2 center ( low and high ) and expand in both direction for longer palindrome
             Steps to generate odd length palindrome :
               fix a center and expand in both direction for longer palindrome  
*/

class longestPalindromicSubString1
{
	public static void longestPalindromicSubString1_util(String str, int len)
	{
		int max_length = 1; // store length of longest Palindromic SubString
		int start = 0;
		int low;
		int high;

        // consider one by one every character as center point of even and odd length pailndrome  
		for(int i=1; i<len; i++)
		{
			// Find the longest even length palindrome with center points as i-1 and i
			low = i - 1;
			high = i;
			while(low >= 0 && high < len && str.charAt(low) == str.charAt(high))
			{
				if(high - low + 1 > max_length)
				{
				   start = low;
				   max_length = high - low + 1;
				}
				low--;
				high++;
			}
			// Find the longest odd length palindrome with center points as i-1 and i+1
            low = i - 1;
			high = i + 1;
			while(low >= 0 && high < len && str.charAt(low) == str.charAt(high))
			{
				if(high - low + 1 > max_length)
				{
				   start = low;
				   max_length = high - low + 1;
				}
				low--;
				high++;
			}
   		}

   		System.out.println("Length of longest Palindromic SubString : "+max_length);
   		System.out.print("longest Palindromic SubString : ");

   		for(int i=start; i<=(start + max_length - 1); i++)
   			System.out.print(str.charAt(i));
	}
	public static void main(String[] args) 
	{
		String str = "abaxabaxabb";
		int len = str.length(); 
		longestPalindromicSubString1_util(str, len); 
	}
}