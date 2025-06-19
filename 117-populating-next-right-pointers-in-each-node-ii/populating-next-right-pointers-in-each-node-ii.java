/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private Node previous;
    private Node nextLevelStart;

    public Node connect(Node root) {
        Node currentLevelNode = root;

        
        while (currentLevelNode != null) {
            
            previous = null;
            nextLevelStart = null;

            while (currentLevelNode != null) {
                
                modifyPointer(currentLevelNode.left);
                
                modifyPointer(currentLevelNode.right);

                
                currentLevelNode = currentLevelNode.next;
            }

            
            currentLevelNode = nextLevelStart;
        }

       
        return root;
    }

    
    private void modifyPointer(Node currentNode) {
        if (currentNode == null) {
          
            return;
        }

       
        if (nextLevelStart == null) {
            nextLevelStart = currentNode;
        }

      
        if (previous != null) {
            previous.next = currentNode;
        }

        
        previous = currentNode;
    }
}