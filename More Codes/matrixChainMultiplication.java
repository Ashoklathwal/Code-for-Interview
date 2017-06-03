import java.util.Arrays;
class matrixChainMultiplication
{
	static void extract_sequence(int[][] split,int i,int j)
	{
				if(i == j)
				{
					System.out.print("p"+i);
					return;
				}
				else
				{
					int k=split[i][j];
					System.out.print("(");
					extract_sequence(split, i, k);
					extract_sequence(split, k+1, j);
					System.out.print(")");
				}	
	}

	public static void mcm_util(int[] val)
	{
		int n=val.length;
		//n=4
		// store min cost required to multiply matrices
		int[][] mcm = new int[n][n]; 
		// store number of split required to multiply matrices
		int[][] split = new int[n][n];
		

		for(int l=2; l<n;l++)
		{
			for(int i=1;i<n-l+1; i++)
			{
				int j = i+l-1;
				mcm[i][j] = Integer.MAX_VALUE;
				for(int k = i; k<j; k++)
				{
					int q = mcm[i][k] + mcm[k+1][j] + val[i-1]*val[k]*val[j];
					if(q < mcm[i][j])
					{
						mcm[i][j] = q;
						split[i][j] = k; // keep track of split marker
					}
				}
			}
		}

		//System.out.println(Arrays.deepToString(mcm));
		//System.out.println(Arrays.deepToString(split));
		System.out.println("The min number of multiplication required :"+mcm[1][n-1]);
		//System.out.println("The min number of split required :"+split[0][n-1]);
		//System.out.println("The extracted sequence is :");
		extract_sequence(split, 1, n-1);
		pla(mcm);
		System.out.println();
		pla(split);
	}

	static void pla(int[][] a){
		for(int[] ab:a){
			System.out.println(Arrays.toString(ab));
		}
	}
	public static void main(String[] args) 
	{
		int[] val ={40, 20, 30, 10, 30};// number of matrices are 4
		mcm_util(val);
		
	}
}