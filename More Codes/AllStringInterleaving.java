class AllStringInterleaving
{
	public static void allStringInterleaving_util(String str1, String str2, String interleavingString)
	{
		if((str1 == null || str1.length() == 0) && (str2 == null || str2.length() == 0))
			return;
		if(str1 == null || str1.length() == 0)
		{
			System.out.println(interleavingString + str2);
			return;
		}
		if(str2 == null || str2.length() == 0)
		{
			System.out.println(interleavingString + str1);
			return;
		}

		//Now we will keep picking one letter from string 1 in each recursive call until 
		//there is no letter remaining in string 1 and then we will keep picking one letter 
		//from string 2 in each recursive call until there is no letter remaining in string 2.
		allStringInterleaving_util(str1.substring(1), str2, interleavingString + str1.charAt(0));
		allStringInterleaving_util(str1, str2.substring(1), interleavingString + str2.charAt(0)); 	
	}
	public static void main(String[] args) 
	{
		String str1 = "AB",  str2 = "CD";
		allStringInterleaving_util(str1, str2, "");
	}
}