package practice1;

public class DeleteTree {
    static class Node{
        int data;
        Node left, right;
        Node(int val){
            data = val;
            left = right = null;
        }
    }

    static Node root;
    static void delete(Node root){
        if (root == null) {
            return;
        }

        // delete left
        delete(root.left);

        // delete right
        delete(root.right);

        System.out.println("Deleted node : "+ root.data);
        root.left = null;
        root.right = null;

        
    }

    static void delete(){
        delete(root);
        root = null;
        System.out.println("Deleted success.. ");
    }

    // traversal tree
    public static void traversal(Node root){
        if (root != null) {
            traversal(root.left);
            System.out.println(root.data+" ");
            traversal(root.right);
        }

    }

    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40); 

        delete();
    }
}
