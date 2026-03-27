import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] sum;
    static long[] dp; // i번째 표적까지 있을 때, 해당 상태에서 얻을 수 있는 최대 점수
    static long ans = Long.MIN_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sum = new long[n + 1];
        dp = new long[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }
    }

    private static void dp() {
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(sum[i] - dp[i - 1], dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
    }

    private static void printAnswer() {
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
