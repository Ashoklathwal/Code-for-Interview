import java.util.*;
class MergeKSortedArrays
{
	static class pair implements Comparable<pair>
	{
		int value;
		int index;
		@Override
		public int compareTo(pair obj)
		{
		   return this.value - obj.value;
		}
	}
	public static void mergeKSortedArrays_util(LinkedHashMap<Integer, ArrayList<Integer>> hm, int n, int k)
	{
        // Create a min heap with k heap nodes.  Every heap node has first element of an array
		PriorityQueue<pair> minheap = new PriorityQueue<>();
		for(int i=0; i<k; i++) 
		{
            if(hm.get(i).size() == 0) 
            {
            	pair pr = new pair();
            	pr.value = Integer.MAX_VALUE;
            	pr.index = -1;
            	minheap.add(pr);
            }
            else
            {
            	pair pr = new pair();
            	pr.value = hm.get(i).remove(0);
            	pr.index = i;
            	minheap.add(pr);	
            }     	
        }


        ArrayList<Integer> output = new ArrayList<>();
         // Now one by one get the minimum element from min heap and replace it with next element of its array
        while(output.size() != n*k)
        {
            pair temp = minheap.remove();
            output.add(temp.value);
            if(hm.get(temp.index).size() != 0) 
            {
            	pair pr = new pair();
            	pr.value = hm.get(temp.index).remove(0);
            	pr.index = temp.index;
            	minheap.add(pr);
            }
           /* pair pr = new pair();
            pr.value = hm.get(i).remove(0);
            pr.index = i;
            minheap.add(pr);
            p.add(new PQNode(Integer.MAX_VALUE, -1));
            */
        }

        for(Integer ele : output)
        	System.out.print(ele+" ");

	}
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), n = sc.nextInt();
        LinkedHashMap<Integer, ArrayList<Integer>> hm = new LinkedHashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i < k; i++) 
        {
            hm.put(i,new ArrayList<Integer>());
            for(int j=0; j < n; j++) 
            {
                hm.get(i).add(sc.nextInt());
            }
        }
	   //MergeKSortedArrays me = MergeKSortedArrays();
	   mergeKSortedArrays_util(hm, n, k);
       
	}
}