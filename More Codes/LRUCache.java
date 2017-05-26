/*

Typically LRU cache is implemented using a doubly linked list and a hash map.

Doubly Linked List is used to store list of pages with most recently used page at the start of the list. So, 
as more pages are added to the list, least recently used pages are moved to the end of the list with page at 
tail being the least recently used page in the list i.e. The most recently used pages will be near front end and least recently pages will be near rear end.

Hash Map (key: page number, value: page) is used for O(1) access to pages in cache

When a page is accessed, there can be 2 cases:
1. Page is present in the cache - If the page is already present in the cache, we move the page to the start of the list.
2. Page is not present in the cache - If the page is not present in the cache, we add the page to the list. 
How to add a page to the list:
   a. If the cache is not full, add the new page to the start of the list.
   b. If the cache is full, remove the last node of the linked list and move the new page to the start of the list.
*/


import java.util.Map;
import java.util.HashMap;
class LRUCache
{
	private DoublyLinkedList pageList; // size = cacheSize(number of frame) (cache)
	private Map<Integer, Node> pageMap; // here page number as key and address of corresponding DLL node as value
	private final int cacheSize; // number of frame;
	public LRUCache(int cacheSize)
	{
		this.cacheSize = cacheSize;
		pageList = new DoublyLinkedList(cacheSize);
		pageMap = new HashMap<>();
	}  

	// now access the page
	public void accessPage(int pageNumber)
	{
		Node pageNode = null;
		// if page is present in cache, move the page at the start of the list
		if(pageMap.containsKey(pageNumber))
		{
			pageNode = pageMap.get(pageNumber); // access pagenumber from map in o(1) time
			pageList.movePageToHead(pageNode); // move to head of DLL pageList
		}
		else  // if page is not present in cache, add the page to the cache
		{
			if(pageList.getCurrSize() == pageList.getSize())
			{  // if cache is full, remove the tail from the cache pageList
               // Also remove it from HashMap too.
               pageMap.remove(pageList.getTail().getPageNumber()); // when we remove from pageMap, it will automatically removed from pageList(through reference)
			}

			pageNode = pageList.addPageToList(pageNumber); // add page to head of pageList
 			pageMap.put(pageNumber, pageNode); // also store pagenumber and address of pageNode in PageMap 
            
		}
	}
    
    // print cache state
    public void printCacheState()
    {
    	pageList.printList();
    	System.out.println();
    }

	public static void main(String[] args)
	{
		int cacheSize = 4; // number of frame
		LRUCache cache = new LRUCache(cacheSize);
		cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(5);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
	}
}

class DoublyLinkedList
{
	private final int size;
	private int currSize;
	private Node head;
	private Node tail;
	public DoublyLinkedList(int size)
	{
		this.size = size;
		currSize = 0;
	}
	// add page to the page list
	public Node addPageToList(int pageNumber)
	{
		Node pageNode = new Node(pageNumber);
		// if cache(pageList) is empty
		if(head == null)
		{
			head = pageNode;
			tail = pageNode;
			currSize = 1;
			return pageNode;
		}// if number of pages in cache less than cache size
		else if(currSize < size)
		{
			currSize++;
		}
		else
		{
			tail = tail.getPrev();
			tail.setNext(null);
		}
		pageNode.setNext(head);
		head.setPrev(pageNode);
		head = pageNode;
		return pageNode;
	}

	// move page to the head
	public void movePageToHead(Node pageNode)
	{
		// if no page or page is present at head of pagelist then no need to do anything
		if(pageNode == null || pageNode == head)
			return;
		// if page is present at tail then remove that page
		if(pageNode == tail)
		{
			tail = tail.getPrev();
			tail.setNext(null);
		}
		// if page is in between the page list then move that page to head of pageList
		Node prev = pageNode.getPrev();
		Node next = pageNode.getNext();
		prev.setNext(next);

		if(next != null)
			next.setPrev(prev);

		pageNode.setPrev(null);
		pageNode.setNext(head);
		head.setPrev(pageNode);
		head = pageNode;
	}

    
    public void printList()
    {
    	if(head == null)
    		return;
    	Node temp = head;
    	while(temp != null)
    	{
    		System.out.print(temp);
    		temp = temp.getNext();
    	}
    }

	public int getCurrSize()
	{
		return currSize;
	}

	public void setCurrSize(int currSize)
	{
		this.currSize = currSize;
	}

	public int getSize()
	{
		return size;
	}

/*	public void setSize(int size)
	{
		this.size = size;
	}
*/
	public Node getHead()
	{
		return head;
	}

	public void setHead(Node head)
	{
		this.head = head;
	}

	public Node getTail()
	{
		return tail;
	}

	public void setTail(Node tail)
	{
		this.tail = tail;
	}

}

class Node
{
	private int pageNumber;
	private Node next;
	private Node prev;

	public Node(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public int getPageNumber()
	{
		return pageNumber;
	}

	public void setPageNumber()
	{
		this.pageNumber = pageNumber;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}
    
    public Node getPrev()
	{
		return prev;
	}

	public void setPrev(Node prev)
	{
		this.prev = prev;
	}

	public String toString()
	{
		return pageNumber+" ";
	}
}