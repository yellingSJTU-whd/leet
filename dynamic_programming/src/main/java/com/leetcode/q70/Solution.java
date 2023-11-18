package com.leetcode.q70;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int prePre = 1, pre = 2;
        for (int i = 3, curr; i <= n; i++) {
            curr = prePre + pre;
            prePre = pre;
            pre = curr;
        }
        return pre;
    }
}
