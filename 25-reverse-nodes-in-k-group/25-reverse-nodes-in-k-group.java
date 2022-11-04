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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res=  new ListNode(),ans = res,temp = head;
        int size = len(head);
        for(int i=0;i<size/k;i++){
            ListNode start = temp,last = start;
            ListNode prev=  null;
            for(int t=0;t<k;t++){
                // do reverse
                ListNode nn = last.next;
                last.next = prev;
                prev = last;
                last = nn;
            }
            res.next = prev;
            res = start;
            temp = last ;// updating temp
        }
        if(temp!=null) res.next = temp;
        return ans.next;
    }
    int len(ListNode head){
        ListNode tmp = head;
        int count=0;
        while(tmp!=null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
}