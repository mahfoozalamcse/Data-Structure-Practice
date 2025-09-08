package Practice2;

import java.util.Stack;

public class BinaryTreeToDLL {
    // convert binary tree to doubly linkedlist
    static class Node{
        int data;
        Node left, right;

        Node(int val){
            data = val;
            left = right = null;
        }
    }

    static Node head = null;
    static Node prev = null;
 
    // method convert to DLL
    static void conertTreeToDLL(Node root){
        if (root == null) {
            return;
        }
        // inorder traversal left -> root -> right
        // go first left most than start build DLL
        conertTreeToDLL(root.left);

        if (head == null) {
           head = root; 
        }else{
            root.left = prev;
            prev.right = root;
        }

        prev = root;  // move prev to curr

        conertTreeToDLL(root.right);
    }

    // print DLL
    static void printDLL(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    // iterative solution convert binary tree to doubly linked list
    static Node convertTreeToDLL2(Node root){
        if (root == null) {
            return null;
        }

        Stack<Node> st = new Stack<>();
        Node curr = root;
        Node head = null, prev = null;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            if (head == null) {
                head = curr;
            }
            if (prev != null) {
                prev.right = curr;
                curr.left = prev;
            }

            prev = curr; // set prev with current node

            // move right
            curr = curr.right;
        }

        return head;

    }
    

    public static void main(String[] args) {
        // Node root = new Node(10);
        // root.left = new Node(12);
        // root.right = new Node(15);
        // root.left.left = new Node(25);
        // root.left.right = new Node(30);
        // root.right.left = new Node(36);

        // conertTreeToDLL(root);

        // System.out.print("Doubly linked list is : ");
        // printDLL(head);  

        System.out.println();
        System.out.print("Doubly linked list is  using iterative : ");
        Node root2 = new Node(10);
        root2.left = new Node(12);
        root2.right = new Node(15);
        root2.left.left = new Node(25);
        root2.left.right = new Node(30);
        root2.right.left = new Node(36);

        Node head2 = convertTreeToDLL2(root2);
        printDLL(head2);
        
    }
}
