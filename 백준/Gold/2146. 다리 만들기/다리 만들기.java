import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> startPointList = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

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

        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
            }
        }
    }

    private static void checkGroup() {
        int num = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j, num);
                    num++;
                    startPointList.add(new int[]{i, j}); // 이웃 섬 탐색을 시작할 점들을 미리 저장해두기
                }
            }
        }
    }

    // 섬을 2부터 번호 마킹하기 위한 bfs
    private static void bfs(int x, int y, int num) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {x, y});
        visited[x][y] = num;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (isInRange(nx, ny)) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                        q.offer(new int[] {nx, ny});
                        visited[nx][ny] = num;
                    }
                }
            }
        }
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }

    private static void searchNearIsland() {
        for (int[] point : startPointList) {
            int x = point[0];
            int y = point[1];

            int[][] copyMap = copyArr();

            bfs2(x, y, copyMap);
        }
    }

    private static int[][] copyArr() {
        int[][] copyArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            copyArr[i] = visited[i].clone();
        }

        return copyArr;
    }

    private static void bfs2(int x, int y, int[][] labelArr) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][n];

        int islandNum = labelArr[x][y];
        q.offer(new int[]{x, y, 0});
        seen[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if (cnt >= ans) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (!isInRange(nx, ny) || seen[nx][ny]) continue;

                if (labelArr[nx][ny] != 0 && labelArr[nx][ny] != islandNum) {
                    ans = Math.min(ans, cnt);
                } else if (labelArr[nx][ny] == islandNum && cnt == 0) {
                    seen[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt});
                } else if (labelArr[nx][ny] == 0) {
                    seen[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        checkGroup();
        searchNearIsland();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();

    }
}
