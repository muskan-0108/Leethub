class Solution { 
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;   // first swap ke baad yeh new head hoga
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && curr.next != null) 
        {
            ListNode nexty = curr.next;
            ListNode nextPair = nexty.next;

            // swap
            nexty.next = curr;
            if (prev != null) prev.next = nexty;
            curr.next = nextPair;

            // move pointers
            prev = curr;
            curr = nextPair;
        }
        return newHead;  
    }
}