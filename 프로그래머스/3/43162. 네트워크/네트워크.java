import java.util.*;

class Solution {
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n + 1];
        
        // 처음에 방문 검사하고, 한 점과 연결된 모든 점들을 타고 bfs 다 돌리기
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                q.offer(i);
                answer++;
            }
            
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int j = 0; j < n; j++) {
                    int y = computers[x][j];
                    if (y == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        
        return answer;
    }
}