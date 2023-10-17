package com.leetcode.q445.iteration;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(addTwoLists(reverseList(l1), reverseList(l2)));
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private ListNode addTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
            }
            if (l2 != null) {
                carry += l2.val;
            }
            curr = curr.next = new ListNode(carry % 10);
            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
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