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
    static TreeNode prev=null;
    static int mindiff = Integer.MAX_VALUE;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            int diff = Math.abs(root.val-prev.val);
            mindiff = Math.min(diff,mindiff);
        }
        prev=root;
        inorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        //multiple test case k liye global variable baar baar update nhi hote
        prev=null;
        mindiff=Integer.MAX_VALUE;
        inorder(root);
        return mindiff;
    }
}