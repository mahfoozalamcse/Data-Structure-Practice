package practice1;

public class DeleteBST {
    static class Node{
        int data;
        Node left, right;

        Node(int val){
            data = val;
            left = right = null;
        }
    }

    static Node root;
    // utility method
    static Node minNode(Node root){
        Node curNode = root;
        while (curNode.left != null) {
            curNode = curNode.left;
        }

        return curNode;
    }

    static Node deleteNode(Node root, int key){

        if (root == null) {
            return root;
        }

        if (key < root.data) {
            // key serch left
            root.left = deleteNode(root.left, key);
        }else if (key > root.data) {
            // key search right
            root.right = deleteNode(root.right, key);
        }else{
            // else root found case 
            //1. root and left right is null

            if (root.left == null & root.right == null) {
                return null;
            }

            // if one child left
            if (root.left != null && root.right == null) {
                return root.left;
            }
            // if one right child left
            if (root.right != null && root.left == null) {
                return root.right;
            }

            // when two child
            Node successor = minNode(root.right);
            root.data = successor.data;
            root.right = deleteNode(root.right, successor.data);

        }
        return root;
    }

    // in order traversal
    static void traverasal(Node root){
        if (root != null) {
            traverasal(root.left);
            System.out.println(" "+ root.data);
            traverasal(root.right);
        }
    }
    
    public static void main(String[] args) {
      Node root = new Node(10);
      root.left = new Node(20);
      root.right = new Node(30);
      root.left.left = new Node(40);
      root.right.right = new Node(50);

      traverasal(root);
      System.out.println("After deleted : ");
      deleteNode(root, 30);
      traverasal(root);

    }
    
}
