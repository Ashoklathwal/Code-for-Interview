import java.util.PriorityQueue;
import java.util.Scanner;
class kthLargestInStream
{
	public static void kthLargestInStream_util(int k)
	{
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.print("enter number :");
            int num = sc.nextInt();
            if(!minheap.isEmpty() && num > minheap.peek() && minheap.size() == k)
            {
            	minheap.remove();
            	minheap.add(num);
            }
            if(minheap.size() < k)
            	minheap.add(num);
            if(minheap.size() == k)
            	System.out.println("K^th largest element : "+minheap.peek());
            
		}
	}
	public static void main(String[] args) 
	{
		int k = 3;
		kthLargestInStream_util(k);
	}
}