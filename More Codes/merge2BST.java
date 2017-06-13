import java.util.Stack;
class merge2BST
{
	static Node root1;
	static Node root2;
/*
 * Test cases
 * Both tree are null
 * One of the tree is null
 * All elements of one tree occur before other tree
 * All elements of one tree occur after other tree
 * Elements are mixed
 * All same elements
 */
    public static void merge2BST_util(Node root1, Node root2)
    {
    	Stack<Node> stk1 = new Stack<>();
    	Stack<Node> stk2 = new Stack<>();

    	while(true)
    	{
    		if(root1 != null)
    		{
    			stk1.add(root1);
    			root1 = root1.left;
                continue;
    		}
    		if(root2 != null)
    		{
    			stk2.add(root2);
    			root2 = root2.left;
                continue;
    		}

    		if(!stk1.isEmpty())
    			root1 = stk1.peek();
    		if(!stk2.isEmpty())
    			root2 = stk2.peek();
            
            if(root1 != null && root2 != null)
            {
            	if(root1.data <= root2.data)
            	{
            		System.out.print(root1.data+" ");
            		root1 = stk1.pop();
            		root1 = root1.right;
            		root2 = null;
            	}
            	else
            	{
            		System.out.print(root2.data+" ");
            		root2 = stk2.pop();
            		root2 = root2.right;
            		root1 = null;
            	}
            }
            else
            {
            	if(root1 != null)
            	{
            		System.out.print(root1.data+" ");
            		root1 = stk1.pop();
            		root1 = root1.right;
            	}

            	if(root2 != null)
            	{
            		System.out.print(root2.data+" ");
            		root2 = stk2.pop();
            		root2 = root2.right;
            	}

            }

    		if(root1 == null && root2 == null && stk1.isEmpty() && stk2.isEmpty())
    			break;
    	}

    }
	public static void main(String[] args) 
	{
		merge2BST tree1 = new merge2BST();
         /*
               100
              /  \
            50    300
           / \
         20  70

         */
		tree1.root1 = new Node(100);
		tree1.root1.left = new Node(50);
		tree1.root1.right = new Node(300);
		tree1.root1.left.left = new Node(20);
		tree1.root1.left.right = new Node(70);

        merge2BST tree2 = new merge2BST();
		/*
           80
           /  \
         40   120
      

		*/
        tree2.root2 = new Node(80);
		tree2.root2.left = new Node(40);
		tree2.root2.right = new Node(120); 

		merge2BST_util(root1, root2);
		
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