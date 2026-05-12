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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode previous = null;
        ListNode current = head;
        int numberOfNodes = 0;
                
        while (current != null) {
            current = current.next;
            numberOfNodes++;
        }
        current = head;
        
        int nodesToTraverse = numberOfNodes - n; // zeroth indexed
        for (int i = 0; i < nodesToTraverse; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        current.next = null;
        
        return head;
    }
}
