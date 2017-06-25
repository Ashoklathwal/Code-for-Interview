/*
/*
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring 
that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) 
if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.
Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"

Time Complexity: we’re doing a linear iteration of both str and arr of lengths N and M respectively, 
                so the runtime complexity is linear in the size of the input, i.e. O(N+M).

Space Complexity: we’re using a Map/Hash Table countMap with M key/values pairs plus few 
                  constant size counters, which together give us an O(M) space complexity (linear in the size of arr).
*/

*/

import java.util.HashMap;
class smallestSubStringOfAllChar
{
	public static String smallestSubStringOfAllChar_util(char[] arr, String str)
	{
		HashMap<Character, Integer> hm = new HashMap<>();
        int uniquecount = 0;
        int headIndex = 0;
        for(int i=0;i<arr.length;i++)
        	hm.put(arr[i], 0);
        for(int tailIndex=0;tailIndex<str.length();tailIndex++)
        {
        	if(!hm.containsKey(str.charAt(tailIndex)))
        		continue;

        	if(hm.get(str.charAt(tailIndex)) == 0)
        	{
        		hm.put(str.charAt(tailIndex), 1);
        		uniquecount++;
        	}
        	else
        	{
        		hm.put(str.charAt(tailIndex), hm.get(str.charAt(tailIndex))+1);
                
        	}
        	while(uniquecount == arr.length)
        	{
        		int templength = tailIndex - headIndex + 1;
        		if(templength == arr.length)
        			return str.substring(headIndex, tailIndex+1);

        		char headchar = str.charAt(headIndex);
        		if(hm.containsKey(headchar))
        		{
        			int headcount = hm.get(headchar) - 1;
        			if(headcount == 0)
        				uniquecount--;
        			hm.put(headchar, headcount);
        		}
        		headIndex++;
        	}
        }
        return "";

	}
	public static void main(String[] args)
	{
		char[] arr = {'x','y','z'};
		String str = "xyzyzyxzy";
		System.out.println(" smallest substring of str containing all the characters in arr : "+smallestSubStringOfAllChar_util(arr, str));
		
	}
}
