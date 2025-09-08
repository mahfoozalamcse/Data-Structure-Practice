package Practice2;

public class ThreadedBinaryTree {
    static class Node {
        int data;
        Node left, right;
        boolean rightThread;

        Node(int value) {
            data = value;
            left = right = null;

            rightThread = false;
        }
    }

    // insert threaded tree
    static Node insert(Node root, int key) {
        Node point = root;
        Node par = null;

        while (point != null) {
            if (key == point.data) {
                System.out.println(" Duplicate key  ");
                return root;
            }
            par = point;
            if (key < point.data) {
                if (point.left != null) {
                    point = point.left;
                } else {
                    break;
                }
            } else {
                if (!point.rightThread) {
                    point = point.right;
                } else {
                    break;
                }
            }
        }

        Node newNode = new Node(key);
        if (par == null) { // first node
            root = newNode;
        } else if (key < par.data) {
            par.left = newNode;
            newNode.right = par;
            newNode.rightThread = true;
        } else {
            newNode.right = par.right;
            newNode.rightThread = true;
            par.right = newNode;
            par.rightThread = false;
        }
        return root;
    }

    // find left most node
    static Node leftMost(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // inorder traversal using thread
    static void inorder(Node root){
        if (root == null) {
            return;
        }
        Node curr = leftMost(root);

        while (curr != null) {
            System.out.print(curr.data + " ");

            // if threaded than go, inorder successor
            if (curr.rightThread) {
                curr = curr.right;
            }else{
                curr = leftMost(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 30);
        root = insert(root, 5);
        root = insert(root, 16);
        root = insert(root, 14);
        root = insert(root, 17);

        System.out.print("Inorder traversal using threaded binary tree :  ");
        inorder(root);
    }
}
