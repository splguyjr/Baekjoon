import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 파도반 수열
* 점화식 : f(n) = f(n-2) + f(n-3) */
public class Main {

    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(padovan(n));
        }
    }

    private static long padovan(int n) {
        dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}