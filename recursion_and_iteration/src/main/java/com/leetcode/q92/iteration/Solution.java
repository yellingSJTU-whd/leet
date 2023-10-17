package com.leetcode.q92.iteration;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head), ptr = dummy;
        for (int i = 0; i < left - 1; i++) {
            ptr = ptr.next;
        }
        ListNode pre = null, curr = ptr.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        ptr.next.next = curr;
        ptr.next = pre;
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
