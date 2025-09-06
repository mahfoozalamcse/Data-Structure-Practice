package practice1;


import java.util.LinkedList;
import java.util.Queue;

public class DepthTree {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }
    static Node root;
    static int maxDepth(Node root){
      if (root == null) {
        return 0;
      }

      int leftMax = maxDepth(root.left);
      int rightMax = maxDepth(root.right);

      return  1 + Math.max(leftMax, rightMax);

    }

    // inorder traveral
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // print at k  distance using DFS
    static void printKDistance(Node root, int k){
        if (root == null) {
            return;
        }

        if ( k == 0) {
            System.out.print(root.data + " ");
        }

        printKDistance(root.left, k-1);
        printKDistance(root.right, k-1);

    }

    // print at k distance using level order traversal -> BFS
    static void printKByLevel(Node root, int k){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root); 
        int level = 0;

        while (!q.isEmpty()) {
           int size = q.size();

           // meet k level than print siply all element
            if (level == k) {
                for(int i=0; i<size; i++){
                    Node curr = q.poll();
                    System.out.print(curr.data +" "); 
                }
                return;
            }
            // other wise simply romove each level and expand next level
            for(int i=0; i<size; i++){
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
           
            level++;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();

        int depth = maxDepth(root);
        System.out.println("Maximum Depth of Tree: " + depth);  

        System.out.println(" At k distance : ");
        printKDistance(root, 2);

        System.out.println(" Print at k position using level order : ");
        printKByLevel(root, 2);
    }
}
