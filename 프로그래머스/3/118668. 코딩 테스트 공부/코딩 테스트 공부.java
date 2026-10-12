import java.util.*;

class Solution {
    
    static int[][] dp;  // alp, cop 문제를 풀기 위해 필요한 최소 비용, 앞에서부터 순회해야 중복으로 가능
    
    public int solution(int alp, int cop, int[][] problems) {
         // 1. 목표치 = 모든 문제를 풀 수 있는 최소 능력
        int maxA = 0, maxC = 0;
        for (int[] p : problems) {
            maxA = Math.max(maxA, p[0]);
            maxC = Math.max(maxC, p[1]);
        }
        
        // 2. 시작 능력이 이미 목표를 넘을 수 있으니 눌러줌
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        
        dp = new int[maxA + 1][maxC + 1];
        int n = problems.length;
        
        // 초기 배열 초기화 
    
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        
        //초기 값이 alp, cop에서 시작
        dp[alp][cop] = 0;
            
        for (int i = alp; i <= maxA; i++) {
            for (int j = cop; j <= maxC; j++) {
                int cur = dp[i][j];
                
                if (i < maxA) dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if (j < maxC) dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for (int[] p : problems) {
                    int areq = p[0];
                    int creq = p[1];
                    int arwd = p[2];
                    int crwd = p[3];
                    int cost = p[4];
                    
                    if (i < areq || j < creq) continue;
                    int na = Math.min(maxA, i + arwd);
                    int nc = Math.min(maxC, j + crwd);
                    dp[na][nc] = Math.min(dp[na][nc], dp[i][j] + cost);
                }
            }
        }
        
        return dp[maxA][maxC];
    }
}