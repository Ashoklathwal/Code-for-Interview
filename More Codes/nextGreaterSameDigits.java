import java.util.Arrays;
class nextGreaterSameDigits
{
	public static void swap(char[] num, int a, int b)
	{
		char temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	public static String sameSetOfDigits(char[] num)
	{
		int i, j;
		int n = num.length;
		for(i=n-1; i>0; i--)
		{
			if(num[i] > num[i-1]) 
				break;
		}

		if(i == 0)
		{
			System.out.println("Not Possible");
            return "";
		}

		int smallest = num[i-1], nextIndex = i;

		for(j=i+1; j<n; j++)
		{
			if(num[j] > smallest && num[j] < num[nextIndex])
				nextIndex = j;
		}
		System.out.println(Arrays.toString(num));
		swap(num, i-1, nextIndex);

		System.out.println(Arrays.toString(num));
		Arrays.sort(num, i, nextIndex+1);

		return new String(num);
	}
	public static void main(String[] args) 
	{
		int number = 534976;
		char[] num = Integer.toString(number).toCharArray();
		System.out.println("Next greater number with same set of digits : "+sameSetOfDigits(num));
	}
}