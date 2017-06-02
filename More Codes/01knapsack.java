import java.util.*;
class _01knapsack
{
	public static int knapsack(int[] profit, int[] wt, int capacityOfKnapsack)
	{
		int[][] _01k = new int[profit.length+1][capacityOfKnapsack+1];
		for(int i=0; i<=profit.length; i++)
		{
			for(int j=0; j<=capacityOfKnapsack; j++)
			{
				if(i == 0 || j == 0)
					_01k[i][j] = 0;
				else if(j - wt[i-1] >= 0)
					_01k[i][j] = Math.max(_01k[i-1][j], _01k[i-1][j-wt[i-1]]+profit[i-1]);
				else
					_01k[i][j] = _01k[i-1][j];
			}
		}

		//for(int[] ar:_01k){
		//	System.out.println(Arrays.toString(ar));
		//}
		

        // print all profits 
        int m = profit.length;
        int n = capacityOfKnapsack;
        while(m>0 && n>0)
        {
        	if(_01k[m][n] == _01k[m-1][n])
        		m--;
        	else
        	{
        		System.out.print(profit[m-1]+" ");
        		n = n - wt[m];
        		m--;
        	}
        }



		return _01k[profit.length][capacityOfKnapsack];
	}
	public static void main(String[] args) 
	{
		int[] profit = {75, 50, 80, 90, 20};
		int[] wt = {13, 5, 3, 2, 3};
		int capacityOfKnapsack = 20;
		System.out.println("The maximum profit we get : "+knapsack(profit, wt, capacityOfKnapsack));
		
	}
}