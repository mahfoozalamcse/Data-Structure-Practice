package Practice2;

import java.util.LinkedList;
import java.util.Queue;

public class IndenticalTree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static boolean isIdentical(Node root1, Node root2) {
        // if both null
        if (root1 == null && root2 == null) {
            return true;
        }
 
        // if any any one null return false
        if (root1 == null || root2 == null) {
            return false;
        }

        // if not equal return false
        if (root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left) &&
                isIdentical(root1.right, root2.right);

    }

    // iterative solution
    static boolean isIdentical2(Node root1, Node root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node n1 = q1.poll();
            Node n2 = q2.poll();

            // compare each element in both q1 and q2 is equal or not
            if (n1.data != n2.data) {
                return false;
            }

            // check left child and add in Queeue
            if (n1.left != null && n2.left != null) {
                q1.add(n1.left);
                q2.add(n2.left);
            }else if (n1.left != null || n2.left != null) {
                return false;
            }

            // check right child add in queue
            if (n1.right != null && n2.right != null) {
                q1.add(n1.right);
                q2.add(n2.right);
            } else if (n1.right != null || n2.right != null) {
                return false;
            }
        }
        // here we check and remove if not remove than not identcal
        return q1.isEmpty() && q2.isEmpty();
        
    }

    public static void main(String[] args) {
        Node root1 = new Node(10);
        root1.left = new Node(20);
        root1.right = new Node(30);
        root1.right.right = new Node(50);
        root1.right.left = new Node(40);

        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.right.right = new Node(50);
        root2.right.left = new Node(40);

        System.out.println("Recursive solution : " + isIdentical(root1, root2));
        System.out.println("Iterative solution : " + isIdentical2(root1, root2));
    }
}
