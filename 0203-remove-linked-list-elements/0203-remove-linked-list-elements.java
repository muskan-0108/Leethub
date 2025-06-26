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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head;
        ListNode slow=new ListNode(100);
        slow.next=temp;
        ListNode fast=temp;
        ListNode dummy=slow;
        while(fast!=null){
        if(fast.val==val) {
            slow.next=fast.next;
            fast=fast.next;
        }else{
            slow=slow.next;
            fast=fast.next;
        }
        }
        return dummy.next;
    }
}