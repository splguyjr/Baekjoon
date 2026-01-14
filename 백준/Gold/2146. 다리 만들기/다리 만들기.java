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

    private static void bfs2(int x, int y, int[][] visitArr) {
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{x, y, 0});
        int islandNum = visitArr[x][y];
        visitArr[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int cnt = cur[2];

                if (isInRange(nx, ny)) {
                    // 다음 이동 위치가 시작한 섬 번호도 아니고, 방문하지도 않았으며, 빈 곳도 아니라면
                    // 이웃 섬에 도착하였으므로 값 갱신
                    if (visitArr[nx][ny] != islandNum && visitArr[nx][ny] != 1 && visitArr[nx][ny] != 0) {
                        ans = Math.min(ans, cnt);
                    }

                    // 현재 섬안에서 이동하는 경우
                    else if (visitArr[nx][ny] == islandNum && cnt == 0) {
                        q.addFirst(new int[]{nx, ny, cnt});
                        visitArr[nx][ny] = 1; // 방문 처리는 1로
                    }

                    // 섬 밖에서 이동하는 경우, cnt + 1
                    else if (visitArr[nx][ny] == 0) {
                        q.addLast(new int[]{nx, ny, cnt + 1});
                        visitArr[nx][ny] = 1;
                    }
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
