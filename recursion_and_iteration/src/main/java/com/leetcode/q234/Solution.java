package com.leetcode.q234;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head, slow = head, lastSlow = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = lastSlow;
            lastSlow = slow;
            slow = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (lastSlow == null) {
                return false;
            }
            if (slow.val != lastSlow.val) {
                return false;
            }
            slow = slow.next;
            lastSlow = lastSlow.next;
        }
        return true;
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
