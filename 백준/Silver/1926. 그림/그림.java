import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int count = 0;
    static int maxArea = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        map[a][b] = 2;
        q.offer(new int[]{a, b});

        int space = 1;
        maxArea = Math.max(maxArea, space);

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isInRange(nx, ny)) continue;

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    maxArea = Math.max(maxArea, ++space);
                }
            }
        }
    }

    private static void checkMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    count++;
                }
            }
        }
    }

    private static void printAnswer() {
        System.out.println(count);
        System.out.println(maxArea);
    }

    private static void solution() throws IOException {
        readInput();
        checkMap();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}