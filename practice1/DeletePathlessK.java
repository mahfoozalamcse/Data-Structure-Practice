package practice1;
// Delete Path with sum<K
//    Delete nodes from all root-to-leaf paths where path-sum<K
//    Uses DFS with backtracking.

public class DeletePathlessK {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    static Node root;

    // delete method
    static Node deletePath(Node root, int k){
        return deletePathHelper(root, 0,  k);
    }

    static Node deletePathHelper(Node root, int sum, int k){
        if (root == null) {
            return null;
        }

        sum += root.data;

        root.left = deletePathHelper(root.left, sum, k);
        root.right = deletePathHelper(root.right, sum, k);

        // smaller than k simple remove
        if (root.left == null && root.right == null && sum < k) {
            return null;
        }

        // else greater return root
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.data);
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        
        System.out.println(" Before : ");
        inorder(root);

        int K = 10;
        root = deletePath(root, K);

        System.out.print("Inorder of after deleted tree: ");
        inorder(root); 
    } 
}
