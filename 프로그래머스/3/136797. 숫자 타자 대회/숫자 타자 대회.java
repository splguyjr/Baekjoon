import java.util.*;

class Solution {
    static int[][] pad = {
        {3, 1},
        {0, 0}, {0, 1}, {0, 2}, // 1 2 3
        {1, 0}, {1, 1}, {1, 2}, // 4 5 6
        {2, 0}, {2, 1}, {2, 2} // 7 8 9
    };
    
    private static int cost(int x, int y) {
        if (x == y) return 1;
        int dx = Math.abs(pad[x][0] - pad[y][0]);
        int dy = Math.abs(pad[x][1] - pad[y][1]);
        if (dx == 0) return dy * 2;
        if (dy == 0) return dx * 2;
        return Math.min(dx, dy) * 3 + Math.abs(dx - dy) * 2;
    }
    
    public int solution(String numbers) {
        int INF = Integer.MAX_VALUE;
        int n = numbers.length();
        int[][] dp = new int[10][10];
        
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[4][6] = 0;
        
        for (char c : numbers.toCharArray()) {
            int d = c - '0';
            
            int[][] next = new int[10][10];
            for (int i = 0; i < 10; i++) {
                Arrays.fill(next[i], INF);
            }
            
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(dp[i][j] == INF) continue;
                    
                    if (j != d)
                        next[d][j] = Math.min(next[d][j], dp[i][j] + cost(i, d));
                    if (i != d)
                        next[i][d] = Math.min(next[i][d], dp[i][j] + cost(j, d));
                }
            }
            dp = next;
        }
        
        int answer = INF;
        
        for (int[] row : dp) {
            for (int x : row) {
                answer = Math.min(answer, x);
            }
        }
        
        return answer;
    }
}