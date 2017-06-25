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