/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        //size of ll
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        //convert ll into array
        int[] nums=new int[n];
        int i=0;
        temp=head;
        while(temp!=null){
            nums[i++]=temp.val;
            temp=temp.next;
        }
        return bstrec(nums,0,n-1);
        
    }
}