import java.lang.StringBuffer;
class longestPalindromicSubsequence
{
	public static void longestPalindromicSubsequence_util(String str, int n)
	{
		int[][] mem = new int[n][n];
		// min length palindromic str will be 1
		for(int i=0;i<n;i++)
		{
			mem[i][i] = 1;
		}
         // i: start index, j: end index (inclusive) 
		for(int i=n-1; i>=0; i--)  // row from bottom to top
		{
			for(int j=0; j<n;j++)  // column from left to right
			{
				if(j > i)  // if top triangle of memory table 
				{
					if(str.charAt(i) == str.charAt(j))
						mem[i][j] = 2 + mem[i+1][j-1];
					else
						mem[i][j] = Math.max(mem[i][j-1], mem[i+1][j]);
				}
				// skip bottom-half triangle (including diagonal) as they were preprocessed 
				else
				{
					continue;
				}
			}
		}

		System.out.println("Length of longest palindromic Subsequence : "+mem[0][n-1]); 

		// Now print longest palindromic subsequence
		int i = 0;
		int j = n-1;
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		while(mem[i][j] > 0)
		{
			char front = str.charAt(i);
			char back = str.charAt(j);
			if(front == back)
			{
				sb1.append(front);
                sb2.append(back);
                i++;
                j--;   
			}
			else if(mem[i][j] == mem[i+1][j])
				    i++;
			else if(mem[i][j] == mem[i][j-1])
				    j--;

		}
		//  generate palindrome 
		sb2.reverse();
        // if palindrome length is even 
		if(mem[0][n-1] % 2 == 0)
		{
			sb1.append(sb2);
		}
		else
		{
			sb1.append(sb2.substring(1));   // ignore duplicated first character from sb2 (presented in sb1)
		}

		System.out.println("longest Palindromic Subsequence : "+ sb1);
	}
	public static void main(String[] args) 
	{
		String str = "agbdba";
		int n = str.length();
		longestPalindromicSubsequence_util(str, n);
		
	}
}