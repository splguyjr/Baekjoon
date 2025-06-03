import java.util.*;

class Solution {

    static class Node {
        int x, y, cost, dir;

        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4]; // 방향별 최소 비용 저장
        for (int[][] layer : cost)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MAX_VALUE);

        // 방향: 상(0), 하(1), 좌(2), 우(3)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();

        // 시작점에서 네 방향 시도
        for (int dir = 0; dir < 4; dir++) {
            cost[0][0][dir] = 0;
            q.offer(new Node(0, 0, 0, dir));
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] == 1) continue;

                int newCost = cur.cost + (cur.dir == d ? 100 : 600);

                if (cost[nx][ny][d] > newCost) {
                    cost[nx][ny][d] = newCost;
                    q.offer(new Node(nx, ny, newCost, d));
                }
            }
        }

        // 도착점 (N-1,N-1)의 네 방향 중 최소 비용 반환
        return Arrays.stream(cost[N-1][N-1]).min().getAsInt();
    }
}
