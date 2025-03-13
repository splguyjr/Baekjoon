import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    static final int INF = 9999;
    public static int solution(int n) {
        /* dp 배열의 인덱스 값이 곧 해당 kg수의 봉지 개수가 될 수 있도록 저장한다. */
        int[] dp = new int[n + 1];

        /* 배열의 모든 값 초기화 */
        Arrays.fill(dp, INF);

        if (n >= 3) dp[3] = 1;
        if (n >= 5) dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            if(dp[i-3] == INF && dp[i-5] == INF) dp[i] = INF;
            else
                dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }

        return (dp[n] == INF) ? -1 : dp[n];
    }
}
