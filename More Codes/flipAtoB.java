/*
Question: You are given two numbers A and B. Write a program to count number of bits needed to be flipped to convert A to B.
Solution:

  1. Calculate XOR of A and B.      
        a_xor_b = A ^ B
  2. Count the set bits in the above calculated XOR result.
        countSetBits(a_xor_b)

*/

class flipAtoB
{
	public static int countBit(int a, int b)
	{
		int xor = a^b;
		int count = Integer.bitCount(xor);
		return count;
	}
	public static void main(String[] args) 
	{
		int a = 6;
		int b = 5;
		System.out.println("number of bit to be flipped to convert a to b : "+countBit(a,b));  
		
	}
}