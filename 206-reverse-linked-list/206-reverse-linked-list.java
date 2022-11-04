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
    ListNode tail;
    public ListNode reverseList(ListNode head) {
        tail = null;
        return rev(head);
    }
    ListNode rev(ListNode curr){
        if(curr==null||curr.next==null) return tail = curr;
        ListNode head = rev(curr.next);
        curr.next=  null;
        tail.next = curr;
        tail =curr;
        return head;
    }
}