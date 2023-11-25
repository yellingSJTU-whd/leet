package com.leetcode.q63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        var dp = new int[m];
        dp[m - 1] = obstacleGrid[n - 1][m - 1] == 1 ? 0 : 1;
        for (var j = m - 2; j >= 0; j--) {
            if (obstacleGrid[n - 1][j] == 1) {
                dp[j] = 0;
            } else {
                dp[j] = dp[j + 1];
            }
        }

        for (var i = n - 2; i >= 0; i--) {
            for (var j = m - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += j == m - 1 ? 0 : dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
