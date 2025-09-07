package Practice2;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VieweOfTree {
    static class Node{
        int data;
        Node left, right;

        Node(int val){
            data = val;
            left = right = null;
        }
    }

    // left left view of tree
    static void printLeftView(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            // traverse each level and print first element i=0
            for(int i=0; i<size; i++){
                Node curr = q.poll();

                // print first element
                if (i == 0) {
                    System.out.print(curr.data + " ");
                }

                // add left
                if (curr.left != null) {
                    q.add(curr.left);
                }
                // add right
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // right views
    static void printRightView(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            // traverse each level and print first element i=0
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // print first element
                if (i == size-1) {
                    System.out.print(curr.data + " ");
                }

                // add left
                if (curr.left != null) {
                    q.add(curr.left);
                }
                // add right
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }  

    // top view print method
    static void printTopView(Node root){
      if (root == null) {
         return;
      }

      class Pair{
        Node node;
        int hd;
        Pair(Node n, int h){
            node = n;
            hd  = h;
        }
      }

      Queue<Pair> q = new LinkedList<>();
      Map<Integer, Integer> mp = new TreeMap<>(); // keep sorted hd

      q.add(new Pair(root, 0));

      while (!q.isEmpty()) {

        Pair p = q.poll();
        Node curr = p.node;
        int hd = p.hd;

         // store first node at each hd
         if (!mp.containsKey(hd)) {
            mp.put(hd, curr.data);
         }

         // other wise add left and right
         if (curr.left != null) {
            q.add(new Pair(curr.left, hd-1));
         }
         if (curr.right != null) {
            q.add(new Pair(curr.right, hd+1));
         }
      }

      // traverse map and print
      for(int value : mp.values()){
        System.out.print(value + " ");
      }

    }
    
    public static void main(String[] args) {
        /*
         *      1
         *     / \
         *    2   3
         *  / \  / \
         * 4  5 6   7
         * 
         * left : 1 , 2 , 4
         * right : 1 , 3 , 7
         * top : 4, 2, 1, 3, 7
         * bottom : 4, 2, 6, 3, 7
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(" Left view answer : ");
        printLeftView(root);
        
        System.out.println();
        System.out.println(" Right vies of tree answer : ");
        printRightView(root);


        System.out.println();
        System.out.println(" Print top Views of tree : ");
        printTopView(root);


    }
}
