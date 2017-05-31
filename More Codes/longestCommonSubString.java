/*
The longest common suffix has following optimal substructure property
   LCSubstring(arr1, arr2, m, n) = LCSubstring(arr1,arr2, m-1, n-1) + 1 if X[m-1] = Y[n-1]
                                           0                           Otherwise (if X[m-1] != Y[n-1])

The maximum length Longest Common Suffix is the longest common substring.
   LCSubstring(arr1, arr2, m, n)  = LCSubstring(arr1, arr2, i, j) where 1 <= i <= m
                                                                    and 1 <= j <= n


*/

import java.util.Arrays;
class longestCommonSubString
{
	public static void longestCommonSubString_util(char[] arr1, char[] arr2, int m, int n)
	{
		int[][] lcsubstring = new int[m+1][n+1];
		int max = 0;
		// p and q storing the index in lcsubstring for later printing
		int p = 0;
		int q = 0;
		for(int i=1; i <=m; i++)
		{
			for(int j=1; j<=n; j++)
			{
			  if(arr1[i-1] == arr2[j-1])
				{
					lcsubstring[i][j] = 1 + lcsubstring[i-1][j-1];
					if(lcsubstring[i][j] > max)
					{
						max = lcsubstring[i][j];
						p = i;
						q= j;

					}
					//max = Math.max(lcsubstring[i][j], max);
				}
				else
				{
					lcsubstring[i][j] = 0;
				}
			}
		}

		System.out.println("Length of longest Common SubString is : "+max);

		//printing max substring we have to go diagonaly
        int maxval = max;
        char[] sub=new char[maxval+1];
        sub[maxval]='\0';
        int i=p;
        int j=q;
        while(i>0 && j>0)
            {
               if(arr1[i-1] == arr2[j-1])
                  {
                     sub[maxval-1]=arr1[i-1];
                     i--;
                     j--;
                     maxval--;
                  }
              /*else if(lcsubstring[i-1][j] > lcsubstring[i][j-1])
                  {    
                     i--;
                  }   
              else
                  {
                     j--;
                  }*/
             }
          System.out.print("The longest common substring is :"+ Arrays.toString(sub)); // ignore last char it is empty
	}
	public static void main(String[] args) 
	{
		char[] arr1 = "abcdxyz".toCharArray();
        char[] arr2 = "xyzabcd".toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        longestCommonSubString_util(arr1,arr2,m,n);
		
	}
}