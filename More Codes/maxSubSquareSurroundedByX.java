/*
* Find maximum subsquare in a matrix made up of Xs and Os such that all four sides of subsquare are Xs. It does not matter what is inside
 * the subsquare. All 4 sides should be made up entirely of Xs
 * 
 * e.g 
 * 0 0 0 0 0 X         0,0  0,0  0,0  0,0  0,0  1,1
 * 0 X 0 X X X         0,0  1,1  0,0  1,1  1,2  2,3 
 * 0 X 0 X 0 X         0,0  2,1  0,0  2,1  0,0  3,1
 * 0 X X X X X         0,0  3,1  1,2  3,3  1,4  4,5
 * 0 0 0 0 0 0         0,0  0,0  0,0  0,0  0,0  0,0   
 * 
 * Output of above program should be 3
 * 
 * Solution
 * Have another matrix which is capable of holding 2 values hori and ver. 
 * Ver stores how far vertically you can see Xs. Hori stores how far horizontally you can see Xs.
 * Once this matrix is build look for biggest subsquare by getting min of hori and ver at each point and checking
 * if subsquare can be formed from value min to 1.
 * 
 * Test cases:
 * Matrix entirely made up of Xs
 * Matrix entirely made up of Os
 * Matrix with Xs and Os but maximum subsquare is length 1
 */
class maxSubSquareSurroundedByX
{
	static class cell
	{
		int vert;
		int hori;
	}
	public static void maxSubSquareSurroundedByX_util(char[][] arr)
	{
		int m = arr.length;
		int n = arr[0].length;
		cell[][] table = new cell[m][n];

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				table[i][j] = new cell();
			}
		}

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arr[i][j] == 'X')
				{
					if(i == 0 && j == 0)
					{
						table[i][j].vert = 1;
						table[i][j].hori = 1;
					}
					else if(i == 0)
					{
						table[i][j].vert = 1;
						table[i][j].hori = 1 + table[i][j-1].hori;
						
					}
					else if(j == 0)
					{
						
						table[i][j].vert = 1 + table[i-1][j].vert;
						table[i][j].hori = 1;
					}
					else
					{
						table[i][j].vert = 1 + table[i-1][j].vert;
						table[i][j].hori = 1 + table[i][j-1].hori;
					}
				}
			}
		}

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(table[i][j].vert+","+table[i][j].hori+" ");
			}
			System.out.println();
		}


		 //start iterating from bottom right corner and find min of hori or ver at every cell.
        //If this is greater than 1 then see if you can find a number between this min and 1
        //such that on left's ver and top's hori is greater greater than or equal to k.

		int max = 0;
		for(int i=m-1;i>=0;i--)
		{
			for(int j=n-1;j>=0;j--)
			{
				if(table[i][j].vert == 0 || table[i][j].vert == 1 || table[i][j].hori == 0 || table[i][j].hori == 1)
					continue;

				int min = Math.min(table[i][j].vert, table[i][j].hori);
                int k = 0;

                for(k=min; k>1;k--)
                {
                	if((table[i][j-(k-1)].vert >= k) && (table[i-(k-1)][j].hori >= k))
                		break;
                }

                if(max < k)
                	max = k;  
			}
		}
         
        System.out.println("Size of max Sub Square matrix Surrounded By X is : "+max);
        System.out.println();

	}
	public static void main(String[] args)
	{
		char[][] input = {{'X','O','O','O','O','O'},
                          {'O','O','O','O','O','O'},
                          {'X','X','X','X','O','O'},
                          {'X','X','X','X','X','O'},
                          {'X','O','O','X','X','O'},
                          {'X','O','X','X','X','O'}};
        
        char[][] input1 = {{'O', 'O', 'O', 'O', 'O', 'X'},
                           {'O', 'X', 'O', 'X', 'X', 'X'},
                           {'O', 'X', 'O', 'X', 'O', 'X'},
                           {'O', 'X', 'X', 'X', 'X', 'X'},
                           {'O', 'O', 'O', 'O', 'O', 'O'}};
        
        char[][] input2 = {{'O', 'O', 'X', 'O', 'X'},
                           {'O', 'X', 'X', 'O', 'X'},
                           {'O', 'X', 'O', 'X', 'X'},
                           {'X', 'X', 'X', 'X', 'X'},
                           {'O', 'X', 'X', 'X', 'O'}};

        maxSubSquareSurroundedByX_util(input);
        maxSubSquareSurroundedByX_util(input1);
        maxSubSquareSurroundedByX_util(input2);                   
		
	}
}