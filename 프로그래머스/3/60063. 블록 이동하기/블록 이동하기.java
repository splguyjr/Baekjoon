import java.util.*;

class Solution {
    
    static boolean[][][] visited; // x, y, (좌우, 상하)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    
    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][2];
        visited[0][0][0] = true;
        
        // x, y, dir(0, 1), 비용
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];
            int x2 = x + dir;
            int y2 = y + (1 - dir);
            int cost = cur[3];
            
            if ((x == n - 1 && y == n - 1) || (x2 == n - 1 && y2 == n - 1)) return cost;
            
            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                int nx2 = x2 + dx[i], ny2 = y2 + dy[i];
                if (isInRange(nx, ny) && isInRange(nx2, ny2)) {
                    if (board[nx][ny] == 0 && board[nx2][ny2] == 0) {
                        if (visited[nx][ny][dir]) continue;
                        q.add(new int[] {nx, ny, dir, cost + 1});
                        visited[nx][ny][dir] = true;
                    }
                }
            }
            
            // 가로일 때 세로상태로 회전시도
            if (dir == 0) {
                for (int s = -1; s <= 1; s += 2) {
                    if (isInRange(x + s, y) && isInRange(x + s, y + 1)) {
                        if (board[x+s][y] == 0 && board[x+s][y+1] == 0) {
                            int top = Math.min(x, x+s);
                            if (!visited[top][y][1]) {
                                q.add(new int[] {top, y, 1, cost + 1});
                                visited[top][y][1] = true;
                            }                       
                            if (!visited[top][y+1][1]) {
                                q.add(new int[] {top, y+1, 1, cost + 1});
                                visited[top][y+1][1] = true;
                            }
                        }   
                    }    
                }
            }
            else {
                // 세로 (x,y),(x+1,y) → 왼쪽(s=-1)/오른쪽(s=+1)으로 회전
                for (int s = -1; s <= 1; s += 2) {
                    int cy = y + s;
                    if (isInRange(x, cy) && isInRange(x + 1, cy)
                            && board[x][cy] == 0 && board[x + 1][cy] == 0) {
                        int left = Math.min(y, cy);
                        if (!visited[x][left][0]) {          // 위 칸 축 → x행에 가로로 누움
                            visited[x][left][0] = true;
                            q.add(new int[]{x, left, 0, cost + 1});
                        }
                        if (!visited[x + 1][left][0]) {      // 아래 칸 축 → x+1행에 가로로 누움
                            visited[x + 1][left][0] = true;
                            q.add(new int[]{x + 1, left, 0, cost + 1});
                        }
                    }
                }
            }
        }
        return - 1;
    }
}