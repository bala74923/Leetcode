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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1),even = new ListNode(-1);
        ListNode otemp  = odd,etemp  =even;
        ListNode temp = head;
        int index = 0;
        while(temp!=null){
            if(index%2==0){
                //odd
                otemp.next = new ListNode(temp.val);
                otemp = otemp.next;
            }else{
                etemp.next = new ListNode(temp.val);
                etemp = etemp.next;
            }
            temp = temp.next;index++;
        }
        otemp.next = even.next;
        return odd.next;
    }
}