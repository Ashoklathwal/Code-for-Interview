/*
Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted
       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
 output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.

The idea is to use Merge() process of merge sort for linked lists. We use merge() to merge lists one by one. 
We recursively merge() the current list with already flattened list.
The down pointer is used to link nodes of the flattened list.
*/
class flattenList
{
	Node head;
	class Node
	{
		int data;
		Node right; // right pointer
		Node down; // down pointer
		Node(int data)
		{
			this.data = data;
			right = null;
			down = null;
		}
	}

	// merge function
    Node merge(Node a, Node b)
    {
    	// if first list is empty then second is our ans
    	if(a == null)
    		return b;
    	// if second list is empty then first is our ans
        if(b == null)
        	return a;
        // otherwise compare their nodes
        // crete a result node
        Node result; 
        if(a.data < b.data)
        {
        	result = a;
        	result.down = merge(a.down, b);
        }
        else
        {
        	result = b;
        	result.down = merge(a, b.down);
        }
        return result;
    }

	// flatten function
	Node flatten(Node root)
	{
		Node curr = root;
		// base case
		if(curr == null || curr.right == null)
			return curr;
		// reccurance of list on the right
		curr.right = flatten(curr.right);

		// merge now
		curr = merge(curr, curr.right);

		root = curr;
        return root;
	}

	// push the node in linked list
	Node push(Node root, int data)
	{
		Node new_node = new Node(data);
		new_node.down = root;
		root = new_node;
		return root; 
	}

	// print linked list

	void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.down;
		}
	} 
	public static void main(String[] args)
	{
		flattenList list = new flattenList();
		/* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */
        list.head = list.push(list.head, 30);
        list.head = list.push(list.head, 8);
        list.head = list.push(list.head, 7);
        list.head = list.push(list.head, 5);

        list.head.right = list.push(list.head.right, 20);
        list.head.right = list.push(list.head.right, 10);

        list.head.right.right = list.push(list.head.right.right, 50);
        list.head.right.right = list.push(list.head.right.right, 22);
        list.head.right.right = list.push(list.head.right.right, 19);

        list.head.right.right.right = list.push(list.head.right.right.right, 45);
        list.head.right.right.right = list.push(list.head.right.right.right, 40);
        list.head.right.right.right = list.push(list.head.right.right.right, 35);
        list.head.right.right.right = list.push(list.head.right.right.right, 28);
        System.out.println("**Flatten list**");
        list.head = list.flatten(list.head);
        list.printList();
	}
}