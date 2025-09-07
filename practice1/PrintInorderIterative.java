package practice1;

import java.util.Stack;

public class PrintInorderIterative {
    
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    static Node root;
    // inrder iterative traversal
    static void printInorder(Node root){
        if (root == null) {
            return;
        }

        Stack<Node> s = new Stack<>();
        Node curr = root;

        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            // curr here null
            curr = s.pop();
            System.out.print(" "+ curr.data);
            
            // push right subtree
            curr = curr.right;
        }
    }

    // pre order traversal 
    static void preorderTraversal(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }

        }
    }

    // find LCA (Lowest common ancestor)
    static Node findLCA(Node root, int n1, int n2){
        if (root == null) {
            return null;
        }

        // if root 
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    // find diameter
    static int dia = 0;
    static int diameter(Node root){
        dia = 0;
        height(root);
        return dia;
    }
    // helper
    static int height(Node root){
       if (root == null) {
           return 0;
       }
       int leftHeight = height(root.left);
       int rightHeight = height(root.right);

       // diametere max max path
       dia = Math.max(dia, leftHeight + rightHeight);
    
       // calculate height
       return 1 + Math.max(leftHeight, rightHeight);
    }

    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);

        System.out.println(" Iterative in order : ");
        printInorder(root);

        System.out.println(" Pre order traversal : ");
        preorderTraversal(root);

        System.out.println(" Find LCA : ");
        root = findLCA(root, 6, 7);
        System.out.println("LCA "+" " +root.data);

        System.out.println(" Daimeter : ");
        System.out.println(diameter(root));
    }
}
