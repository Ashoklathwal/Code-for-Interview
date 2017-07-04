class K_Anagrams
{
	public static boolean kAnagram_util(String str1, String str2, int k)
	{
		int n = str1.length();
        if (str2.length() != n)
               return false;
        // considering only lowercase english alphabet
		int[] freq = new int[26];
		//int[] count2 = new int[26];

		for(int i=0;i<str1.length();i++)
			freq[str1.charAt(i)-'a']++;
        
        int count = 0;
	
		for(int i=0;i<str2.length();i++)
		{
			if(freq[str2.charAt(i)-'a'] > 0)
		      	freq[str2.charAt(i)-'a']--;
		    else count++;  

		    if(count > k)
			   return false;
		}
		return true;
	}
	public static void main(String[] args) 
	{
		String  str1 = "geeks"; 
		String  str2 = "eggkf";
		int k = 1;
		System.out.println("K-Anagram or not   : "+kAnagram_util(str1, str2, k));
	}
}