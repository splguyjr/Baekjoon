import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int[][] a, b, dp;
    static int[][] pa, pb;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[r + 1][c + 1];
        b = new int[r + 1][c + 1];
        dp = new int[r + 1][c + 1];

        for (int i = 0; i <= r; i++) {
            Arrays.fill(dp[i], -1501);
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                String s = st.nextToken();

                int num = Integer.parseInt(s.substring(1));
                if (s.charAt(0) == 'A') {
                    a[i][j] = num;
                }
                else {
                    b[i][j] = num;
                }
            }
        }
    }

    private static void prefixSum() {
        pa = new int[r + 1][c + 1];
        pb = new int[r + 1][c + 1];

        for (int i = 1; i <= c; i++) {
            for (int j = 2; j <= r; j++) {
                pb[j][i] = pb[j - 1][i] + b[j - 1][i];
            }

            for (int j = r - 1; j >= 1; j--) {
                pa[j][i] = pa[j + 1][i] + a[j + 1][i];
            }
        }
    }

    private static void dp() {
        dp[1][1] = pa[1][1] + pb[1][1];

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + pa[i][j] + pb[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + pa[i][j] + pb[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - a[i][j]);
            }
        }
    }

    private static void printAnswer() {
        int ans = dp[r][c];

        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        prefixSum();
        dp();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
