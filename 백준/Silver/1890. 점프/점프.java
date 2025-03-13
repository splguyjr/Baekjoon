import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][n+1];
        int[][] board = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int jumpCount = board[i][j];
                if(jumpCount == 0) break;
                if (i + jumpCount <= n) {
                    dp[i + jumpCount][j] += dp[i][j];
                }
                if (j + jumpCount <= n)
                    dp[i][j + jumpCount] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}