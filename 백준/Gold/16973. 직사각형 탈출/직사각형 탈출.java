import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int h, w;
    static int sr, sc, fr, fc;
    static int[][] prefix;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = -1;

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static void readInput() throws IOException {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();

        prefix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int space = reader.nextInt();
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + space;
            }
        }

        h = reader.nextInt();
        w = reader.nextInt();
        sr = reader.nextInt();
        sc = reader.nextInt();
        fr = reader.nextInt();
        fc = reader.nextInt();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];

        q.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (x == fr && y == fc) {
                ans = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (checkRange(nx, ny) && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean checkRange(int a, int b) {
        return isInRange(a, b) && checkWall(a, b);
    }

    // a ~ a + h - 1, b ~ b + w - 1
    private static boolean isInRange(int a, int b) {
        return a > 0 && b > 0 && a + h - 1 <= n && b + w - 1 <= m;
    }

    private static boolean checkWall(int a, int b) {
        int wallCount = prefix[a + h - 1][b + w - 1] - prefix[a + h - 1][b - 1] - prefix[a - 1][b + w - 1] + prefix[a - 1][b - 1];
        return wallCount == 0;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        bfs();
        printAnswer();
    }
}
