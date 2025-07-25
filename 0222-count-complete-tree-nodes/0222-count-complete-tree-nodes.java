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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int left = getleftDepth(root);
        int right = getrightDepth(root);

        if(left==right){//perfect binary tree
            return (1<<left)-1;
        }else{
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount+rightCount+1;
        }  
    }
    private int getleftDepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
    private int getrightDepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.right;
            depth++;
        }
        return depth;
    }
}