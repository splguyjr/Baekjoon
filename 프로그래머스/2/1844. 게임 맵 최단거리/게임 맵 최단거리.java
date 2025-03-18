import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] visited;
    static Queue<Point> q;
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];

        return bfs(maps, 0, 0);

    }
    
    public int bfs(int[][] maps, int startX, int startY) {
        q = new LinkedList<>();
        q.offer(new Point(startX, startY));
        visited[startX][startY] = 1;   
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            
            if (x == maps.length - 1 && y == maps[0].length - 1) return visited[x][y];
            
            for (int i = 0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if (visited[nx][ny] != 0 || maps[nx][ny] == 0) continue;
                else {
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        return -1;
    }
}