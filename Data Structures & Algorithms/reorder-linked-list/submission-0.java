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
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

   
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
 
    ListNode secondHead = slow.next;
    slow.next = null; 
    ListNode prev = null;
    ListNode current = secondHead;
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    secondHead = prev; 
    ListNode firstHead = head;
    while (secondHead != null) {
        ListNode temp1 = firstHead.next;
        ListNode temp2 = secondHead.next;

        firstHead.next = secondHead;
        secondHead.next = temp1;

        firstHead = temp1;
        secondHead = temp2;
    }
}
}
