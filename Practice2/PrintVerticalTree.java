package Practice2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintVerticalTree {
    // Vertical Order Traversal

        static class Node {
            int data;
            Node left, right;

            Node(int val) {
                data = val;
                left = right = null;
            }
        }
  
        static void printVertical(Node root){
            if (root == null) {
                return;
            }
            
            class Pair{
                Node node;
                int hd;
                Pair(Node n, int h){
                    node = n;
                    hd = h;
                }
            }
            Map<Integer, List<Integer>> mp = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            
            q.add(new Pair(root, 0));

            while (!q.isEmpty()) {
                Pair p = q.poll();
                Node curr = p.node;
                int hd = p.hd;

                mp.putIfAbsent(hd, new ArrayList<>());
                mp.get(hd).add(curr.data);

                if (curr.left != null) {
                    q.add(new Pair(curr.left, hd-1));
                }

                if (curr.right != null) {
                    q.add(new Pair(curr.right, hd+1));
                }

            }

            // print column wise
            for(List<Integer> cl : mp.values()){
                System.out.print(cl + " ");
            }
        }

        public static void main(String[] args) {
            /*
             *    1
             *   / \
             *  2  3
             * / \ / \
             * 4 5 6 7
             * 
             *  Vertical order :
             *       Column -2: [4]
             *       Column -1: [2]
             *       Column 0: [1, 5, 6]
             *       Column 1: [3]
             *       Column 2: [7]
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

            System.out.println(" Vertical order : ");
            System.out.println();
            printVertical(root);

        }
    }


