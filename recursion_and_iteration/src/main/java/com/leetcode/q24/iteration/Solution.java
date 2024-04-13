package com.leetcode.q24.iteration;

import com.leetcode.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head), pre = dummy;
        ListNode left, right;
        while ((left = pre.next) != null && (right = left.next) != null) {
            pre.next = right;
            left.next = right.next;
            right.next = left;

            pre = left;
        }
        return dummy.next;
    }
}

