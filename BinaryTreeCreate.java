public class BinaryTreeCreate {
    // create binary tree
    public static class Node{
         int key;
         Node left;
         Node right;

         Node(int data){
            key = data;
            // here by default assign null both
            // left and right in java

         }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
    }
}