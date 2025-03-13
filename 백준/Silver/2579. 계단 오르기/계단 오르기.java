import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp = new int[301];
    static int[] stair = new int[301];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int score = Integer.parseInt(br.readLine());
            stair[i] = score;
        }

        dp[1] = stair[1];
        if(n >=2) dp[2] = stair[1]+ stair[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
        }

        System.out.println(dp[n]);
    }
}