/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null) return false;
        if(q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left = invertTree(root.left);
        return isSameTree(root.left,root.right);
        
    }
}