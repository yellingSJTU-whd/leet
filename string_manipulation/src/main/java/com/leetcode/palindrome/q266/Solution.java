package com.leetcode.palindrome.q266;

class Solution {
    public boolean canPermutePalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        var s = str.toCharArray();
        var freq = new int[26];
        for (var c : s) {
            freq[c - 'a']++;
        }

        int count = 0;
        for (var i : freq) {
            if (i % 2 == 0) {
                continue;
            }
            if (count++ == 1) {
                return false;
            }
        }
        return true;
    }
}
