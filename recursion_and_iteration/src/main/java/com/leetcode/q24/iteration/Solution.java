package com.leetcode.q24.iteration;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        while (head != null && head.next != null) {
            ListNode left = head, right = head.next;
            pre.next = right;
            left.next = right.next;
            right.next = left;

            pre = left;
            head = left.next;
        }
        pre.next = head;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}