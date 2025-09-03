package practice1;

import java.util.LinkedList;
import java.util.Queue;


public class InsertionTree {

    static class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

        TreeNode(int val){
        this.val = val;
        }
    }


    public static TreeNode insert(TreeNode root, int key){
        if (root == null) {
            return new TreeNode(key);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // left is null position find first
            if(curr.left == null){
                curr.left = new TreeNode(key);
                return root; // insertion complete
            }else{
                q.add(curr.left);
            }

            // right is null position
            if(curr.right == null){
                curr.right = new TreeNode(key);
                return root; // insert complete
            }else{
                q.add(curr.right);
            }

        }
        return root;
    }

    public static void traversal(TreeNode root){
       if(root == null){
        return;
       }
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);

       while (!q.isEmpty()) {
           TreeNode curr = q.poll();
           System.out.print(" "+ curr.val);

           if(curr.left != null){
             q.add(curr.left);
           }

           if(curr.right != null){
             q.add(curr.right);
           }
       }
       System.out.println();
       
    }
    public static void main(String[] args) {
      TreeNode root = new TreeNode(10);
      root.left = new TreeNode(20);
      root.right = new TreeNode(30);
      root.left.left = new TreeNode(40);

      traversal(root);

      insert(root, 50);
      traversal(root);

    }
}
