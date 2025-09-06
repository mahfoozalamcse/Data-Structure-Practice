package practice1;

public class DeleteSmallerandGreater {
    static class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    static Node root;
    // delete method greater than k
    static Node greaterKNode(Node root , int k){
      if (root == null) {
        return null;
      }

      if (root.data > k) {
          // discard right due to greater
          return greaterKNode(root.left, k);
      }
      // prune right for greater check
      root.right = greaterKNode(root.right, k);
      return root;
    }

    // smaller than k
    static Node smallerNode(Node root, int k){
        if (root == null) {
            return null;
        }

        if (root.data < k) {
            // discord left due to smaller
            return smallerNode(root.right, k);
        }
        
        // left prune to find smaller
        root.left = smallerNode(root.left, k);
        return root;
    }

    // inorder traversal
    static void inorder(Node root){
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data +" ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        System.out.print("Original BST (inorder): ");
        inorder(root);
        System.out.println();

        // Delete greater than 12
        root = greaterKNode(root, 12);
        System.out.print("After deleting > 12: ");
        inorder(root);
        System.out.println();

        // Reset tree again
        root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        // Delete smaller than 12
        root = smallerNode(root, 12);
        System.out.print("After deleting < 12: ");
        inorder(root);
    }
}
