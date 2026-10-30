class Solution {
    static int[][] dp;
    static final int MOD = 1000000007;

    private static boolean check(int a, int b, int[][] puddles) {
        for (int[] arr : puddles) {
            int a1 = arr[0];
            int b1 = arr[1];
            if (a == b1 && b == a1) return true;
        }
        return false;
    }
    
    public int solution(int m, int n, int[][] puddles) {
        dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= m; j++) {
                if (check(i, j, puddles)) continue;
                if (i == 1 && j == 1) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }
        return dp[n][m];
    }
}