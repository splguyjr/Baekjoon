import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int t, n;
    static int[][] dp;  // i ~ j의 카드가 남았을 때, 해당 턴인 사람이 만들어낼 수 있는 최대 점수 차
    static int[] arr;


    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            dp = new int[n + 1][n + 1];

            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[j], -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            int diff = dp(1, n);
            int ans = (sum - diff)/2 + diff;
            sb.append(ans).append('\n');
        }

        System.out.println(sb.toString());
    }

    // 왼쪽 선택 vs 오른쪽 선택시 상대와의 차이를 최대로 해야 함
    private static int dp(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return arr[i];

        return dp[i][j] = Math.max(arr[i] - dp(i + 1, j), arr[j] - dp(i, j - 1));
    }

    public static void main(String[] args) throws IOException {
        readInput();
    }
}
