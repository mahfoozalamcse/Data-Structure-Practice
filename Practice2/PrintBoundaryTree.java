package Practice2;

import java.util.Stack;

public class PrintBoundaryTree {
    // Boundary View of Binary Tree

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    
    // print boundary view code

    // check leaf
    static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    // print left boundary
    static void printLeftBoundary(Node root) {

        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                System.out.print(curr.data + " ");
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // print right boundary

    static void printrightBoundary(Node root) {
        Stack<Integer> st = new Stack<>();
        Node curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                st.push(curr.data);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    // print left boundary
    static void printLeafBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            System.out.print(root.data + " ");
            return;
        }
        printLeafBoundary(root.left);
        printLeafBoundary(root.right);

    }

    // main boundary method
    static void printBoundary(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data+ " ");

        // print left
        printLeftBoundary(root);

        // print leaf
        printLeafBoundary(root.left);
        printLeafBoundary(root.right);

        // print right
        printrightBoundary(root);

    }

    public static void main(String[] args) {
        /*
         *     1
         *    / \
         *   2  3
         *  / \ / \
         * 4  5 6 7
         * 
         * Boundary View: 1 2 4 5 6 7 3
         * 
         * 
         * 
         * 
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println();
        System.out.println(" Print Boundary in Tree : ");
        printBoundary(root);

    }

}
