import java.util.*;
class nextGreaterElement
{
	public static void NGE(int[] arr)
	{
		int n = arr.length;
		Stack<Integer> stk = new Stack<>();
		stk.push(arr[0]);
		int element ;
		int next;
		for(int i=1;i<n;i++)
		{
			next = arr[i];
			if(!stk.isEmpty())
			{
				element = stk.pop();
				while(element < next)
				{
					System.out.println(element+"     "+next);
					if(stk.isEmpty())
						break;
					element = stk.pop();
				}
			
			        if(elemnt >= next)
			        {
				       stk.push(element);
		       	        }
			}	
			stk.push(next);
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
