import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int x, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (computers[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
            }   
        }
    }
}