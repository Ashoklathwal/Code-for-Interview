// A Binary Tree node
/* class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}  */
class GfG
{   
  /*  int getLevelDiff_recursive(Node root)
    {
        if(root == null) return 0;
        return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
    	
    }
    */
    int getLevelDiff(Node root)
    {
      int evensum=0,oddsum=0;
      if(root == null) 
          return 0;
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      int level=1;
      while(!q.isEmpty())
       {
            int size=q.size();
            if(level%2==0)
               {
                 while(size-- > 0)
                   {
                      Node temp=q.poll();
                      if(temp.left != null)
                          q.add(temp.left);
                      if(temp.right != null)
                          q.add(temp.right);
                      evensum += temp.data;
                    }
                }
            else
               {
                    while(size-- > 0)
                   {
                      Node temp=q.poll();
                      if(temp.left != null)
                          q.add(temp.left);
                      if(temp.right != null)
                          q.add(temp.right);
                      oddsum += temp.data;
                    }
               }
               level++;
        }
        
    
    return oddsum-evensum;
    	
    }
}