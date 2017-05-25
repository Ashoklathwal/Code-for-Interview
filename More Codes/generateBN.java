/*

Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.

1) Create an empty queue of strings
2) Enqueue the first binary number “1” to queue.
3) Now run a loop for generating and printing n binary numbers.
……a) Dequeue and store in "front" and Print the "front".
……b) Append “0” at the end of "front" and enqueue it in queue.
……c) Append “1” at the end of "front" item and enqueue it in queue.

*/

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
class generateBN
{
	static void gbn(int n)
	{
		Queue<String> que = new LinkedList<>();
		que.offer("1");
		while(n-- > 0)
		{
			String front = que.remove();
			System.out.print(front+" ");
			que.offer(front+"0");
			que.offer(front+"1");
		}
	}
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter decimal number :");
		int n = sc.nextInt();
		System.out.println("Binary numbers are from 1 to "+ n+ " are :");
		gbn(n);	
	}
}