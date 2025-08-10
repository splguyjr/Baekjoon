import java.util.*;

class Solution {
    static class Node {
        int cost;
        int x;
        int y;

        public Node(int cost, int x, int y) {
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public int solution(int[][] land, int height) {
        int n = land.length;
        int totalCost = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new Node(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            
            if (visited[x][y]) continue;
            
            totalCost += cur.cost;
            visited[x][y] = true;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                
                int heightGap = Math.abs(land[x][y] - land[nx][ny]);
                if (heightGap <= height) {
                    pq.offer(new Node(0, nx, ny));
                } else {
                    pq.offer(new Node(heightGap, nx, ny));
                }
            }
        }
        return totalCost;
    }
}