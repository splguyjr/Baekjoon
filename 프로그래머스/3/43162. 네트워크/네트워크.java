import java.util.*;

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer++;
                q.offer(i);
            }
            
            while (!q.isEmpty()) {
                int cur = q.poll();
                
                for (int j = 0; j < n; j++) {
                    if (computers[cur][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        
        return answer;
    }
    

}