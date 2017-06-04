import java.util.*;
class binary_tree
{

	/**
 * Algorithms on binary trees:
 * +----------------------------------+--------------------------------------------------------------+
 * |	Method Name		              |					Description						             |
 * +----------------------------------+--------------------------------------------------------------+
 * | find 				              | given a node value, finds the node in tree using dfs         |
 * | printPreOrder 		              | Pre-order traversal								             |
 * | printInOrder		              | In-order traversal								             |
 * | printPostOrder		              | post-order traversal								         |
 * | isBST				              | checks if tree is a BST							             |
 * | getHeight			              |  gets the height of the BST		                             |
 * | getLevel				          |  gets the height of the BT                                   |
 * | isTreeBalanced		              | checks if the tree is height balanced				         |
 * | getLCA				              | determines the Lowest Common Ancestor of two nodes           |
 * | print_level_wise	              | prints the tree level wise using BFS	    		         |
 * | print_level_average              | prints the average value for each level in tree	             |
 * | getInOrderSuccessorPredeccessor  | determines the in-order successor and predeccessor for a node|
 * | k^th laregst elemnt              | get k^th largest elelment from BT                            |
 * | getDiameter                      | get diameter of BT                                           |
 * +-------------------+------------------------------------------------------------------------------+
 */

	Node root;
	public binary_tree(Node root)
	{
		this.root = root;
	}
	static int successor, predecessor;
	static int count;
 
    /*
	   Retrieves the first node found in the tree for the given value using DFS
	   @param value	the node value
	   @return		a node possessing the value, null if not present in tree
	*/
    public Node find(Node particular_node, int value)
    {
    	// basecase : not found
    	if(particular_node == null)
    		return null;
    	int current = particular_node.value;
    	if(current == value)
    		return particular_node;
    	// check if found in left subtree
        Node leftAns = find(particular_node.left, value);
    	if(leftAns != null)
    		return leftAns;
    	// check if found in right subtree
        Node rightAns = find(particular_node.right, value);
    	if(rightAns != null)
    		return rightAns;

    	return null; // if value is not present in the tree 

    }
	public Node find(int value)
	{
		return find(root, value);
	}

    // Print tree in pre-order traversal 
    public void printPreOrder(Node node)
    {
    	System.out.print(node+ " ");
    	if(node.left != null)
    		printPreOrder(node.left);
    	if(node.right != null)
    		printPreOrder(node.right);
    }
    public void printPreOrder()
    {
    	printPreOrder(root);
    }


    // Print tree in in-order traversal 
    public void printInOrder(Node node)
    {
    	if(node.left != null)
    		printInOrder(node.left);
    	System.out.print(node+ " ");
    	if(node.right != null)
    		printInOrder(node.right);
    }
    public void printInOrder()
    {
    	printInOrder(root);
    }


    // Print tree in post-order traversal 
    public void printPostOrder(Node node)
    {
    	if(node.left != null)
    		printPostOrder(node.left);
    	if(node.right != null)
    		printPostOrder(node.right);
    	System.out.print(node+ " ");
    }
    public void printPostOrder()
    {
    	printPostOrder(root);
    }


