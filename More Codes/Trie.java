import java.util.*;
class Trie
{
	public class TrieNode
	{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		public TrieNode()
		{
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	private final TrieNode root;
	public Trie()
	{
		root = new TrieNode();
	}

	// insert keys into Trie
	public void insertToTrie(String word)
	{
		TrieNode curr = root;
        for(int i=0;i<word.length();i++)
        {
        	char ch = word.charAt(i);
        	TrieNode node = curr.children.get(ch);
        	if(node == null)
        	{
        		node = new TrieNode();
        		curr.children.put(ch, node);
        	}

        	curr = node;
        }
        // mark the curr node endOfWord is true
        curr.endOfWord = true;
	}

	// search the key into Trie
	public boolean searchIntoTrie(String word)
	{
		TrieNode curr = root;
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			TrieNode node = curr.children.get(ch);
			//if node does not exist for given char then return false
			if(node == null)
				return false;
			curr = node;
		}
         //return true of current's endOfWord is true else return false.
		return curr.endOfWord;
	}

    // delete the word from Trie and Returns true if parent should delete the mapping
    /**
     * Delete word from trie.
     */
    public boolean delete(String word) 
    {
        return delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) 
    {
        if (index == word.length()) 
        {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) 
            {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

	public static void main(String[] args) 
	{
		String[] arr = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		Trie trie = new Trie();
        // insert the keys into trie
        System.out.println("Inserting the keys into Trie ");
        for(int i=0;i<arr.length;i++)
               trie.insertToTrie(arr[i]);
        System.out.println("Insertion complete");  
	    // search for Differnt keys
	    System.out.println("searching the different keys into trie");
	    System.out.println("the : "+trie.searchIntoTrie("the"));
	    System.out.println("these : "+trie.searchIntoTrie("these"));
	    System.out.println("their : "+trie.searchIntoTrie("their"));
	    System.out.println("thaw : "+trie.searchIntoTrie("thaw"));
	    // delete the key from trie and Returns true if parent should delete the mapping
	    System.out.println("Deleting the words from trie");
	    System.out.println("Delete their : "+trie.delete("their"));
	    System.out.println("Delete the : "+trie.delete("the"));	
	}
}