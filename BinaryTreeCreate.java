import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeCreate {
    // create binary tree
    public static class Node{
         int key;
         Node left;
         Node right;

         Node(int data){
            key = data;
            // here by default assign null both
            // left and right in java

         }
    }

    // traversal on tree
    // 1. inorder
    // 2. preorder
    // 3. post order

    // inorder traversal
    // time O(n), space O(h+1) where O(h) h=height

    public static void inorder(Node root){
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // pre order traverasal
    // time O(n), space O(h+1) where O(h) h=height

    public static void preOrder(Node root){
      if (root != null) {
        System.out.print(root.key+" ");
          preOrder(root.left);
          preOrder(root.right);

      }  
    }

    // post order tree traversal
    // time O(n), space O(h+1) where O(h) h=height
    
    public static void postOrder(Node root){
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+" ");
        }
    }

    public static int height(Node root){
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //print node at k distance in tree time O(n) and space O(h)

    public static void kthNode(Node root, int k){
        if (root == null)
        {
          return;
        }
        if (k == 0) {
            System.out.print(root.key+" ");
        }else{
            kthNode(root.left, k-1);
            kthNode(root.right, k-1);
        }
    }

    // level order traversal in tree
    // not efficient use 1. find height 2. k node print

    // efficient solution use Queue data structure

    // time complexity O(n) space(width)

    public static void levelOrderTraverse(Node root){
      if (root == null) {
        return;
      }
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);

      while (q.isEmpty() == false) {

         Node curr = q.poll();
         System.out.print(curr.key+" ");

         if (curr.left != null) {
            q.add(curr.left);
         }
         if (curr.right != null) {
            q.add(curr.right);
         }
      }
    }

    // size of binary tree time O(n) and space O(h)
    public static int sizeTree(Node root){
        if (root == null) {
            return 0;
        }
        return (sizeTree(root.left) + sizeTree(root.right) + 1);
    }

    // maximum in binary tree
    public static int maxNode(Node root){
        if (root == null) {
            return Integer.MIN_VALUE;
        }else{
          return Math.max(root.key,Math.max(maxNode(root.left), maxNode(root.right)));
        } 
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);

        inorder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);

        System.out.println();
        System.out.print(height(root));

        System.out.println();
        kthNode(root, 1);

        System.out.println();
        levelOrderTraverse(root);

        System.out.println();
        System.out.print(sizeTree(root)+" ");

        System.out.println();
        System.out.println(maxNode(root)+" ");
        
    }
}