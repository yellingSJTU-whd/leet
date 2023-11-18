package com.leetcode.palindrome.q125;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (right > left) {
            char ch0 = s.charAt(left), ch1 = s.charAt(right);

            if ('A' <= ch0 && ch0 <= 'Z') {
                ch0 += 32;
            } else if (!('0' <= ch0 && ch0 <= '9' || 'a' <= ch0 && ch0 <= 'z')) {
                left++;
                continue;
            }

            if ('A' <= ch1 && ch1 <= 'Z') {
                ch1 += 32;
            } else if (!('0' <= ch1 && ch1 <= '9' || 'a' <= ch1 && ch1 <= 'z')) {
                right--;
                continue;
            }
            if (ch0 != ch1) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
