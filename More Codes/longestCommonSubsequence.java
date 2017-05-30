import java.util.Arrays;
class longestCommonSubsequence 
{
    static void lcs_util(char[] arr1, char[] arr2, int m, int n)
     {

        int[][] lcs=new int[m+1][n+1];
        // start in bottom up manner
        for(int i=0; i<=m; i++)
            {
             for(int j=0; j<=n; j++)
                {
                   if(i==0 || j==0)
                     {
                       lcs[i][j]=0;
                     }
                   else if(arr1[i-1] == arr2[j-1])
                     {
                       lcs[i][j] = 1 + lcs[i-1][j-1];   
                     }
                   else
                     {
                       lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                     } 
                     
                    
                }
            }

        //printing max subsequence
        int maxval = lcs[m][n];
        System.out.println("Length of longest common Subsequence :"+maxval);
        char[] sub=new char[maxval+1];
        sub[maxval]='\0';
        int i=m;
        int j=n;
        while(i>0 && j>0)
            {
               if(arr1[i-1]==arr2[j-1])
                  {
                     sub[maxval-1]=arr1[i-1];
                     i--;
                     j--;
                     maxval--;
                  }
              else if(lcs[i-1][j] > lcs[i][j-1])
                  {    
                     i--;
                  }   
              else
                  {
                     j--;
                  }
             }
          System.out.print("The longest common subsequence is :"+ Arrays.toString(sub)); // ignore last char it is empty
        
        }
       
    

    public static void main(String[] args) 
    {
        char[] arr1 = "AGGTAB".toCharArray();
        char[] arr2 = "GXTXAYB".toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        lcs_util(arr1,arr2,m,n);
    }
}