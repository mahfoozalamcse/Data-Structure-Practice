package Test7;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LCA {
    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        if (root == null) {
            return null;
        }

        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        } else if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        } else {
            return root;
        }

    }

    // iterative solution
    public static Node lcaIterative(Node root, int v1, int v2) {
        
        while (root != null){

            // Both nodes in left subtree
            if (v1 < root.data && v2 < root.data) {
                root = root.left;
            }
            // Both nodes in right subtree
            else if (v1 > root.data && v2 > root.data) {
                root = root.right;
            }
            // Split occurs → LCA found
            else {
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
