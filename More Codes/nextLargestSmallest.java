class nextLargestSmallest
{
	public static int smallest(int num)
	{
		if((num & (num+1)) == 0) //   000011111
		{
		   System.out.println("smallest number not possible");
		   return -1;
		}
		int a = 1;
		while(a & num)   //    100011111
			a <<=1;
		while(!(a & num)) //   1110110000
			a <<=1;

		num = num - a/2;
		return num;

	}
	public static int largest(int num)
	{
		// num = 00011100
		// right most set bit
		int rightOne = num & -num; // rightone = 00000100
		//System.out.println(Integer.toBinaryString(rightOne));
		// reset the pattren and set next higher bit
		int nextHigherOneBit = num + rightOne; // nextHigherOneBit = 00100000
		//System.out.println(Integer.toBinaryString(nextHigherOneBit));
		int ones = num ^ nextHigherOneBit; // ones = 00111100
		//System.out.println(Integer.toBinaryString(ones));   
		// right adjust pattern
        ones = ones/rightOne; // ones =  00001111
        //   System.out.println(Integer.toBinaryString(ones)); 
        // correction factor
        ones >>=2;  // ones = 00000011
        //System.out.println(Integer.toBinaryString(ones));

        return nextHigherOneBit | ones; // 00100011 (35)
	}
	public static void main(String[] args) 
	{
		int num = -10;
		System.out.println("Next largest element with same number of one's : "+largest(num));
		System.out.println("Next smallest element with same number of one's : "+smallest(num));
		
	}
}