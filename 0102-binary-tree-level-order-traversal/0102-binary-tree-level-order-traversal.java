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
    public int ht(TreeNode root){
        if(root==null || root.left==null && root.right==null) return 0;
        return 1+Math.max(ht(root.left),ht(root.right));
    }
    public void nthnode1(TreeNode root,int n,List<Integer> ans){//left to right
        if(root==null) return;
        if(n==1){
            ans.add(root.val);
            return;
        }
        nthnode1(root.left,n-1,ans);
        nthnode1(root.right,n-1,ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> Fans = new ArrayList<>();
        if(root==null) return Fans;
        int level = ht(root)+1;//ht(root) is for edge
        for(int i=1;i<=level;i++){
            List<Integer> ans = new ArrayList<>();
                nthnode1(root,i,ans);
            Fans.add(ans);
        }
        return Fans;

        
    }
}