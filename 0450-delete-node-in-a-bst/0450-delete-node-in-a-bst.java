class Solution {
    public void delete(TreeNode root, int key) {
        if(root==null) return;
        if(root.val>key){//left
            if(root.left==null) return;
            if(root.left.val==key){
            TreeNode l = root.left;//treenode which i wish to delete
                if(l.left==null && l.right==null){//0 child
                root.left=null;
                }
                else if(l.left==null || l.right==null){//1 child
                    if(l.left!=null) root.left=l.left;
                    else root.left=l.right;
                }else{
                    TreeNode pred = l.left;//2 child
                    while(pred.right!=null) pred=pred.right;
                    delete(root,pred.val);
                    pred.left=l.left;
                    pred.right=l.right;
                    root.left=pred;
                }
            }
            else delete(root.left,key);
        }else{
            //right
            if(root.right==null) return;
            if(root.right.val==key){
                TreeNode r = root.right;//treenode which i wish to delete
                if(r.left==null && r.right==null){//0 child
                root.right=null;
                }
                else if(r.left==null || r.right==null){//1 child
                    if(r.left!=null) root.right=r.left;
                    else root.right=r.right;
                }
                else{
                    TreeNode pred = r.left;//2 child
                    while(pred.right!=null) pred=pred.right;
                    delete(root,pred.val);
                    pred.left=r.left;
                    pred.right=r.right;
                    root.right=pred;
                }
            }
            else delete(root.right,key);
        }
    }    
    public TreeNode deleteNode(TreeNode root, int key){
        TreeNode temp=new TreeNode(Integer.MAX_VALUE);
        temp.left=root;
        delete(temp,key);
        return temp.left;
    }
}