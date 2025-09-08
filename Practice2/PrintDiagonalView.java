package Practice2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// public class PrintDiagonalView of tree

public class PrintDiagonalView {
    static class Node{
        int data;
        Node left, right;
        Node(int val){
            data = val;
            left = right = null;
        }
    }

    static void printDiagonal(Node root){
        if (root == null) {
            return;
        }
        class Pair{
            Node node;
            int d; // diagonal point
            Pair(Node n, int d){
                node = n;
                this.d = d;
            }
        }

        Map<Integer,List<Integer>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int d = p.d;

            mp.putIfAbsent(d, new ArrayList<>());
            mp.get(d).add(curr.data);

            // go left and add
            if (curr.left != null) {
               q.add(new Pair(curr.left, d+1));
            }

            // go right add 
            if (curr.right != null) {
                q.add(new Pair(curr.right, d));
            }
        }

        // print diagonal
        for(List<Integer> di : mp.values()){
            System.out.print(di+ " ");
        }

    }

    public static void main(String[] args) {
        /*
         *     1
         *    / \
         *   2   3
         *  / \ / \
         * 4  5 6 7
         * 
         * Diagonal value is :
         *       Diagonal 0: [1, 3, 7]
         *       Diagonal 1: [2, 5, 6]
         *       Diagonal 2: [4]
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

        System.out.println(" Print diagonal : ");
        printDiagonal(root);
  
    }
}
