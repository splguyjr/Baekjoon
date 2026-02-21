import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c, t;
    static int[][] map;
    static int[][] diff;
    static int pRow1, pRow2;    // 공기청정기 행
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        boolean flag = false;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (!flag) {
                        pRow1 = i;
                        flag = true;
                    }
                    else pRow2 = i;
                }
            }
        }
    }

    private static void simulate() {
        for (int k = 0; k < t; k++) {
            diff = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) spread(i, j);
                }
            }
            applyDiff(diff);

            purifyAir(0, pRow1, pRow1, false);
            purifyAir(pRow2, r - 1, pRow2, true);
        }
    }

    private static void spread(int x, int y) {
        int dust = map[x][y];
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny)) {
                diff[nx][ny] += dust / 5;
                cnt++;
            }
        }

        diff[x][y] -= cnt * (dust / 5);
    }

    private static boolean isValid(int a, int b) {
        boolean b1 = a >= 0 && b >= 0 && a < r && b < c;
        boolean b2 = !((a == pRow1 && b == 0) || (a == pRow2 && b == 0));
        return b1 && b2;
    }

    private static void applyDiff(int[][] arr) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] += arr[i][j];
            }
        }
    }

    private static void purifyAir(int tRow, int bRow, int pRow, boolean isClockWise) {
        int x = pRow;
        int y = 0;
        int prev = 0;

        int[] dr;
        int[] dc;

        // 오른쪽, 아래, 왼쪽, 위
        if (isClockWise) {
            dr = new int[] {0, 1, 0, -1};
            dc = new int[] {1, 0, -1, 0};
        }

        // 오른쪽, 위, 왼쪽, 아래
        else {
            dr = new int[] {0, -1, 0, 1};
            dc = new int[] {1, 0, -1, 0};
        }

        for (int i = 0; i < 4; i++) {
            while (true) {
                int nx = x + dr[i];
                int ny = y + dc[i];

                // 벽 끝에 도달
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) break;

                // 공기청정기 시작점에 도달
                if (nx == pRow && ny == 0) return;

                int temp = map[nx][ny];
                map[nx][ny] = prev;
                prev = temp;

                x = nx;
                y = ny;
            }
        }
    }

    private static void printAnswer() {
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        simulate();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
