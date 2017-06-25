/*
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring 
that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) 
if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.
Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
*/

import java.util.*;

class ResarrangeString
{
   class pair implements Comparable<pair>
	{
		char ch;
		int count;
		@Override
		public int compareTo(pair obj)
		{
		   return obj.count - this.count;
		}
	}

	public void resarrangeString_util(String str)
	{
		PriorityQueue<pair> maxheap = new PriorityQueue<>();
		int[] arr = new int[26];
		for(char ch : str.toCharArray())
		     arr[ch-'a']++;

		for(int i=0;i<26;i++)
		{
			if(arr[i] != 0)
			{
				pair pr = new pair();
				pr.ch = (char)(i+'a');
				pr.count = arr[i];
				maxheap.add(pr);
			}
		}
        pair prev = null;
        StringBuffer sb= new StringBuffer(); 
		while(!maxheap.isEmpty())
		{
			pair curr = maxheap.poll();
			if(curr.count == 0)
				break;
			curr.count--;
			sb.append(curr.ch);

			if(prev != null)
				maxheap.add(prev);
			prev = curr;
		}
		if(sb.length() == str.length())
		{
			System.out.println("valid String : "+sb.toString());
		} 
		else
		{
			System.out.println("Invalid String");
	    }
		      
	}
	public static void main(String[] args) 
	{
		String str = "aaabc";
		ResarrangeString re = new ResarrangeString();
		re.resarrangeString_util(str);
		
	}
		
}
