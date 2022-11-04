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
    public ListNode rotateRight(ListNode head, int k) {
        int n= size(head);
        if(n==0||k%n==0) return head;
        ListNode temp = head;
        k%=n;
        int ind = n-k;
        while(--ind>0){
            temp = temp.next;
        }
        //System.out.println(temp.val);
        ListNode nn = temp.next;
        temp.next=  null;
        ListNode newHead =nn;
        while(nn.next!=null){
            nn = nn.next;
        }
       // System.out.println(nn.val);
        nn.next= head;
        return newHead;
    }
    int size(ListNode head){
        ListNode temp =head;
        int len =0;
        while(temp!=null){
            len++;
            temp= temp.next;
        }
        return len;
    }
}