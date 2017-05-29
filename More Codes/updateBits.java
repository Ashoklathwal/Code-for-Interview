/*
1. clear the bits j through i in N.
   How do we clear the bits in N? We can do this with a mask. This mask will have all
   1 s, except for Os in the bits j through i. We create this mask by creating the left half of the mask first, and
   then the right half.  
2. shiftLeft M to i^th time so that M lines up with N.
3. merge M and N  

*/

class updateBits
{
	public static void updateBitsJtoi(int N, int M, int i, int j)
	{
		int allOnes = ~0; // all ones 
		int leftMask = allOnes << (j + 1); //contain all ones upto j^th bit
		int rightMask = (1 << i) - 1; 
		int mask = leftMask | rightMask;

		int n_cleared = mask & N;

		int m_shifted = M << i;
		System.out.println(n_cleared | m_shifted);
	}
	public static void main(String[] args) 
	{
		int N = 1024; 
		int M = 19;
		int i = 2;
		int j = 6;
		updateBitsJtoi(N, M, i, j);
		
	}
}