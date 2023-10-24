package com.leetcode.q718;

class Solution {
    int[] nums1, nums2;
    int alen, blen;

    public int findLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.alen = nums1.length;
        this.blen = nums2.length;
        int res = -1;

        for (int i = 0; i < blen; i++) {
            res = Math.max(res, maxLength(0, i));
        }
        for (int i = 0; i < alen; i++) {
            res = Math.max(res, maxLength(i, 0));
        }
        return res;
    }

    private int maxLength(int i, int j) {
        int res = 0, curr = 0;
        while (i < alen && j < blen) {
            if (nums1[i] == nums2[j]) {
                res = Math.max(res, ++curr);
            } else {
                curr = 0;
            }
            i++;
            j++;
        }
        return res;
    }
}
