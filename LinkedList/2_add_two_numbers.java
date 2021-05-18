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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;
        int value = 0;
        int count = 0;
        ListNode curr = null;
        ListNode head = null;

        while (p != null || q != null || carry != 0) {
            if (p == null && q == null) {
                value = carry;
            } else if (p == null) {
                value = q.val + carry;
            } else if (q == null) {
                value = p.val + carry;
            } else {
                value = p.val + q.val + carry;
            }

            if (value >= 10) {
                carry = 1;
            }
            value = value % 10;

            if (count == 0) {
                curr = new ListNode(value);
                head = curr;
            } else {
                curr.next = new ListNode(value);
                curr = curr.next;
            }
            count++;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        return head;
    }
}