import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a, b, c;
    static int[][][][] dp; // t, a, b, c -> t턴에 F가 가져갈 수 있는 최대 개수

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dp = new int[29][a + 1][b + 1][c + 1];

        for (int i = 1; i <= 28; i++) {
            for (int j = 0; j <= a; j++) {
                for (int k = 0; k <= b; k++) {
                    for (int l = 0; l <= c; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
    }

    private static int dp(int t, int a, int b, int c) {
        if (dp[t][a][b][c] != -1) return dp[t][a][b][c];
        if (a == 0 && b == 0 && c == 0) return 0;
        int res;
        if (t % 2 == 1) {
            res = 0;
            if (a > 0) {
                int x = Math.min(t, a);
                res = Math.max(res, x + dp(t + 1, a - x, b, c));
            }

            if (b > 0) {
                int x = Math.min(t, b);
                res = Math.max(res, x + dp(t + 1, a, b - x, c));
            }

            if (c > 0) {
                int x = Math.min(t, c);
                res = Math.max(res, x + dp(t + 1, a, b, c - x));
            }
        } else {
            res = Integer.MAX_VALUE;
            if (a > 0) {
                int x = Math.min(t, a);
                res = Math.min(res, dp(t + 1, a - x, b, c));
            }

            if (b > 0) {
                int x = Math.min(t, b);
                res = Math.min(res, dp(t + 1, a, b - x, c));
            }

            if (c > 0) {
                int x = Math.min(t, c);
                res = Math.min(res, dp(t + 1, a, b, c - x));
            }
        }

        return dp[t][a][b][c] = res;
    }

    private static void printResult(int f) {
        int total = a + b + c;
        int s = total - f;

        if (f > s) System.out.println("F");
        else if (s > f) System.out.println("S");
        else System.out.println("D");
    }

    private static void solution() throws IOException {
        readInput();
        printResult(dp(1, a, b, c));
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
