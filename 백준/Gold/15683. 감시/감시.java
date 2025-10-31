import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] cctvDir = {
            {},
            { {0}, {1}, {2}, {3} },
            { {0, 2}, {1, 3} },
            { {0, 1}, {1, 2}, {2, 3}, {0, 3} },
            { {0, 1, 2}, {1, 2, 3}, {0, 2, 3}, {0, 1, 3} },
            { {0, 1, 2, 3} }
    };
    static List<Cctv> cctvList = new ArrayList<>();
    static int uncoveredCount = 0;  // 감시
    static Scanner sc = new Scanner(System.in);

    static class Cctv {
        int x;
        int y;
        int type;

        Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    private static void readInput() {
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new Cctv(i, j, map[i][j]));
                } else if (map[i][j] == 0) uncoveredCount++;
            }
        }
    }

    private static int scanUncovered(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int depth, int limit, int[][] map) {
        if (depth == limit) {
            int cnt = scanUncovered(map);
            uncoveredCount = Math.min(uncoveredCount, cnt);
            return;
        }

        Cctv cctv = cctvList.get(depth);
        int x = cctv.x;
        int y = cctv.y;
        int type = cctv.type;

        for (int[] dirs : cctvDir[type]) {
            int[][] mapCopy = new int[n][m];

            for (int i = 0; i < n; i++) {
                mapCopy[i] = map[i].clone();
            }

            for (int dir : dirs) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (mapCopy[nx][ny] == 6) break;

                    mapCopy[nx][ny] = -1;   // 방문 처리
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
            dfs(depth + 1, limit, mapCopy);
        }
    }

    private static void solution() {
        readInput();
        dfs(0, cctvList.size(), map);
        System.out.println(uncoveredCount);
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
