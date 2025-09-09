package Practice2;

public class MirrorOfTree {
    static class Node{
        int data;
        Node left, right;
        Node(int value){
            data = value;
            left = right = null;
        }
    }
    

    // mirrorr method
    static Node printMirror(Node root){
        if (root == null) {
            return null;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        printMirror(root.left);
        printMirror(root.right);

        return root;
    }

    static void inorderTraversal(Node root){
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data+ " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println();
        inorderTraversal(root);
        System.out.println(" Print mirror");
        printMirror(root);
        inorderTraversal(root);
    }
}
