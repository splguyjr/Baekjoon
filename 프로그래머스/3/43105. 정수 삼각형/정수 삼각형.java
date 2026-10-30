class Solution {
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        dp = new int[n + 1][n + 1];
        dp[1][1] = triangle[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) continue;
                int num = triangle[i-1][j-1];
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        return ans;
    }
}