class longestPalindromicSubString2
{
	public static void longestPalindromicSubString2_util(char[] input, int n)
	{
		// preprocess the input to convert abcd ----> $a$b$c$d$ to handle even length string
		int index = 0;
		char[] newInput = new char[2*n+1];
		for(int i=0; i<newInput.length; i++)
		{
			if(i % 2 == 0)
				newInput[i] = '$';
			else
				newInput[i] = input[index++];
        }

		//create temp array for holding largest palindrome at every point.There are 2*n + 1 such points.	
		int[] temp = new int[newInput.length];
		int  start = 0;
		int end = 0;

		// here i is center
		for(int i=0; i<newInput.length; )
		{
			// expand around i and see how far we can go
			while(start > 0 && (end < newInput.length -1) && newInput[start-1] == newInput[end+1])
			{
				start--;
				end++;
			}
			// set the longest value of palindrome around center i at temp[i]
			temp[i] = end - start + 1;

			// case 2: if current palindrome is proper suffix of input terminate
			if(end == temp.length - 1)
				break;
            
            // mark newCenter to be either end or end + 1 according to odd or even input number
            int newCenter = end + (i % 2 == 0 ? 1 : 0);

            for(int j = i+1; j<=end; j++)
            {
            	//i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
                temp[j] = Math.min(temp[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
                if(j + temp[i - (j - i)]/2 == end) 
                {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
            i = newCenter;
            end = i + temp[i]/2;
            start = i - temp[i]/2;
            
		}
        
        // print length of longest Palindromic SubString        
        int max = Integer.MIN_VALUE;
        int tempIndex = 0;
        for(int i = 0; i<temp.length; i++)
        {
        	int val = temp[i]/2;
        	if(max < val)
        	{
        	   max = val; 
        	   tempIndex = i/2;
        	}
        }
        System.out.print("length of longest Palindromic SubString : "+max);
		
		// print  longest Palindromic SubString
		System.out.println();
		System.out.print("longest Palindromic SubString : ");
        if(max % 2 != 0)
        {
        	for(int i=tempIndex-max/2; i<=tempIndex+max/2;i++)
        		System.out.print(input[i]);
        }
        else
        {
           for(int i=tempIndex-max/2; i<=tempIndex+max/2-1;i++)
        		System.out.print(input[i]);
        }

    } 
	public static void main(String[] args) 
	{
		System.out.println("********1st Input*******************");
		char[] arr = "babcbaabcbaccba".toCharArray();
		int n = arr.length;
		longestPalindromicSubString2_util(arr, n) ;
		System.out.println();
		System.out.println("********2nd Input*******************");
		arr = "cdbabcbabdab".toCharArray();
		n = arr.length;
		longestPalindromicSubString2_util(arr, n) ;
	}
}