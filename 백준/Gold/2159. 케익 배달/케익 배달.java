import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int sx, sy;
    static int[][] cus;
    static long[][] dp;  // n번째 고객까지 최소 동선 거리, 0:중앙 1234:북동남서

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cus = new int[n + 1][2];
        dp = new long[n + 1][5];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cus[i][0] = x;
            cus[i][1] = y;
        }
    }

    private static void dp() {
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;

        for (int i = 1; i <= n; i++) {
            checkMinDist(sx, sy, 0, i);
            checkMinDist(sx - 1, sy, 1, i);
            checkMinDist(sx, sy + 1, 2, i);
            checkMinDist(sx + 1, sy, 3, i);
            checkMinDist(sx, sy - 1, 4, i);
            sx = cus[i][0];
            sy = cus[i][1];
        }
    }

    private static void checkMinDist(int sx, int sy, int dir, int destIdx) {
        int[] dx = {0, -1, 0, 1, 0};
        int[] dy = {0, 0, 1, 0, -1};

        for (int i = 0; i < 5; i++) {
            int nx = cus[destIdx][0] + dx[i];
            int ny = cus[destIdx][1] + dy[i];
            if (!isInRange(nx, ny)) continue;
            if (dp[destIdx - 1][dir] == Long.MAX_VALUE) continue;
            
            dp[destIdx][i] = Math.min(dp[destIdx][i], dp[destIdx - 1][dir] + calcEucDist(sx, sy, nx, ny));
        }
    }

    private static boolean isInRange(int a, int b) {
        return a > 0 && b > 0 && a <= 100000 && b <= 100000;
    }

    private static int calcEucDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static void printAnswer() {
        long ans = Math.min(Long.MAX_VALUE, dp[n][0]);
        ans = Math.min(ans, dp[n][1]);
        ans = Math.min(ans, dp[n][2]);
        ans = Math.min(ans, dp[n][3]);
        ans = Math.min(ans, dp[n][4]);

        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        dp();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
