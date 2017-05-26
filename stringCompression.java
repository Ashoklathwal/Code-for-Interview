class stringCompression
{
	/* Problem Description:
    Compress a given string "aabbbccc" to "a2b3c3"
   constraint: in-place compression, no extra space to be used
   assumption : output size will not exceed input size..
   ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.*/
	public static void main(String args[])
	{
		String str = "aaabbccc";
		StringBuffer sb=new StringBuffer();
		int count = 1;
		int i = 0;
		// count continious occurance of eaach character
		for(i = 0; i < str.length() - 1; i++)
		{
			if(str.charAt(i) == str.charAt(i+1))
			{
				count += 1;
			}
			else
			{
                                sb.append(str.charAt(i)).append(count);
				count = 1;
			}
		}

		// for last character
		if(str.charAt(str.length()-2) == str.charAt(str.length()-1))
                        sb.append(str.charAt(i)).append(count);
		else
			sb.append(str.charAt(i)).append(count);

		System.out.println(sb);
	}
}
