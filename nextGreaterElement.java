import java.util.*;
class nextGreaterElement
{
	public static void NGE(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> stk = new Stack<>();
		stk.push(arr[0]);
		for(int i=1;i<n;i++)
		{
			int x = 0;
			if(!stk.isEmpty())
			{
				x = stk.pop();
				if(x < arr[i])
				{
					System.out.println(x+"     "+arr[i]);
				}
			}
			if(x >= arr[i])
			{
				stk.push(x);
			}
			stk.push(arr[i]);
		}
		while(!stk.isEmpty())
		{
			System.out.println(stk.pop()+"     "+-1);
		}
     
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int arr[] = {11,23,3,21};
		NGE(arr);
	}

}
