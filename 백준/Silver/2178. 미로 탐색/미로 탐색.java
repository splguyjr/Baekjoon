import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {


    static int n, m;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] visit;
    static int[][] map;
    static Queue<Coordinate> q = new LinkedList<>();
    static int count = 0;
    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        // 주어진 미로 정보 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int a, int b) {
        visit[a][b] = 1;
        q.offer(new Coordinate(a, b));

        while (!q.isEmpty()) {
            Coordinate poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                    if (visit[nx][ny] == 0 && map[nx][ny] == 1) {
                        visit[nx][ny] = visit[x][y] + 1;
                        if(nx == n - 1 && ny == m - 1) {
                            return visit[nx][ny];
                        }
                        q.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }

        return -1;
    }
}
