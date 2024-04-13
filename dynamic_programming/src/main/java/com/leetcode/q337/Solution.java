package com.leetcode.q337;

class Solution {
    public int rob(TreeNode root) {
        var candidates = dfs(root);
        return Math.max(candidates[0], candidates[1]);
    }

    private int[] dfs(TreeNode root) {
        var res = new int[2];
        if (root == null) return res;
        
        var left = dfs(root.left);
        var right = dfs(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
