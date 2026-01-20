import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // dfs + dp(메모이제이션)

    static int n, m;
    static int[][] arr;
    static int[][] dp;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    private static void dp() {
        for (int i = 1; i <= n; i++) {
            int[] right = new int[m + 2]; // 왼 -> 오
            int[] left = new int[m + 2]; // 오 -> 왼
            
            Arrays.fill(right, Integer.MIN_VALUE);
            Arrays.fill(left, Integer.MIN_VALUE);
            
            if (i == 1) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                }
                continue;
            }

            for (int j = 1; j <= m; j++) {
                right[j] = Math.max(dp[i - 1][j], right[j - 1]) + arr[i][j];

                int rj = m - j + 1;
                left[rj] = Math.max(dp[i - 1][rj], left[rj + 1]) + arr[i][rj];
            }

            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }
    }

    private static void printAnswer() {
        System.out.println(dp[n][m]);
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
