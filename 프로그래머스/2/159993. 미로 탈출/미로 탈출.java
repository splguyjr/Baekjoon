import java.util.*;

class Solution {
    
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        
        // map 초기화 및 위치 파악
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }
        
         // S → L
        int toLever = bfs(startX, startY, 'L');
        if (toLever == -1) return -1;

        // L → E
        int toExit = bfs(leverX, leverY, 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }
    
     private int bfs(int x, int y, char target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            if (map[cx][cy] == target) return dist;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1; // 도달 불가능
    }
}