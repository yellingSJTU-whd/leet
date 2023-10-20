package com.leetcode.q234.hash;

class Solution {
    public boolean isPalindrome(ListNode head) {
        long seed = (long) 1e9 + 7;
        long hash0 = 0, hash1 = 0, order = 1;
        while (head != null) {
            hash0 = hash0 * seed + head.val;
            hash1 = hash1 + head.val * order;
            order *= seed;
            head = head.next;
        }
        return hash0 == hash1;
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
