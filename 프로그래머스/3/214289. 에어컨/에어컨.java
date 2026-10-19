import java.util.*;

class Solution {
    
    static int[][] dp; // n분 시점에 t 온도 상태이기 위한 최소전력, 온도는 -10 ~ 40 -> 1 ~ 51
    static int INF = (int) 1e6;
    static int OFFSET = 11;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int n = onboard.length - 1;
        dp = new int[n + 1][53];
        
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], INF);
        
        dp[0][temperature + OFFSET] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 51; j++) {
                if (onboard[i] == 1 && ((t1 + OFFSET) > j || (t2 + OFFSET) < j)) {
                    continue;
                }
                
                // 꺼진 상태로 도달한 경우
                // temp와 j의 값을 비교 -> temp > j면 dp[i-1][j-1]
                // temp < j면 dp[i-1][j+1]
                // temp == j 면 dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1]
                int off = INF;
                if (temperature + OFFSET > j) off = dp[i-1][j-1];
                else if (temperature + OFFSET < j) off = dp[i-1][j+1];
                else {
                    off = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
                }
                    
                dp[i][j] = Arrays.stream(new int[] {
                    off, dp[i-1][j+1] + a, dp[i-1][j-1] + a, dp[i-1][j] + b
                }).min().getAsInt();
            }
        }
        
        int answer = Arrays.stream(dp[n]).min().getAsInt();
        
        return answer;
    }
}