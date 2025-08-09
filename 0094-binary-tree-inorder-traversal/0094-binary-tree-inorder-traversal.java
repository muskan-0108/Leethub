//morris traversal
//sc=O(1) tc=O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr=root;
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
                    ans.add(curr.val);
                    curr=curr.right;

                }
            }
            else{//curr.left=null no pred
                ans.add(curr.val);
                curr=curr.right;
            }
        }
        return ans;
    }
}