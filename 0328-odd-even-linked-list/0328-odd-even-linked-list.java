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
            ListNode nextNode = temp.next;
            temp.next = null; // as going to add in new list
            if(index%2==0){
                //odd
                otemp.next = temp;
                otemp = otemp.next;
            }else{
                etemp.next = temp;
                etemp = etemp.next;
            }
            temp = nextNode;index++;
        }
        otemp.next = even.next;
        return odd.next;
    }
}