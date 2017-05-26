class ReplaceSpace 
{
	public static void main(String[] args) 
	{
		String temp = " a b ";
		String outString = replaceSpa(temp);
		System.out.println(outString);
	}
	public static String replaceSpa(String str)
	{
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) 
		{
			if (str.charAt(i) == ' ') 
			{
				strBuffer.append("%20");
			}else
			{
				strBuffer.append(str.charAt(i));
			}
		}
		return strBuffer.toString();
	}
}

/*
EXAMPLE
Input: "Mr John Smith JJ   ", 13
Output: "Mr%2eJohn%2eSmith"

 Another approch
We will use this approach in this problem. The algorithm employs a two-scan approach. In the first scan, we
count the number of spaces. By tripling this number, we can compute how many extra characters we will
have in the final string. In the second pass, which is done in reverse order, we actually edit the string. When
we see a space, we replace it with %20. If there is no space, then we copy the original character.

void Rep_Str(char *str)
{
    int j=0,count=0;
    int stlen = strlen(str);
    for (j = 0; j < stlen; j++)
    {
        if (str[j]==' ')
        {
            count++;
        }
    }

    int newlength = stlen+(count*2);
    str[newlength--]='\0';
    for (j = stlen-1; j >=0 ; j--)
    {
        if (str[j]==' ')
        {
            str[newlength--]='0';
            str[newlength--]='2';
            str[newlength--]='%';
        }

        else
        {

            str[newlength--]=str[j];
        }

    }


}

*/