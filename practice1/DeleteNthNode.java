package practice1;

public class DeleteNthNode {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    static Node root;
    static int count = 0;
    // traversal + deletion
    static Node deleteNth(Node root, int N){
        if (root == null) {
           return null;
        }

        // traverse left
        root.left = deleteNth(root.left, N);

        count++;

        if (count == N) {
            System.out.println(" Deleted Node :"+ root.data);
            root = delete(root, root.data);
            return root;
        }
        
        // traverse right
        root.right = deleteNth(root.right, N);

        return root;
        
    }
    // delete method
    static Node delete(Node root, int key){

       if (root == null) {
          return root;
       }
       if (key < root.data) {
          root.left = delete(root.left, key);
       }else if (key > root.data) {
          root.right = delete(root.right, key);
       }else{
           // found case
           // not exist left and right child
           if (root.left == null && root.right == null) {
               return null;
           }
           // if one child
           else if (root.left == null && root.right != null) {
               return root.right;

            // if one child
           } else if (root.left != null && root.right == null) {
               return root.left;
           }

           // if two child
           Node successor = minValue(root.right);
           root.data = successor.data;
           root.right = delete(root.right, successor.data);
       }
       return root;
    }

    // utility method
    static Node minValue(Node root){
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

    // inorder traversal for print method
    static void traverasal(Node root){
        if (root != null) {
            traverasal(root.left);
            System.out.println(" " + root.data);
            traverasal(root.right);
        }
    }
   public static void main(String[] args) {
       Node root = new Node(10);
       root.left = new Node(20);
       root.right = new Node(30);
       root.left.left = new Node(40);
       root.right.right = new Node(50);
       
       System.out.println(" Before traversal : ");
       traverasal(root);
       System.out.println(" After traversal : ");
       deleteNth(root, 3);
       traverasal(root);
   } 
}
