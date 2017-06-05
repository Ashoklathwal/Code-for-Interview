import java.util.*;
class Node 
{
	int data;
	Node left, right;

	Node(int item) 
	{
		data = item;
		left = right = null;
	}
}

class sumPath {

  	Node root;
  	static Stack<Integer> stk = new Stack<>();
 
    
   

    public void rootToAny_util(Node root, Stack<Integer> stk, int sum, int max_sum_so_far)
    {
    	if(root == null)
    		return;
    	stk.push(root.data);
    	max_sum_so_far += root.data;
    	if(max_sum_so_far == sum)
    	{
    		printStack();
    	}

    	rootToAny_util(root.left, stk, sum, max_sum_so_far);
    	rootToAny_util(root.right, stk, sum, max_sum_so_far);
    	stk.pop();
    }
   
    public void rootToAny(Node root, int sum)
    {
    	int max_sum_so_far = 0;
    	rootToAny_util(root, stk, sum, max_sum_so_far);
    }
    
     public void rootToleaf_util(Node root, Stack<Integer> stk, int sum, int max_sum_so_far)
    {
    	if(root == null)
    		return;
    	stk.push(root.data);
    	max_sum_so_far += root.data;
    	if(max_sum_so_far == sum && root.left == null && root.right == null)
    	{
    		printStack();
    	}

    	rootToleaf_util(root.left, stk, sum, max_sum_so_far);
    	rootToleaf_util(root.right, stk, sum, max_sum_so_far);
    	stk.pop();
    }
  //  static Stack<Integer> stk = new Stack<>();
    public void rootToleaf(Node root, int sum)
    {
    	int max_sum_so_far = 0;
    	rootToleaf_util(root, stk, sum, max_sum_so_far);
    }
    public void printStack()
    {
    	System.out.println(stk);
    }

    public void anyNodeToanyNode_util(Node root, Stack<Integer> stk, int sum, int max_sum_so_far)
    {
    	if(root == null)
    		return;
    	// add current node to the stack
    	stk.push(root.data);
    	//check if there's any k sum path in the left sub-tree.
    	anyNodeToanyNode_util(root.left, stk, sum, max_sum_so_far);
    	//check if there's any k sum path in the right sub-tree.
    	anyNodeToanyNode_util(root.right, stk, sum, max_sum_so_far);


       // check if there's any k sum path that terminates at this node
       // Traverse the entire path as there can be negative elements too   
       max_sum_so_far = 0; 	
    	for(int i=stk.size()-1; i>=0; i--)
    	{
    	     max_sum_so_far += stk.get(i);
          	 if(max_sum_so_far == sum )
    	       {
    		     printStack(stk, i);
    	       }
        }
    	stk.pop();
    }
  //  static Stack<Integer> stk = new Stack<>();
    public void anyNodeToanyNode(Node root, int sum)
    {
    	int max_sum_so_far = 0;
    	anyNodeToanyNode_util(root, stk, sum, max_sum_so_far);
    }
     public void printStack(Stack<Integer> stk, int end)
     {
     	for(int i=end;i<stk.size();i++)
     		System.out.print(stk.get(i)+" ");
     	System.out.println();
     }
	/* Driver program to test the above functions */
	public static void main(String args[]) 
	{
		int sum = 38;
		
		/* Constructed binary tree is
			 /*   10
                /     \
              28       13
                     /     \
                   14       15
                  /   \     /  \
                 21   11   10   24
		*/
		sumPath tree = new sumPath();
		tree.root = new Node(10);
		tree.root.left = new Node(28);
		tree.root.right = new Node(13); 
        tree.root.right.left   = new Node(14);
        tree.root.right.right  = new Node(15);
        tree.root.right.left.left   = new Node(21);
        tree.root.right.left.right   = new Node(11);
        tree.root.right.right.left   = new Node(10);
        tree.root.right.right.right   = new Node(24);
        
 
   
        System.out.println("**********RootToAny************");
		tree.rootToAny(tree.root, sum);
		stk.clear();
		System.out.println("**********RootToLeaf************");
		tree.rootToleaf(tree.root, sum); 
		stk.clear();
		System.out.println("**********AnyNodeToAnyNode************");
		tree.anyNodeToanyNode(tree.root, sum);  
		
			
		
	}
}