package practice1;

// Delete leaves with a given value

public class DeleteLeaf {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    static Node root;

    // postorder + check target
    static Node removeLeafNode(Node root, int target){
       if (root == null) {
        return null;
       }

       root.left = removeLeafNode(root.left, target);
       root.right = removeLeafNode(root.right, target);
 
       if (root.left == null && root.right == null && root.data == target) {
          return null;
       }
       return root;
    }

    static void inorder(Node root){
        if (root != null) {
            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        System.out.println("Inorder before:");
        inorder(root);
        System.out.println();

        root = removeLeafNode(root, 2);

        System.out.println("Inorder after:");
        inorder(root);
    } 
}
