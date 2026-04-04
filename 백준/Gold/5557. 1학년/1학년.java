import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static long[][] dp;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new long[n][21];   // i번째까지 봤을때 합이 j인 경우의 수

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dp() {
        dp[1][arr[1]] = 1;

        for (int i = 2; i < n; i++) {
            int x = arr[i];

            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (checkRange(j + x)) dp[i][j + x] += dp[i - 1][j];
                    if (checkRange(j - x)) dp[i][j - x] += dp[i - 1][j];
                }
            }
        }
    }

    private static boolean checkRange(int x) {
        return x >= 0 && x <= 20;
    }

    private static void printAnswer() {
        System.out.println(dp[n - 1][arr[n]]);
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
