/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
*/

import java.util.*;
class AllAnagrams
{
	public static List<Integer> allAnagrams_util(String str, String p)
	{
		int[] arr = new int[256];
		List<Integer> list = new ArrayList<>();
		if (str == null || str.length() == 0 || p == null || p.length() == 0) 
			return list;
		//record each character in p to arr
		for(Character ch : p.toCharArray())
			arr[ch]++;

		int left = 0, right = 0, count = p.length();

		//two points, initialize count to p's length
		while(right < str.length())
		{
			//move right everytime, if the character exists in p's hash, decrease the count
            //current arr value >= 1 means the character is existing in p
			if(arr[str.charAt(right++)]-- >= 1)
				count--;
            //System.out.println(Arrays.toString(arr));
            //when the count is down to 0, means we found the right anagram
           //then add window's left to result list
			if(count == 0)
				list.add(left);
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the arr, cuz it won't go below 0
			if(right - left == p.length() && arr[str.charAt(left++)]++ >= 0)
				count++;
		}

		return list;

	}
	public static void main(String[] args) 
	{
	    String str = "cbaebabacd"; 
		String p = "abc";
		System.out.println(allAnagrams_util(str, p)); 
	}
}