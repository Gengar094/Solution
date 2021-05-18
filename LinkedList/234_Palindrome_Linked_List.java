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

// test case [1,2] fails
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        ListNode tail = reverse(mid);
        // 注意长度奇偶，偶数时如果没有第二个条件，则会交错继续进行，直到报错
        while (head != tail && head.next != tail) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        // prev 为null，照顾初始节点
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 返回 prev，不是curr，因为curr这时候是null
        return prev;
    }
}