class spiralForm
{
	public static void printSpiral(int[][] arr, int m, int n)
	{
		int T = 0, B = m-1, L = 0, R = n-1, dir = 0;

		while(T <= B && L <= R)
		{
			if(dir == 0)
			{
				for(int i=L; i<=R; i++)
				{
					System.out.print(arr[T][i]+" ");
				}
				T++; dir = 1;
			}
			else if(dir == 1)
			{
				for(int i=T; i<=B; i++)
				{
					System.out.print(arr[i][R]+" ");
				}
				R--; dir = 2;
			}
			else if(dir == 2)
			{
				for(int i=R; i>=L; i--)
				{
					System.out.print(arr[B][i]+" ");
				}
				B--; dir = 3;
			}
			else if(dir == 3)
			{
				for(int i=B; i>=T; i--)
				{
					System.out.print(arr[i][L]+" ");
				}
				L++; dir = 0;
			}
		}
	}
	public static void main(String[] args) 
	{
		int rows = 3;
		int columns = 6;  
		int[][] arr = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}};
        printSpiral(arr, rows, columns);              
		
	}
}