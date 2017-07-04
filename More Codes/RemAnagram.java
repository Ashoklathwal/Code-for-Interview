class RemAnagram
{
	public static int remAnagram_util(String str1, String str2)
	{
		if(str1.length() == 0)
			return str2.length();
		if(str2.length() == 0)
			return str1.length();
        // considering only lowercase english alphabet
		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for(int i=0;i<str1.length();i++)
			count1[str1.charAt(i)-'a']++;

		for(int i=0;i<str2.length();i++)
			count2[str2.charAt(i)-'a']++;

		int output = 0;
		for(int i=0;i<26;i++)
		{
			output += Math.abs(count2[i] - count1[i]);
		}
		return output;
	}
	public static void main(String[] args) 
	{
		String  str1 = "bcadeh";
		String  str2 = "hea";
		System.out.println("minimum number of characters so that two strings become anagram : "+remAnagram_util(str1, str2));
	}
}