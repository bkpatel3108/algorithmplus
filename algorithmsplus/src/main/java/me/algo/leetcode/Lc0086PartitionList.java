package me.algo.leetcode;

public class Lc0086PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode smallCurr = smallHead;
        ListNode bigCurr = bigHead;
        
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                smallCurr.next = new ListNode(curr.val);
                smallCurr = smallCurr.next;
            }else{
                bigCurr.next = new ListNode(curr.val);
                bigCurr = bigCurr.next;
            }
            curr = curr.next;
        }
        
        smallCurr.next = bigHead.next;
        return smallHead.next;
    }
}
