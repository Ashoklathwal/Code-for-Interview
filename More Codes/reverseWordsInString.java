/*
* We first split the string to words array, and then iterate through the array and 
* add each element to a new string. Note: StringBuilder should be used to avoid creating
* too many Strings. If the string is very long, using String is not scalable since String 
* is immutable and too many objects will be created and garbage collected.
*/

class reverseWordsInString
{
	static String reverseWords(String str)
	{
		if(str.length() == 0)
			return "";
		String[] arr = str.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length-1; i>= 0; i--)
		{
			if(!arr[i].equals(""))
				sb.append(arr[i]).append(" ");
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	public static void main(String[] args)
	{
		String str = "My name is Ashok";
		System.out.println(reverseWords(str) + "   length"+ str.length());
	}
}


/*
// Using recursion when there is no starting and trailing space and in between only one space
public void reverseWords(char[] s) {
    int i=0;
    for(int j=0; j<s.length; j++){
        if(s[j]==' '){
            reverse(s, i, j-1);        
            i=j+1;
        }
    }
 
    reverse(s, i, s.length-1);
 
    reverse(s, 0, s.length-1);
}
 
public void reverse(char[] s, int i, int j){
    while(i<j){
        char temp = s[i];
        s[i]=s[j];
        s[j]=temp;
        i++;
        j--;
    }
}

*/