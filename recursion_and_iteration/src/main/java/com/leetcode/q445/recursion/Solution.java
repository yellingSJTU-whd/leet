package com.leetcode.q445.recursion;

import com.leetcode.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(addTwoLists(reverseList(l1), reverseList(l2), 0));
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    private ListNode addTwoLists(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }
        if (l1 == null) {
            l1 = l2;
            l2 = null;
        }
        if (l2 == null && carry == 0) {
            return l1;
        }

        carry += l1.val + (l2 == null ? 0 : l2.val);
        l1.val = carry % 10;
        l1.next = addTwoLists(l1.next, (l2 == null ? null : l2.next), carry / 10);
        return l1;
    }

}

