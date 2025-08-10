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
    //tc=O(n) sc=O(1)
    public void recoverTree(TreeNode root) {
        TreeNode curr=root;
        TreeNode prev=null;
        TreeNode prevp=null;
        List<TreeNode> arr = new ArrayList<>();
        while(curr!=null){
            if(curr.left!=null){//find pred
                TreeNode pred=curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){//connect pred and curr
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){//unlink pred and curr
                    pred.right=null;
                    //visit/print
                    if(prevp!=null && prev!=null){
                        if(prev.val>curr.val && prev.val>prevp.val) arr.add(prev);
                        if(prev.val<curr.val && prev.val<prevp.val) arr.add(prev);
                    }
                    else if(prev!=null && prev.val>curr.val) arr.add(prev);
                    prevp=prev;
                    prev=curr;
                    curr=curr.right;


                }
            }
            else{//curr.left=null no pred
                //visit
                if(prevp!=null && prev!=null){
                    if(prev.val>curr.val && prev.val>prevp.val) arr.add(prev);
                    if(prev.val<curr.val && prev.val<prevp.val) arr.add(prev);
                }
                else if(prev!=null && prev.val>curr.val) arr.add(prev);
                prevp=prev;
                prev=curr;
                curr=curr.right;
            }
        }
        if(prevp.val>prev.val) arr.add(prev);
        TreeNode first=arr.get(0);
        TreeNode second=arr.get(arr.size()-1);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
}