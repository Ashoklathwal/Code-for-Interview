# Code-for-Interview

## My Solutions

### Introduction
* Overview of data structure
  * [Set 1 (Linear Data Structures)](http://www.geeksforgeeks.org/overview-of-data-structures-set-1-linear-data-structures/) 
  * [**Set 2 (Binary Tree, BST, Heap and Hash)**](http://www.geeksforgeeks.org/overview-of-data-structures-set-2-binary-tree-bst-heap-and-hash/)
  * [**Set 3 (Graph, Trie, Segment Tree and Suffix Tree)**](http://www.geeksforgeeks.org/overview-of-data-structures-set-3-graph-trie-segment-tree-and-suffix-tree/)
* [**1) Technical Interview Cheat Sheet**](https://github.com/sacert/Technical-Interview-Cheat-Sheet)
* [**2) Technical Interview Cheat Sheet**](https://gist.github.com/TSiege/cbb0507082bb18ff7e4b)
### Linked list :
* How will you detect cycle and remove it from the linked list  [**Solution**](detectCycleLinkedList.java) [**Explanation**](http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/)
* Create a function that does addition where the numbers are represented as two linked lists.[**Solution**](AddLinkedList.java)    [**Explanation**](http://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/)
* Insertion of a node in Linked List (On the basis of some constraints) [**Solution**](addNode.java)
* Delete a given node in Linked List (under given constraints) [**Solution**](deleteNode.java)
* Merge A Linked List Into Another Linked List At Alternate Positions [**Solution**](mergeAlternatePosition.java) [**Explanation**](http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/)
* Write a function to reverse a linked list [**Solution**](reverseList.java)
* Reverse A List In Groups Of Given Size [**Solution**](reverseListInGroup.java)
* Why Quick Sort preferred for Arrays and Merge Sort for Linked Lists [**Explanation**](http://www.geeksforgeeks.org/why-quick-sort-preferred-for-arrays-and-merge-sort-for-linked-lists/)
* Merge Sort For Linked Lists [**Explanation**](http://www.geeksforgeeks.org/merge-sort-for-linked-list/)
* Union And Intersection Of 2 Linked Lists [**Explanation**](http://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/)
* Write a function to get the intersection point of two Linked Lists [**Explanation**](http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/)
* Select A Random Node from A Singly Linked List
* Find middle element of linked list and delete it
* Segregate even and odd nodes in a Linked List
* rotate the linked list counter-clockwise by k nodes
* Flattening a Linked List
* Sort a linked list of 0s, 1s and 2s
* Split a Circular Linked List into two halves
* Sorted insert for circular linked list
* Swap Kth node from beginning with Kth node from end in a Linked List


### Trie data structure
* No Prefix-Set [**Question**](Trie-prefix-set.pdf) [**Solution**](NoPrefixSet.java)
* Trie-Contacts [**Question**](Trie-contacts.pdf) [**Solution**](Trie-contacts.java)

### Dynamic Programming
*  find and print the number of different ways you can make change for  dollars if each coin is available in an infinite quantity.
   [**Question**](coin-changeNumberOfWays.pdf) [**Solution**](noOfWaysCoinChange.java)
* Suppose there are 5 types of coins: 50-cent, 25-cent, 10-cent, 5-cent, and 1-cent. Write a program to find the total number of           different ways of making changes for any amount of money in cents.[**Question**](coin-change.pdf)   
* Implement Fibonacci in bottom-up dynamic programming fashion.
* Given n stairs, how many number of ways can you climb if u use either 1 or 2 at a time? [**Question**](https://www.careercup.com/question?id=3590768)
* Longest Common Subsequence
* Longest Increasing Subsequence
* Edit Distance
* Minimum Partition
* Ways to Cover a Distance
* Longest Path In Matrix
* Subset Sum Problem
* Optimal Strategy for a Game
* 0-1 Knapsack Problem
* Boolean Parenthesization Problem

### Matrix 
 
* Implement Conway's game of life by predicting the next state of a matrix given its current state. 
   
### Sorting
* Implement Quick sort [**Solution**](quickSort.java)
* Implement merge sort [**Solution**](mergeSort.java)
* Counting Inversion : Merge sort [**Question**](merge-sort-counting_Inversion.pdf) [**Solution**](mergeSortCountInversion.java)
* Comparator Sorting [**Question**](comparator-sorting.pdf) [**Solution**](comparatorSorting.java)
* How will you sort a Stack.
* Write a function that accepts two already sorted lists and returns their union in a sorted list.
* Write a function that takes two sorted vectors and returns a single sorted vector.
* Heap Sort (Binary Heap)
* Interpolation Search

### Trees
* [**Algorithms on binary trees**](binary_tree.java). Comprises of the following algorithms:
   * Given a node value, finds the node in tree using dfs
   * Pre-order traversal
   * In-order traversal
   * Post-order traversal
   * Checks if tree is a BST [**Explanation**](http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/)
   * Gets the height or depth of the BT [**Without recursion**](http://algorithms.tutorialhorizon.com/find-the-height-of-a-tree-without-recursion/)
   * Gets the Level of the BT
   * Checks if the tree is height balanced
   * Determines the Lowest Common Ancestor (LCA) of two nodes [**BT Explanation**](http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/) [**BST Explanation**](http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/)
   * Prints the tree level wise using BFS(level order traversal)
   * Prints the average value for each level in tree
   * Determines the in-order successor and predeccessor for a node in BST
   * find the k'th largest element in a Binary Search Tree(BST)?[**Explanation**](http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/)
   * Find Diameter of binary tree [**Explanation**](http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/)    
   * Print top view of Binary tree [**Explanation**](http://algorithms.tutorialhorizon.com/print-the-top-view-of-a-binary-tree/)
   * Left view of BT
   * Print Bottom view of Binary tree [**Explanation**](http://algorithms.tutorialhorizon.com/print-the-bottom-view-of-the-binary-tree/)
   * Create mirror image of BT
* Check one BT is subset of another BT or not   
* Find Minimum Depth of a Binary Tree
* Maximum Path Sum in a Binary Tree
* Check if a given array can represent Preorder Traversal of Binary Search Tree
* Check whether a binary tree is a full binary tree or not
* Remove nodes on root to leaf paths of length < K
* Reverse alternate levels of a perfect binary tree


### Graphs

* Algorithms on Graphs. Comprises of the following algorithms:
   * BFS [**Explanation**](http://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-graph/)
   * DFS
   * Kruskal (MST)
   * Prim (MST)
   * Modified Dijkstra (SSSP)
   * Bellman-Ford (SSSP)
   * Floyd-Warshall (APSP)
* To detect cycle in a Graph **Union Find**
* Topological Sort
* Boggle (Find all possible words in a board of characters)
* Bridges in a Graph

### Other Important Questions :
* Given a number, return all possible strings that the number could represent if `2 -> {A, B, C}, 4 -> {D, E, F}`, and so on. (OR) return-all-possible-strings-that-the-phone-number-could-represent [**Solution**](AllPossibleStrings.java) [**Explanation**](http://www.geeksforgeeks.org/find-possible-words-phone-digits/)
* Given an array, print the Next Greater Element (NGE) for every element [**Solution**](nextGreaterElement.java) [**Explanation**](http://www.geeksforgeeks.org/next-greater-element/)
* Given a string "aaabbbcc", compress it into "a3b3c2" in-place.[**Original Question**](https://www.careercup.com/question?id=7449675) [**Solution**](stringCompression.java)
* A kidnaper wishes to write a ransom note using letters from a magazine article. You are given with the ransom note and magazine article find whether kidnaper can write a note using the article or not [**Question**](ctci-ransom-note.pdf) [**Solution**](RansomNotes.java)
* Implement a queue using 2 stacks. [**Question**](queue-using-two-stacks.pdf) [**Solution**](queUsing2Stack.java)
* Write a function that parses a string into integer.[**Solution**](parseStrToInteger.java)
* Given an array of integers, return all possible subsets and powerset of length n. [**Explanation**](http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/) [**Solution**](allSubsetPowerset.java)
* Write some code that will determine if brackets in a string are balanced. [**Question**](https://www.hackerrank.com/challenges/ctci-balanced-brackets) [**Solution**](balanceBrackets.java)
* write a function that perforn left rotation in an array with k shift. [**Question**](array-left-rotation.pdf) [**Solution**](leftRotateaArray.java)
* Given two strings, and , that may or may not be of the same length, determine the minimum number of character deletions required to     make and anagrams. Any characters can be deleted from either of the strings. [**Question**](making-anagrams.pdf) [**Solution**](makingAnagram.java)
* Find runnning median in a stream of integer. [**Question**](find-the-running-median.pdf) [**Solution**](RunningMideanInStream.java) [**Explanation**](http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/)
* Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase. [**Question**](recursive-staircase.pdf) [**Solution**](staircase.java)
* Lonely Integer OR Find the Number Occurring Odd Number of Times [**Question**]() [**Solution**](lonelyInteger.java) [**Explanation**](http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/)
* Check wheather number is prime or not  [**Solution**](Primality.java)
* Code a function that calculates the square root (2-point precision) of a given number(wihtout using the Math library). Follow up: Avoid redundant calculations by now optimizing your function with a caching mechanism. [**Babylonian method/Newton's method**](https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method) [**Solution**](square_root.java) [**Explanation**](http://www.geeksforgeeks.org/square-root-of-a-perfect-square/) 
* Write a function that raises one number to another number, i.e. the pow() function in log(n) time. [**Solution**](pow.java)
* Implement integer division without using / or % in O(logN).
* Given a string, print out all its permutations(without duplicate in input [**Explanation**](http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/) [**Solution**](AllPermutationWithOutDuplicateInInput.java) and with duplicates in input).
* Print all permutations in sorted (lexicographic) order [**Explanation**](http://www.geeksforgeeks.org/lexicographic-permutations-of-string/)
* Given a number, obtain the next larger permutation and next lower permutation by swapping around the digits in the number.
* Given a string, print out all its combinations.
* How do you find the median of a very large dataset?
* Fill an array based on frequency where elements are in range from 0 to n-1
* If you have an incoming stream of numbers, how would you find the most frequent numbers on-the-fly?
* Split a large string into valid words and store them in a dictionary. If the string cannot be split, return false. What’s your solution’s complexity?
* What’s the computational complexity of finding a document’s most frequently used words?
* If you’re given 10 TBs of unstructured customer data, how would you go about finding extracting valuable information from it?
*  How would you ‘disjoin’ two arrays (like JOIN for SQL, but the opposite)?
* How would you use Python to read a very large tab-delimited file of numbers to count the frequency of each number?
* Write a function that takes a sentence and prints out the same sentence with each word backwards in O(n) time.
* Write a function that takes an array, splits the array into every possible set of two arrays, and prints out the max differences between the two array’s minima in O(n) time.
* You have a room-full of balances and weights. Each balance weighs ten pounds and is considered perfectly balanced when the sum of       weights on its left and right sides are exactly the same. You have placed some weights on some of the balances, and you have placed     some of the balances on other balances. Given a description of how the balances are arranged and how much additional weight is on each   balance, determine how to add weight to the balances so that they are all perfectly balanced. [*Original question*](http://www.careercup.com/question?id=12150672) 
* Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit           sequence.[**Question**](http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/)
* Solve the “FizzBuzz” problem (needs no introduction).
* Reverse an array without affecting special characters
* All Possible Palindromic Partitions
* Count triplets with sum smaller than a given value
* Convert array into Zig-Zag fashion
* Generate all possible sorted arrays from alternate elements of two given sorted arrays
* Pythagorean Triplet in an array
* Length of the largest subarray with contiguous elements
* Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
* Smallest subarray with sum greater than a given value
* Stock Buy Sell to Maximize Profit [**Explanation**](http://www.geeksforgeeks.org/stock-buy-sell/)
* implement Elevator
* Find minimum average waiting time
* Implement LRU Cache
