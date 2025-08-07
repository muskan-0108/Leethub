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
    public TreeNode bstrec(int[] nums,int low,int hi){
        if(low>hi) return null;
        int mid=(low+hi)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bstrec(nums,low,mid-1);
        root.right=bstrec(nums,mid+1,hi);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstrec(nums,0,nums.length-1);
        
    }
}