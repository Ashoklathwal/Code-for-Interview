

/*
   Given a string, remove all spaces from the string and return it.
1) Initialize 'count' = 0 (Count of non-space character seen so far)
2) Iterate through all characters of given string, do following
     a) If current character is non-space, then put this character
        at index 'count' and increment 'count'
3) Finally, put '\0' at index 'count'*/

class removeSpace
{
	static void remove(char[] arr, int n)
	{
		int count = 0;
		//int n = arr.length;
		for(int i=0;i<n;i++)
		{
			if(arr[i] != ' ')
				arr[count++] = arr[i];
		}
		arr[count] = '\0';
		System.out.println(new String(arr,0,count));
	}
	public static void main(String[] args)
	{
		char[] arr = "  My Name is Ashok ".toCharArray();
		int length = arr.length;
		System.out.println(Arrays.toString(arr));
        remove(arr, length);
        
	}
}