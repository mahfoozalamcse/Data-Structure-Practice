package practice1;
// Question: Delete All Half Nodes in a Binary Tree

public class DeleteHalfNode {
    static class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left=right= null;
        }
    }

    static Node root;
    static Node deleteHalfNode(Node root){
        if (root == null) {
            return null;
        }

         root.left = deleteHalfNode(root.left);
         root.right = deleteHalfNode(root.right);

         if (root.left != null && root.right != null) {
            return root;
         }

         // if have leaf node
         if (root.left == null && root.right == null) {
             return root;
         }

         if (root.left == null) {
            return root.right;
         }else{
            return root.left;
         }

        
    }

    // traversal inorder
    static void traverasal(Node root){
        if (root != null) {
            traverasal(root.left);
            System.out.print(" "+ root.data);
            traverasal(root.right);
        }
    }
    public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(20);
      root.right  = new Node(30);
      root.left.left = new Node(40);
      root.left.right = new Node(50);
      root.right.right = new Node(60);
      root.left.left.left = new Node(70);
      root.left.left.right = new Node(80);

      System.out.println(" Before traversal : ");
      traverasal(root);
      deleteHalfNode(root);
      System.out.println(" After deleted half : ");
      traverasal(root);



    }
}
