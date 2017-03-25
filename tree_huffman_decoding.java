/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/ 

void decode(String S ,Node root)
    {
         Node temp=root;
    for(int i=0;i<S.length();i++)
        {
         temp=S.charAt(i)=='1'?temp.right:temp.left;
        if(temp.left==null && temp.right==null)
            {
            System.out.print(temp.data);
          temp=root;
        }
        }

       
    }
