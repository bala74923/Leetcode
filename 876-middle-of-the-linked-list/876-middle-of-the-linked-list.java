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
    public ListNode middleNode(ListNode head) {
        ListNode turtle = head,fast= head;
        while(fast!=null && fast.next!=null){
            turtle  = turtle.next;
            fast = fast.next.next;
        }
        return turtle;
    }
}