/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int carry = 0;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        ListNode ans = null;
        ListNode ansPointer = null;
        while (l1Pointer != null && l2Pointer != null) {
            int sum = carry + l1Pointer.val + l2Pointer.val;
            carry = sum / 10;
            int result = sum % 10;
            if (ans == null) {
                ans = new ListNode(result);
                ansPointer = ans;
            } else {
                ansPointer.next = new ListNode(result);
                ansPointer = ansPointer.next;
            }
            l1Pointer = l1Pointer.next;
            l2Pointer = l2Pointer.next;
        }
        if (l1Pointer == null && l2Pointer != null) {
            while (l2Pointer != null) {
                int sum = carry + l2Pointer.val;
                carry = sum / 10;
                int result = sum % 10;
                ansPointer.next = new ListNode(result);
                ansPointer = ansPointer.next;
                l2Pointer = l2Pointer.next;
            }

        } else if (l1Pointer != null && l2Pointer == null) {
            while (l1Pointer != null) {
                int sum = carry + l1Pointer.val;
                carry = sum / 10;
                int result = sum % 10;
                ansPointer.next = new ListNode(result);
                ansPointer = ansPointer.next;
                l1Pointer = l1Pointer.next;
            }
        }
        if (carry != 0) {
            ansPointer.next = new ListNode(carry);
        }
        return ans;
    }
}
