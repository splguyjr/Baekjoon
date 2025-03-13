import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[3][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1]) + r;
            dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1]) + g;
            dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1]) + b;
        }

        int temp = Math.min(dp[0][n], dp[1][n]);
        System.out.println(Math.min(temp, dp[2][n]));
    }
}