    /*
	   Determines if tree is a BST
	   @param subtree	root node of subtree
	   @param min		min value for range
	   @param max		max value of range
	   @return			true if subtree is a BST, false otherwise
	*/
	public boolean isBST(Node subtree, int min, int max)
	{
		// base case : BST is empty 
		if(subtree == null)
			return true;
		int val = subtree.value;
		// if value is within range or not
		if(val > min && val < max)
		{
			return (isBST(subtree.left, min, val) && isBST(subtree.right, val, max));
		}
		else
		{
			return false;
		}
	}   
    public boolean isBST()
    {
    	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    /*
	   Determines the height of the subtree
	   @param subtree	root node of subtree
	   @return			height of subtree
	*/
	public int getHeight(Node subtree)
	{
		// base case : empty tree
		if(subtree == null)
			return 0;
		if(subtree.left == null && subtree.right == null)
			return 0;
		return (Math.max(getHeight(subtree.left),getHeight(subtree.right)) + 1);
	}

	/*
	   Determines the level of the subtree
	   @param subtree	root node of subtree
	   @return			level of subtree
	*/
	public int getLevel(Node subtree)
	{
		// base case : empty tree
		if(subtree == null)
			return 0;
		if(subtree.left == null && subtree.right == null)
			return 1;
		return (Math.max(getLevel(subtree.left),getLevel(subtree.right)) + 1);
	}
    

    /*
	   Checks if tree is a balanced tree. A tree is balanced if its subtrees do
	   not differ more than 1 level in height
	   @return true if tree is balanced, false otherwise
	*/

    public boolean isTreeBalanced()
    {
    	int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
    	return (diff < 2);
    }
    

    /*
	   Returns the Lowest Common Ancestor (LCA) of node with xValue and node
	   with yValue
	   @param node		the root node for current subtree being searched
	   @param xValue	value of the first child node
	   @param yValue	value of the second child node
	   @return			the LCA or node with xValue or node with yValue or null
	 					if nothing found
	*/
	/*
	The idea is to traverse the tree starting from root. If any of the given keys (n1 and n2) matches with root, 
	then root is LCA (assuming that both keys are present). If root doesn’t match with any of the keys, we recur 
	for left and right subtree. The node which has one key present in its left subtree and the other key present 
	in right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA 
	lies in right subtree. 			
	*/	
	/*
	LCA of BST
	static Node lca(Node root,int v1,int v2)
    {
        if(root.data<v1 && root.data<v2)
            return lca(root.right,v1,v2);
      else if(root.data>v1 && root.data>v2)
            return lca(root.left,v1,v2); 
          else return root;
    }
    */	
    public Node getLCA(Node node, int xValue, int yValue){
		
		Node leftAns = null;
		if (node.left != null) {
			leftAns = getLCA(node.left, xValue, yValue);
		}
		Node rightAns = null;
		if (node.right != null) {
			rightAns = getLCA(node.right, xValue, yValue);
		}
		
		/* MUST BE CHECKED FIRST: else if both leftAns and rightAns are defined,
		 * current node is LCA */
		if (leftAns != null && rightAns != null)
		 {
			return node;
		}
		
		/* if current node is either x or y*/
		if (node.value == xValue || node.value == yValue) {
			return node;
		}
		
		/* else if left subtree contains only 1 (could be LCA or X or Y) */
		if (leftAns != null && rightAns == null) {
			return leftAns;
		}
		
		/* else if right subtree contains only 1 (could be LCA or X or Y) */
		if (rightAns != null && leftAns == null) {
			return rightAns;
		}
		
		/* if both returns null -> x and y are not found, hence LCA not found in
		 * current subtree */
		return null;
	}
    public void getLCA(int xValue, int yValue)
    {
    	Node LCAxy = getLCA(root, xValue, yValue);
    	if(LCAxy == null)
    		System.out.println("Both X and Y not found in tree");
    	else
    	{
    		if(LCAxy.value == xValue && xValue != yValue)
    			System.out.println("Y not found in the tree");
    		else if(LCAxy.value == yValue && yValue != xValue)
    			System.out.println("X not found in the tree");
    		else
    			System.out.println("LCA of "+xValue+" and "+yValue+" is "+LCAxy.value);

    	}
    }
    
    // prints binary tree level-wise O(N) time, O(N) space. Q will be at most all the leaves
    public void print_level_wise(Node root)
    {
    	Queue<Node> queue=new LinkedList<>();
        if(root != null)
        {
          queue.add(root);
        }
        while(!queue.isEmpty())
        {
          Node m = queue.remove();
          System.out.print(m.value+" ");
          if(m.left != null)
              queue.add(m.left);
          if(m.right != null)
              queue.add(m.right);
        }
    }
    /*
    // print each level in new line
    Queue q = new LinkedList();
 		int levelNodes =0; 
		if(root==null) return;
 		q.add(root);
 		while(!q.isEmpty()){
 			levelNodes = q.size();
 			while(levelNodes>0){
				Node n = (Node)q.remove();
				System.out.print(" " + n.data);
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelNodes--;
			}
			System.out.println("");
		}
    */    
    public void print_level_wise()
    {
    	 print_level_wise(root);
    } 
    // print the average of each level
    public void print_level_average(Node root)
    {
        Queue<Node> queue=new LinkedList<>();
        int levelNodes = 0;
        if(root != null)
        {
          queue.add(root);
        }
        while(!queue.isEmpty())
        { 
          int sum = 0;  
          levelNodes = queue.size();
          int total = levelNodes;
          while(levelNodes > 0)
           {	
              Node m = queue.remove();
              //System.out.print(m.value+" ");
              sum += m.value;
              if(m.left != null)
              {
                 queue.add(m.left);
              }
              if(m.right != null)
              {
                 queue.add(m.right);
              }
              levelNodes--;
           }
           System.out.print((double) sum/total+" ");
        }
    }
    public void print_level_average()
    {
    	print_level_average(root);
    }
    
    /*
	   Determines the in-order successor and predecessor of a given node
	   @param node	node of interest
	   @return		in-order successor and predecessor of node, null if non existent
	*/
	 /*
	 When you do the inorder tra­ver­sal of a binary tree, the neigh­bors of given node are 
	 called Pre­de­ces­sor(the node lies behind of given node) and Suc­ces­sor
	 (the node lies ahead of given node).
	 */
	 // Note :- not work for BT (only work for BST)
    public void getInorderSuccessorPredecessor(Node root, Node node)
    {
    	int val = node.value;
    	if(root != null)
    	{
    		if(root.value == val)
    		{
    			// go to the right most element in the left subtree, it will the predecessor.
    			if(root.left != null)
    			{
    				Node temp = root.left;
    				while(temp.right != null)
    				{
    					temp = temp.right;
    				}
    				predecessor = temp.value;
    			}
    			// go to the left most element in the left subtree, it will the successor.
    			if(root.right != null)
    			{
    				Node temp = root.right;
    				while(temp.left != null)
    				{
    					temp = temp.left;
    				}
    				successor = temp.value;
    			}
    		}
    		// If val is smaller then root node, set the successor as root, search recursively into left subtree
    		else if(root.value > val)
    		{
    			successor = root.value;
    			getInorderSuccessorPredecessor(root.left, node);

    		}
    		// If val is grater then root node, set the predecessor as root, search recursively into right subtree
    		else if (root.value < val)
    		{
    			predecessor = root.value;
    			getInorderSuccessorPredecessor(root.right, node);
    		}

    	}

    }
    public void getInorderSuccessorPredecessor(Node node)
    {
    	getInorderSuccessorPredecessor(root, node);
    } 

    // K'th largest element in given BST
    public int k_largest_element(Node node, int k)
    {
    	
    	if(node == null)
    	      return -1;
        int val = k_largest_element(node.right,k);
        count +=1;
        if(val != -1)
        	return val;
        //count +=1;
        if(k == count)
        	return node.value;
        return k_largest_element(node.left,k);
    	
    }

// We can do reverse inorder traversal of a BST in order to obtain kth largest element, by keeping global variable
// count for number of elements seen so far.
   public  int k_largest_element(int k)
    {
    	 //int count = 0;
    	 return k_largest_element(root, k);
    }

    // Get diameter of binay tree
    public int getDiameter(Node subtree)
    {
    	if(subtree != null)
    	{
    		// get the left and right subtree height
    		int leftHeight = getHeight(subtree.left);
    		int rightHeight = getHeight(subtree.right);

            
			// get the left diameter and right diameter recursively.
    		int leftDiameter = getDiameter(subtree.left);
    		int rightDiameter = getDiameter(subtree.right);

            // get the max leftsubtree, rightsubtree, longest path goes through root.
    		return Math.max((1 + leftHeight + rightHeight), Math.max(leftDiameter, rightDiameter));
    	}
    	return 0;
    }
   
     
	public static void main(String[] args)
	{
		Node node1; Node node2; Node node3; Node node4; Node node5; Node node6; Node node7;
		Node node8; Node node9; Node node0;

		Node root;
		binary_tree bt;

        /* BST:
		  
		 	     5
		 	    / \
		  	   /   \
		  	  /     \
		     1       8
		    / \     / \
	       0   3   6   9
	          / \   \
		     2   4   7 
		     
		*/ 

		System.out.println("***************** BST *****************");
		System.out.println();
		node1 = new Node(1); node2 = new Node(2); node3 = new Node(3); 
		node4 = new Node(4); node5 = new Node(5); node6 = new Node(6);
		node7 = new Node(7); node8 = new Node(8); node9 = new Node(9);
		node0 = new Node(0);

		root = node5;

		bt = new binary_tree(root);

		root.setLeft(node1);
		root.left.setLeft(node0);
		root.left.setRight(node3);
		root.left.right.setLeft(node2);
		root.left.right.setRight(node4);
		root.setRight(node8);
		root.right.setLeft(node6);
		root.right.setRight(node9);
		root.right.left.setRight(node7);

		run_algorithms(bt);


		/* not BST:
		  
		 	     1
		 	    / \
		 	   /   \
		  	  /     \
		     2       3
		    / \     / \
	       4   5   6   7
	          / \   \
		     8   9   0 
		     
		*/
		System.out.println();
		System.out.println("************* NOT BST *************");
		System.out.println();

		node1 = new Node(1); node2 = new Node(2); node3 = new Node(3);
		node4 = new Node(4); node5 = new Node(5); node6 = new Node(6);
		node7 = new Node(7); node8 = new Node(8); node9 = new Node(9);
		node0 = new Node(0);
		
		root = node1;

		bt = new binary_tree(root);

		root.setLeft(node2);
		root.left.setLeft(node4);
		root.left.setRight(node5);
		root.left.right.setLeft(node8);
		root.left.right.setRight(node9);
		root.setRight(node3);
		root.right.setLeft(node6);
		root.right.left.setRight(node0);
		root.right.setRight(node7);
		
		run_algorithms(bt);     
	}


	public static void run_algorithms(binary_tree bt) 
	{
		System.out.println("=== Level-Wise-printing-of-value ====================");
		bt.print_level_wise();
		System.out.println();
		System.out.println("=== Level-Wise Average ============");
		bt.print_level_average();
		System.out.println("=== Traversals ====================");
		System.out.print("Pre-Order:  ");
		bt.printPreOrder();
		System.out.println();
		System.out.print("In-Order:   ");
		bt.printInOrder();
		System.out.println();
		System.out.print("Post-Order: ");
		bt.printPostOrder();
		System.out.println();
		System.out.println("=== Lowest Common Ancestor +=======");
		bt.getLCA(8, 3);
		System.out.println("=== Inorder Successors and Predeccessor ============");
		Node node1 = bt.find(1);
		Node node9 = bt.find(9);
		Node node7 = bt.find(7);
		//bt.getInorderSuccessorPredecessor(node1);
		//System.out.println("Inorder successor of node1  is " +successor);
		//System.out.println("Inorder predecessor of node1 is " +predecessor);
		bt.getInorderSuccessorPredecessor(node9);
		System.out.println("Inorder successor of  node9 is " +successor);
		System.out.println("Inorder predecessor of  node9 is " +predecessor);
		//bt.getInorderSuccessorPredecessor(node7);
		//System.out.println("Inorder successor of  node7 is " +successor);
		//System.out.println("Inorder predecessor of node7 is " +predecessor);
		System.out.println("=== Is Valid BST? =================");
		System.out.println(bt.isBST());
		System.out.println("========== Tree Height ===================");
		System.out.println("Height: " + bt.getHeight(bt.root));
		System.out.println("========== Tree Level ===================");
		System.out.println("Level: " + bt.getLevel(bt.root));
		System.out.println("Is tree balanced? " + bt.isTreeBalanced());
		
		// find 4th largest element
		System.out.println("K'th largest element in given BST "+ bt.k_largest_element(6));
		// find diameter of binary tree
		System.out.println("=============== Tree diameter ===================");
		System.out.println("Diameter: " + bt.getDiameter(bt.root));
		
		
	}


	public static class Node
	{
		Integer value;
		Node left;
		Node right;
		Node parent;
		public Node(int value)
		{
			this.value = value;
			left = null;
			right = null;
			parent = null; 
		}
		public void setLeft(Node child)
		{
			left = child;
			child.parent = this;
		}
		public void setRight(Node child)
		{
			right = child;
			child.parent = this;
		}
		public String toString()
		{
			return value.toString();
		}
    }
}