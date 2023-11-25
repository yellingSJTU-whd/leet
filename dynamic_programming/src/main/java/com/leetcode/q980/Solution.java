package com.leetcode.q980;

class Solution {
    int n, m;

    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        var found = false;
        int row = 0, col = 0, zeros = 0;

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < m; j++) {
                var curr = grid[i][j];
                if (curr == 0) {
                    zeros++;
                }
                if (!found && curr == 1) {
                    row = i;
                    col = j;
                    found = true;
                }
            }
        }
        return dfs(grid, row, col, zeros);
    }

    private int dfs(int[][] grid, int i, int j, int zero) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] < 0) {
            return 0;
        }

        var curr = grid[i][j];
        if (curr == 2) {
            return zero == 0 ? 1 : 0;
        }
        int remaining = curr == 1 ? zero : zero - 1, res;
        grid[i][j] = -1;
        res = dfs(grid, i, j - 1, remaining)
                + dfs(grid, i, j + 1, remaining)
                + dfs(grid, i - 1, j, remaining)
                + dfs(grid, i + 1, j, remaining);
        grid[i][j] = 0;
        return res;
    }
}
