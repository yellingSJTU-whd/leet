package com.leetcode.q92.iteration;

import com.leetcode.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head), guard = dummy, curr = dummy.next;
        for (var i = 0; i < left - 1; i++) {
            guard = guard.next;
            curr = curr.next;
        }

        for (var i = 0; i < right - left; i++) {
            var moving = curr.next;
            curr.next = moving.next;
            moving.next = guard.next;
            guard.next = moving;
        }
        return dummy.next;
    }
}

