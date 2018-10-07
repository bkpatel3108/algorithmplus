package me.algo.leetcode;

public class Lc0025ReverseNodesinkGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        head = curr;
        
        while(curr != null && curr.next != null){
            ListNode start = curr.next;
            ListNode end = start;
            
            int i = 0;
            while(i++ < k-1 && end != null){
                end = end.next;
            }
            
            if(end == null)
                return head.next;

            ListNode endNext = end.next;
            reverse(start, end);
            curr.next = end;
            start.next = endNext;
            curr = start;  
        }
        
        return head.next;
    }
    
     void reverse(ListNode start, ListNode end) {
         ListNode endNext = end.next;
         ListNode prev = null;
         ListNode curr = start;
         while(curr != endNext){
             ListNode next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
         }
     }
}
