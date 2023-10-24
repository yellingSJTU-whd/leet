package com.leetcode.q340;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int[] present = new int[128];
        int count = 0, ans = 0, l = 0, r = 0;
        char[] chs = s.toCharArray();
        while (r < chs.length) {
            if (present[chs[r++]]++ == 0) {
                count++;
            }
            if (count <= k) {
                ans = Math.max(ans, r - l);
            }
            while (count > k) {
                if (--present[chs[l++]] == 0) {
                    count--;
                }
            }
        }
        return ans;
    }
}