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
    public Node connect(Node root) {
    if (root == null)
      return null;
    connectTwoNodes(root.left, root.right);
    return root;
  }

  private void connectTwoNodes(Node p, Node q) {
    if (p == null)
      return;
    p.next = q;
    connectTwoNodes(p.left, p.right);
    connectTwoNodes(q.left, q.right);
    connectTwoNodes(p.right, q.left);
  }
}