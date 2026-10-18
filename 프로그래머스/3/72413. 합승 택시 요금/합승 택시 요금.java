import java.util.*;

class Solution {
    static int[][] dist;
    static int INF = (int)1e7;
    
    private static void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) dist[i][j] = INF;   
            }
        }
        
        for (int[] edge : fares) {
            int c = edge[0];
            int d = edge[1];
            int f = edge[2];
            
            dist[c][d] = f;
            dist[d][c] = f;
        }
        
        floyd(n);
        
        int answer = INF;
        // 중간 점 아무거나 잡고 (시작점 -> 중간점 거리) + (중간점 -> A, B까지의 거리 합) 최소값 갱신하기
        for (int i = 1; i <= n; i++) {
            int dist_s_m = dist[s][i];
            int dist_m_a = dist[i][a];
            int dist_m_b = dist[i][b];
            
            answer = Math.min(answer, dist_s_m + dist_m_a + dist_m_b);
        }
        
        return answer;
    }
}