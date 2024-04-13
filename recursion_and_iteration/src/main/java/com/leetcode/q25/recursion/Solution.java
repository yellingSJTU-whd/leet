package com.leetcode.q25.recursion;

import com.leetcode.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverseBetween(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverseBetween(ListNode head, ListNode tail) {
        ListNode pre = null, next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

