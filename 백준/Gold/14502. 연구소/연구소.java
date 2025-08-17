import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Node> q = new LinkedList<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int answer = 0;

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int calSafe(int[][] arr) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void bfs() {
        int[][] map_copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            map_copy[i] = map[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map_copy[i][j] == 2) {
                    q.offer(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                else if (map_copy[nx][ny] == 1 || map_copy[nx][ny] == 2) continue;
                else {
                    map_copy[nx][ny] = 2;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        answer = Math.max(answer, calSafe(map_copy));
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    depth++;
                    map[i][j] = 1;
                    dfs(depth);
                    map[i][j] = 0;
                    depth--;
                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        dfs(0);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}