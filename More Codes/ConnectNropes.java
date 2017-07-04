import java.util.*;
class ConnectNropes
{
	public static int connectNropes_util(int[] arr)
	{
		if(arr.length == 1)
			return arr[0];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++)
             pq.add(arr[i]);
		int sum = 0;
		while(pq.size() > 1)
		{
			int min1 = pq.remove();
			int min2 = pq.remove();
            sum += (min1 + min2);

            pq.add(min1 + min2);
		}
		return sum;
	}
	public static void main(String[] args) 
	{
		int[] arr = {4, 3, 2, 6};
		System.out.println("Min. cost to connecting the ropes : "+connectNropes_util(arr));
		
	}
}