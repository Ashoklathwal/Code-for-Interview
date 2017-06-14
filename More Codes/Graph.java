import java.util.*;
class Graph
{
	int vertices;
	Map<Integer, List<Integer>> adjList;
	int[] indegree;

	Graph(int v)
	{
		this.vertices = v;
		this.adjList = new HashMap<>();
		this.indegree = new int[vertices];
		for(int i=0;i<v;i++)
		{
			adjList.put(i, new LinkedList<Integer>());
		}
	}
    
    public void bfs(int start)
    {
    	Queue<Integer> que = new LinkedList<>();
    	boolean[] visited = new boolean[vertices];
    	//int[] parent = new int[vertices]; // for finding the shortest path
    	//Arrays.fill(parent, -1);
    	que.add(start);
    	visited[start] = true;

    	while(!que.isEmpty())
    	{
    		int ele = que.remove();
    		System.out.print(ele+" ");

    		List<Integer> neighbours = adjList.get(ele);

    		for(Integer neighbour : neighbours)
    		{
    			if(!visited[neighbour])
    			{
    				que.add(neighbour);
    				visited[neighbour] = true;
    			//	parent[neighbour] = ele; 
    			}
    		//	else
    		//		return true; // checking for cycle (true means cycle exist)
    		}
    	}
    	//return false  // checking for cycle (true means cycle does not exist)
    }
    /*
      for printing the shortest path from 'start' to 'end'

      int curr_vertex = end;
      Stack<Integer> stk = new Stack<>();
      while(parent[curr_vertex] != -1)
      {
      	stk.push(curr_vertex);
      	curr_vertex = parent[curr_vertex];
      }
      stk.push(start);
      now pop() item from the stack and print them


    */

    public void dfs_util(int start, boolean[] visited)
    {
    	//Queue<Integer> que = new LinkedList<>();
    	//que.add(start);
    	visited[start] = true;
    	System.out.print(start+" ");

    	List<Integer> neighbours = adjList.get(start);

    		for(Integer neighbour : neighbours)
    		{
    			if(!visited[neighbour])
    			{
    				dfs_util(neighbour, visited);
    			}
    		}
    }
    public void dfs(int start)
    {
    	boolean[] visited = new boolean[vertices];
    	dfs_util(start, visited);
    }

    public void topologicalSort_util(int start, boolean[] visited, Stack<Integer> stk)
    {
    	//Queue<Integer> que = new LinkedList<>();
    	//que.add(start);
    	visited[start] = true;
    	//System.out.print(start+" ");

    	List<Integer> neighbours = adjList.get(start);

    		for(Integer neighbour : neighbours)
    		{
    			if(!visited[neighbour])
    			{
    				topologicalSort_util(neighbour, visited, stk);
    			}
    		}
        stk.push(start); 
    }
    public void topologicalSort()
    {
    	boolean[] visited = new boolean[vertices];
    	Stack<Integer> stk = new Stack<>();
        for(int i=0;i<vertices;i++)
        {
        	if(!visited[i])
        	topologicalSort_util(i, visited, stk);
        }

        while(!stk.isEmpty())
        {
        	System.out.print(stk.pop()+" ");
        }
    	
    }
    
    public void alltopologicalSort_util(boolean[] visited, LinkedList<Integer> result)
    {
    	boolean flag = false;
    	for(int i=0; i< vertices; i++)
    	{
    		if(indegree[i] == 0 && !visited[i])
    		{
    			visited[i] = true;
    			// remove the edge
    			List<Integer> neighbours = adjList.get(i);
    			for(Integer neighbour : neighbours)
    				indegree[neighbour]--;
    			result.add(i);

    			alltopologicalSort_util(visited, result);

    			visited[i] = false;

    			result.removeLast();

    		    neighbours = adjList.get(i);
    			for(Integer neighbour : neighbours)
    				indegree[neighbour]++;
    			
    			flag = true;
    		}
    	}

    	if(!flag)
    	{
    		ListIterator<Integer> it = result.listIterator();
    		while(it.hasNext())
    			System.out.print(it.next()+" ");
    		System.out.println();
    	}
    }
    public void alltopologicalSort()
    {
    	LinkedList<Integer> result = new LinkedList<>();
    	boolean[] visited = new boolean[vertices];
        alltopologicalSort_util(visited, result);
    }

    public void findConnectedComponent()
    {
    	int count = 0; // count connected component
    	boolean[] visited = new boolean[vertices];
    	for(int i=0;i<vertices;i++)
    	{
    		if(!visited[i])
    			count++;
    		bfs(i, visited);
    	}
    	System.out.print(count);

    }
    void bfs(int i, boolean[] visited)
    {}

	public void addEdge(int u, int v)
	{
		adjList.get(u).add(v);
		indegree[v]++;
	}
	public static void main(String[] args) 
	{
		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.bfs(2);
        System.out.println();
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.dfs(2);
        System.out.println();
        System.out.println("Following is a Topological sort of the given graph");
        g.topologicalSort();
        System.out.println();
        System.out.println("Following are all Topological sort of the given graph");
        g.alltopologicalSort();

        g.findConnectedComponent();

	}
}