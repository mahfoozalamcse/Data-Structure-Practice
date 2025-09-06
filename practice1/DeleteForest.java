package practice1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Delete nodes and return Forest (LeetCode 1110)
public class DeleteForest {
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static Node root;
    static List<Node> delNode(Node root, int []to_delete){
        Set<Integer> del = new HashSet<>();
        for(int element : to_delete){
            del.add(element);
        }

        List<Node> forest = new ArrayList<>();
        helper(root, true, del, forest);

        return forest;

    }

    static Node helper(Node root, boolean isRoot, Set<Integer> del, List<Node> forest){
      if (root == null) {
         return null;
      }
      boolean deleted = del.contains(root.data);

      root.left = helper(root.left, deleted, del, forest);
      root.right = helper(root.right, deleted, del, forest);

      if (isRoot && !deleted) {
         forest.add(root);

      }

      return deleted ? null : root;
    }

    static void inorder(Node root){
        if (root != null) {
            inorder(root.left);
            System.out.print(" "+ root.data);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        
        int[] to_delete = { 3, 5 };

        List<Node> forest = delNode(root, to_delete);

        // Print each tree in the forest (inorder traversal)
        int idx = 1;
        for (Node tree : forest) {
            System.out.print("Tree " + idx++ + " inorder: ");
            inorder(tree);
            System.out.println();
        } 

    }
    
}
