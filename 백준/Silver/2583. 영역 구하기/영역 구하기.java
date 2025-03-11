import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N, K;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static List<Integer> answer = new ArrayList<>();

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[k][j] = true; // 직사각형 내부를 방문 처리
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(cnt);
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }

    private static void bfs(int a, int b) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(a, b));
        visited[a][b] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    cnt++;
                }
            }
        }
        answer.add(cnt);
    }
}