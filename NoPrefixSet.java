import java.io.*;
import java.util.*;

public class Trie 
{
    static class TrieNode
        {
         Map<Character, TrieNode> children;
         boolean endOfWord;
         public TrieNode()
             {
              children=new HashMap<>();
              endOfWord=false;
             }
        }
    public static TrieNode root;
    public Trie()
        {
         root=new TrieNode();
        }
    public static void main(String[] args) 
    {
        Trie tri = new Trie();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ss = "";
        boolean flag = true;
        mainloop:
        for(int j=0;j<n;j++)
            {
             String contact = sc.next();
            TrieNode current = root;
          for(int i=0;i<contact.length();i++)
              {
               char ch=contact.charAt(i);
               TrieNode node=current.children.get(ch);
               if(node == null)
                   {
                    node = new TrieNode();
                    current.children.put(ch,node);
                   }
               else
               {
            	   if(node.endOfWord == true || i ==contact.length()-1)
            	   {
            		   flag = false;
                       ss = contact;
                       break mainloop;
            	   }
               }
             current = node;
              }
        current.endOfWord = true;
        
            }
        if(flag)
            System.out.println("GOOD SET");
        else
            {
             System.out.println("BAD SET");
             System.out.println(ss);
            }
        
    }
}