class Solution {
    public void merge(List<Integer> a1,List<Integer> a2,List<Integer> ans){
        int i=0,j=0;
        while(i<a1.size() && j<a2.size()){
            if(a1.get(i)>a2.get(j)){
                ans.add(a2.get(j));
                j++;
            }else{
                ans.add(a1.get(i));
                i++;
            }
        }
        if(i==a1.size()){
            while(j<a2.size()){
                ans.add(a2.get(j));
                j++;
            }
        }
        if(j==a2.size()){
            while(i<a1.size()){
                ans.add(a1.get(i));
                i++;
            }
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //sort both bst by morris traversal:inorder
        List<Integer> a1 = new ArrayList<>();
        TreeNode curr=root1;
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
                    a1.add(curr.val);
                    curr=curr.right;

                }
            }
            else{//curr.left=null no pred
                a1.add(curr.val);
                curr=curr.right;
            }
        }
        //root2 same copy paste of root1
        List<Integer> a2 = new ArrayList<>();
        curr=root2;
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
                    a2.add(curr.val);
                    curr=curr.right;

                }
            }
            else{//curr.left=null no pred
                a2.add(curr.val);
                curr=curr.right;
            }
        }
        List<Integer> ans = new ArrayList<>();
        merge(a1,a2,ans);
        return ans;
        
    }
}