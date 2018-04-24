/*
 * HARD
 * 
 * Tries: Contacts
 * 
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 * 
 * Check out the resources on the page's right side to learn more about tries. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.

We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
 */
package net.jacoblo.dataStructure.Trie;

public class Contacts {
  
  private static class Node {
    public Node[] nodes; // it should be sized 26, because lower case english. and null means this is the last letter.
    
    public Node() {
      nodes = new Node[26];
    }
    
    private void add(char[] str, int pos ) {
      if (str == null || str.length <= 0 || pos < 0 || pos >= str.length ) return;
      
      Node current = nodes[str[pos]-'a'];
      if (current == null) {
        current = new Node();
      }
      current.add(str,pos+1);
    }
    
    private Node find(char[] str, int pos) {
      if (str == null || str.length <= 0 || pos < 0 || pos >= str.length ) return null;
      
      Node current = nodes[str[pos]-'a'];
      if (current != null) {
        current = find(str,pos+1);
      }
      
      return current;
    }
    
    // TODO add print method
    // TODO handle the case : hack, hacker
  }
  private static class Trie {
    public Node[] nodes;
    
    public Trie() {
      nodes = new Node[26];
    }
    
    public void add(String s) {
      if ( s == null || s.length() <= 0 ) return;
      
      char[] chars = s.toCharArray();
      
      Node current = nodes[chars[0]-'a'];
      if (current == null) {
        current = new Node();
      }
      current.add(chars,1);
    }
    
     
  }
}
