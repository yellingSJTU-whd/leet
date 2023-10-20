package com.leetcode.palindrome.q680;

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        return doValid(s, 0, s.length() - 1, false);
    }

    private boolean doValid(String s, int i, int j, boolean skipped) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return !skipped && (doValid(s, i + 1, j, true) || doValid(s, i, j - 1, true));
            }
        }
        return true;
    }
}


