import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, l, r;
    static int[][] map;
    static int[][] map2;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        map2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean scanMap() {
        visited = new boolean[n][n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map2[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    List<int[]> list = bfs(i, j);

                    if (list.size() >= 2) {
                        flag = true;
                        int sum = 0;
                        int cnt = 0;
                        for (int[] arr : list) {
                            sum += map[arr[0]][arr[1]];
                            cnt++;
                        }
                        int each = sum / cnt;

                        for (int[] arr : list) {
                            map2[arr[0]][arr[1]] = each;
                        }
                    }
                }
            }
        }

        if (flag) {
            ans++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = map2[i][j];
                }
            }
        }

        return flag;
    }

    private static List<int[]> bfs(int a, int b) {
        List<int[]> list = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();
        list.add(new int[] {a, b});
        q.add(new int[] {a, b});
        visited[a][b] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int curPop = map[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInRange(nx, ny)) {
                    if (!visited[nx][ny]) {
                        int nxPop = map[nx][ny];
                        int diff = Math.abs(curPop - nxPop);
                        if (diff >= l && diff <= r) {
                            visited[nx][ny] = true;
                            list.add(new int[]{nx, ny});
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }

        }

        return list;
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        while(scanMap());
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
