package practice1;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    // print level order
    static void printLevel(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr  = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    // print size tree
    // use DFS
    static int size(Node root){
        if (root == null) {
            return 0;
        }

        return size(root.left) + 1 + size(root.right);
    }

    // level order BFS
    static int sizeByLevel(Node root){
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            count++;

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return count;

    }

    // find minimum element
    static int findMin(Node root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int res = root.data;
        int lRes = findMin(root.left); 
        int rRes = findMin(root.right);

        if (lRes < res) {
            res = lRes;
        }
        if (rRes < res) {
            res = rRes;
        }

        return res;
    }

    // find maximum in tree
    static int findMax(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int res = root.data;
        int lRes = findMax(root.left);
        int rRes = findMax(root.right);

        if (res < lRes) {
            res = lRes;
        }
        if (res < rRes) {
            res = rRes;
        }

        return res;
    }
  public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(2);
      root.right = new Node(3);
      root.left.left = new Node(4);
      root.left.right = new Node(5);
      root.left.right.left = new Node(6);

      System.out.println(" Print Level order : ");
      printLevel(root);

      System.out.println();
      System.out.println(" Size of tree : "+ size(root));
      System.out.println(" Size of tree : "+ sizeByLevel(root));

      System.out.println();
      System.out.println(" Minimum in tree : "+ findMin(root));
      System.out.println(" Maximum in tree : "+ findMax(root));
  }  
}
