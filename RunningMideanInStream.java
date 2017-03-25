/*
The solution is using two heaps or two priority queues, one max the other min, and always balanced. By balanced, it means 
the difference of the length of each data structure should be less than or equal to 1. And the min data structure should
 store the highest half of the sorted list and the max structure needs to store the lowest of the sorted list. In this way 
 the insersion will take place in O(logn) and finding the median in O(1) as access time to top element of heap or priority queue is O(1).
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double median=0.0;
        PriorityQueue<Double> minheap=new PriorityQueue<>();
        /*
        Comparator<Double> maxHeapComparator=new Comparator<Double>() {

			@Override
			public int compare(Double x, Double y) {
				// TODO Auto-generated method stub
				if(y>x)
					return 1;
				else if(y<x)
					return -1;
				else return 0;
			}
		};
        */
        PriorityQueue<Double> maxheap=new PriorityQueue<>(20,Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            double num=sc.nextDouble();
            if(num > median)
                minheap.add(num);
            else
                maxheap.add(num);
            int minsize=minheap.size();
            int maxsize=maxheap.size();
            if(Math.abs(minsize-maxsize) > 1)
            {
                boolean a=(minsize>maxsize) ? maxheap.add(minheap.remove()) : minheap.add(maxheap.remove()) ;
            }
            minsize=minheap.size();
            maxsize=maxheap.size();
            if(minsize == maxsize)
                median = (minheap.peek() + maxheap.peek())/2;
            else if(Math.abs(minsize-maxsize) == 1)
                median = (minsize > maxsize) ? minheap.peek() : maxheap.peek() ;
            System.out.println(median);
        }
    }
}
