import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1];    // 카페인 섭취양에 따른 최소 마셔야하는 커피 수 저장
        Arrays.fill(dp, 101);
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (c <= k) dp[c] = 1;
            for (int j = k; j >= c; j--) {
                if (j - c >= 0 && dp[j - c] + 1 < dp[j]) dp[j] = dp[j - c] + 1;
            }
        }

        if (dp[k] == 101) System.out.print(-1);
        else System.out.println(dp[k]);
    }
}
