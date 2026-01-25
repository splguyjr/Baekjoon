import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String s1, s2, s3;
    static int[][][] dp = new int[101][101][101];
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        s3 = br.readLine();
    }
    
    private static void lcs() {
        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j - 1);
                for (int k = 1; k <= s3.length(); k++) {
                    char c3 = s3.charAt(k - 1);

                    if (c1 == c2 && c2 == c3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        ans = Math.max(ans, dp[i][j][k]);
                    }
                    
                    else {
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
                }
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        lcs();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
