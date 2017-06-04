import java.util.*;

 
class btView {

	Node root;
    public static int curr_level_for_left = 0;
    public static int curr_level_for_right = 0;

   /*
    Tra­verse the tree from left to right
    Print the first node you encounter
    Take two vari­ables , currentLevel=0 and Level=1
    As soon as you change level , change the cur­rentLevel = nextLevel
    Print only when cur­rent level<nextLevel so this way you will print only the first element
    For rest of the nodes on the the level cur­rentLevel and nextLevel are equal so it wont print
   */
    void leftView_recursive(Node root, int level)
    {
    	if(root == null)
    		return;
        // print only first node of every level
        if(curr_level_for_left < level)
        {
        	System.out.print(root.data+" ");
        	curr_level_for_left = level;
        }

        leftView_recursive(root.left, level+1);
        leftView_recursive(root.right, level+1);
    }	
    
    void leftView_iterative(Node root)
    {
    	if(root == null)
    		return;
    	LinkedList<Node> que = new LinkedList<>();
    	que.add(root);
        
        while(!que.isEmpty())
        {
        	int size = que.size();
        	for(int i=0; i<size; i++)
        	{
        		Node temp = que.remove();
        		// print only first node of que(right most node of tree)
        		if(i == 0)
        			System.out.print(temp.data+" ");
        		// first check left
        		if(temp.left != null)
        			que.add(temp.left);
        		if(temp.right != null)
        			que.add(temp.right);
        	}

        }
    	
    }
    /*
    Tra­verse the tree from right to left
    Print the first node you encounter
    Take two vari­ables , currentLevel=0 and nextLevel=1
    As soon as you change level , change the cur­rentLevel = nextLevel
    Print only when cur­rent level<nextLevel so this way you will print only the first element
    For rest of the nodes on the the level cur­rentLevel and nextLevel are equal so it wont print
    */

    void rightView_recursive(Node root, int level)
    {
    	if(root == null)
    		return;
        // print only first node of every level
        if(curr_level_for_right < level)
        {
        	System.out.print(root.data+" ");
        	curr_level_for_right = level;
        }

        rightView_recursive(root.right, level+1);
        rightView_recursive(root.left, level+1);
    }
    void rightView_iterative(Node root)
    {
    	if(root == null)
    		return;
    	LinkedList<Node> que = new LinkedList<>();
    	que.add(root);
        
        while(!que.isEmpty())
        {
        	int size = que.size();
        	for(int i=0; i<size; i++)
        	{
        		Node temp = que.remove();
        		// print only first node of que(right most node of tree)
        		if(i == 0)
        			System.out.print(temp.data+" ");
        		// first check right
        		if(temp.right != null)
        			que.add(temp.right);
        		if(temp.left != null)
        			que.add(temp.left);
        	}

        }
    	
    }

    /*  For each node, its left child's degree is -1 and is right child's degree is +1.
         We can do a level order traversal and save the degree information.
         using TreeMap don't need to maintain min max becuse in TreeMap key will be in sorted order. 
	*/
   public List<List<Integer>> verticalOrder(Node root)
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null)
    		return result;
    	// level and list
    	HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        que.add(root);
        level.add(0);
        
        int minLevel = 0;
        int maxLevel = 0;
        while(!que.isEmpty())
        {
        	Node temp = que.remove();
        	int distance = level.remove();

        	minLevel = Math.min(minLevel, distance);
        	maxLevel = Math.max(maxLevel, distance);

        	if(hm.get(distance) == null)
        	{
        		hm.put(distance, new ArrayList<Integer>());
        	}
        	hm.get(distance).add(temp.data);

        	if(temp.left != null)
        	{
        		que.add(temp.left);
        		level.add(distance-1);
        	}
        	if(temp.right != null)
        	{
        		que.add(temp.right);
        		level.add(distance+1);
        	}
        }

        for(int i=minLevel; i<=maxLevel; i++)
        {
        	if(hm.containsKey(i))
        	{
        		result.add(hm.get(i));
        	}
        }


        return result;

    }     

    public void topView(Node root)
    {
    	if(root == null)
    		return ;
    	// level and list
    	HashMap<Integer, Integer> hm = new HashMap<>();
        
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        que.add(root);
        level.add(0);
        
        int minLevel = 0;
        int maxLevel = 0;
        while(!que.isEmpty())
        {
        	Node temp = que.remove();
        	int distance = level.remove();

        	minLevel = Math.min(minLevel, distance);
        	maxLevel = Math.max(maxLevel, distance);

        	if(hm.get(distance) == null)
        	{
        		hm.put(distance, temp.data);
        	}

        	if(temp.left != null)
        	{
        		que.add(temp.left);
        		level.add(distance-1);
        	}
        	if(temp.right != null)
        	{
        		que.add(temp.right);
        		level.add(distance+1);
        	}
        }

        for(int i=minLevel; i<=maxLevel; i++)
        {
        	if(hm.containsKey(i))
        		System.out.print(hm.get(i)+" ");
        }


    }

    public List<List<Integer>> bottomView(Node root)
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null)
    		return result;
    	// level and list
    	HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        
        LinkedList<Node> que = new LinkedList<>();
        LinkedList<Integer> level = new LinkedList<>();

        que.add(root);
        level.add(0);
        
        int minLevel = 0;
        int maxLevel = 0;
        while(!que.isEmpty())
        {
        	Node temp = que.remove();
        	int distance = level.remove();

        	minLevel = Math.min(minLevel, distance);
        	maxLevel = Math.max(maxLevel, distance);

        	if(hm.get(distance) == null)
        	{
        		hm.put(distance, new ArrayList<Integer>());
        	}
        	hm.get(distance).add(temp.data);

        	if(temp.left != null)
        	{
        		que.add(temp.left);
        		level.add(distance-1);
        	}
        	if(temp.right != null)
        	{
        		que.add(temp.right);
        		level.add(distance+1);
        	}
        }

        for(List<Integer> list : hm.values())
        {
        	if(list.size() > 1)
        		list.remove(0);
        }

        for(int i=minLevel; i<=maxLevel; i++)
        {
        	for(int j=0; j< hm.get(i).size(); j++)
        	{
        		System.out.print(hm.get(i).get(j)+" ");
        	}
        	System.out.println();
        }
        for(int i=minLevel; i<=maxLevel; i++)
        {
        	if(hm.containsKey(i))
        	{
        		result.add(hm.get(i));
        	}
        }

        

        return result;
        
    }

	// Driver program to test the above functions
	public static void main(String args[]) {
		btView tree = new btView();
        /*
                                       1
                                    /    \
                                   2      3
                                  / \    / \
                                 4   5  6   7
                                         \   \
                                          8   9 

        */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		System.out.println("*****Left view of binary tree************* :");
		tree.leftView_recursive(tree.root, 1);
		//tree.leftView_iterative(tree.root);
		System.out.println();
		System.out.println("*****Right view of binary tree************* :");
		tree.rightView_recursive(tree.root, 1);
	    //tree.rightView_iterative(tree.root);
	    System.out.println();
	    System.out.println("*****Vertical path of binary tree from left to right************* :");
        System.out.println(tree.verticalOrder(tree.root));
        System.out.println();
        System.out.println("*****Top view of binary tree************* :");
        tree.topView(tree.root);
        System.out.println();
        System.out.println("*****Bottom view of binary tree************* :");
        System.out.print(tree.bottomView(tree.root));
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
