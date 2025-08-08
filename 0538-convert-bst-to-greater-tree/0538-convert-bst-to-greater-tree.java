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
 //tc=O(n) sc=O(h)
class Solution {
    int sum=0;//global variable
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.right);//ulta inorder
        root.val=root.val+sum;
        sum=root.val;
        helper(root.left);

    }
    public TreeNode convertBST(TreeNode root) {
        sum=0;
        helper(root);
        return root;
        
    }
}