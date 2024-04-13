package com.leetcode.q25.iteration;

import com.leetcode.ListNode;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head), ptr = dummy;
        ListNode pre = null, curr = head;
        int count = 0;
        while (curr != null) {
            ListNode next = curr.next;
            if (count != 0) {
                curr.next = pre;
            }
            pre = curr;
            curr = next;

            count = (count + 1) % k;
            if (count == 0) {
                ListNode tmp = ptr.next;
                ptr.next = pre;
                ptr = tmp;
                ptr.next = curr;
            }
        }

        if (count != 0) {
            ptr.next.next = null;
            reverseList(pre);
        }
        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
    }
}

