package practice1;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteBinaryTree {
    static class Node{
        int data;
        Node left , right;
        Node(int val){
            data = val;
            left=right=null;
        }
    }

    Node root;
    static void delete(Node root, int key){

        // when tree is empty
        if (root == null) {
            return ;
        }

        // when only root exist and left right null and root match key 
        if (root.left == null && root.right == null) {
            if(root.data == key) root = null;
            return;
            
        }

        // when internal node delete
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node target = null, last = null;

        while (!q.isEmpty()) {
             last = q.peek();  //store last element in queue which right most 
             Node temp = q.remove(); // remove first element

             if (temp.data == key) {
                 target = temp;
             }

             if (temp.left != null) {
                q.add(temp.left);
             }

             if (temp.right != null) {
                 q.add(temp.right);
             }

        }

        if (target != null) {
            int x = last.data;
            deleteDeepest(root, last);
            target.data = x;
        }
    }

    static void deleteDeepest(Node root, Node deletNode){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == deletNode) {
                temp = null;
                return;
            }
            
            if (temp.right != null) {
                if (temp.right == deletNode) {
                    temp.right = null;
                    return;
                } else {
                    q.add(temp.right);
                }
            } 

            if(temp.left != null){
                 if (temp.left == deletNode) {
                    temp.left = null;
                    return;
                 } else {
                     q.add(temp.left);
                 }
            }
        }
    }

    // level order traversal BFS
    static void traverasal(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.println(" " +temp.data);

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }
    public static void main(String[] args) {
       
       Node root = new Node(10);
       root.left = new Node(20);
       root.right = new Node(30);
       root.left.left = new Node(40);
       root.right.right = new Node(50);
       traverasal(root);
       delete(root, 10);
       System.out.println();
       traverasal(root);

    }
}
