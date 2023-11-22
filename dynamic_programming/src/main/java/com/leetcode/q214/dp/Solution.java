package com.leetcode.q214.dp;

class Solution {
    public String shortestPalindrome(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] s = str.toCharArray();
        int idx = 0, n = s.length;
        for (int i = n - 1; i > 0; i--) {
            if (isPalindrome(s, i)) {
                idx = i;
                break;
            }
        }
        if (idx == n - 1) {
            return str;
        }
        var builder = new StringBuilder();
        for (int i = n - 1; i > idx; i--) {
            builder.append(s[i]);
        }
        return builder + str;
    }

    private static boolean isPalindrome(char[] s, int r) {
        int l = 0;
        while (l <= r) {
            if (s[l++] != s[r--]) {
                return false;
            }
        }
        return true;
    }
}
