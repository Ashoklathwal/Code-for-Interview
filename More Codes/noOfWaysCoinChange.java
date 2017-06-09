import java.util.*;

class noOfWaysCoinChange
{
    public static void noOfWaysCoinChange_util(int[] arr, int sum)
    {
        int[][] T = new int[arr.length+1][sum+1];
        // min no. of ways when sum is zero
        for(int i=0;i<=arr.length;i++)
            T[i][0] = 1;

        for(int i=1;i<=arr.length;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j < arr[i-1])
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = T[i-1][j] + T[i][j-arr[i-1]];
            }
        }

        for(int[] temp : T)
          System.out.println(Arrays.toString(temp));
        System.out.println("Min number of ways to get sum : "+T[arr.length][sum]);
  
    }
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3};
        int sum = 5;
        noOfWaysCoinChange_util(arr,sum);
    }
}

/*

  
     * Space efficient DP solution
     
    public int numberOfSolutionsOnSpace(int total, int arr[]){

        int temp[] = new int[total+1];

        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                if(j >= arr[i]){
                    temp[j] += temp[j-arr[i]];
                }
            }
        }
        return temp[total];
    }
*/
