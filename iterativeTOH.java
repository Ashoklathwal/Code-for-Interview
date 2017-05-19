
// move disks from left to right using middle
import java.util.Stack;
import java.util.Scanner;
class iterativeTOH
{
	static void move_disk(int disk, char a, char b)
	{
		System.out.println("move disk "+disk+" from "+a+" to "+b);
	}
	static void mov_disk_between(Stack<Integer> tower_1, Stack<Integer> tower_2, char t_1, char t_2)
	{
		int disk;
		//tower_1 is empty
		if(tower_1.isEmpty())
		{
			disk = tower_2.pop();
			tower_1.push(disk);
			move_disk(disk, t_2, t_1); // move disk t_2 to t_1
			return;
		}
		// tower_2 is empty
		if(tower_2.isEmpty())
		{
			disk = tower_1.pop();
			tower_2.push(disk);
			move_disk(disk, t_1, t_2);
			return;
		}
		// none of disk is empty
		if(tower_1.peek() < tower_2.peek())
		{
			disk = tower_1.pop();
			tower_2.push(disk);
			move_disk(disk, t_1, t_2);
		}
		else
		{
			disk = tower_2.pop();
			tower_1.push(disk);
			move_disk(disk, t_2, t_1);
		}
	}
	static void iter_TOH(int num_of_disk, int total_moves, Stack<Integer> left, Stack<Integer> middle, Stack<Integer> right)
	{
	   char l = 'L', m = 'M', r = 'R'; // L-left tower, R-right tower, M-middle tower
	   // if num_disks are even interchange them
	   for(int i=num_of_disk;i>=1;i--)
	   {
	   	left.push(i);
	   }
	   if(num_of_disk % 2 == 0)
	   {
	   	char temp = m;
	   	     m = r;
             r = temp;
	   }
	   for(int i=1; i<=total_moves;i++)
	   {
	   	if(i % 3 == 0)
	   		mov_disk_between(middle, right, m, r);
	   	else if(i % 3 == 1)
	   		mov_disk_between(left, right, l, r);
	   	else if(i % 3 == 2)
	   		mov_disk_between(left, middle, l, m);

	   }
	}
	public static void main(String[] args)
	{
		iterativeTOH itr = new iterativeTOH();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of disk");
		int num_of_disk = sc.nextInt();
        int total_moves = (int)Math.pow(2,num_of_disk) - 1;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();
        iter_TOH(num_of_disk, total_moves, left, middle, right);
	}
}