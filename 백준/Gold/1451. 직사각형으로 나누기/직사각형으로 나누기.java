import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, m;
    static long[][] prefix;
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sarr = br.readLine().split(" ");
        n = Integer.parseInt(sarr[0]);
        m = Integer.parseInt(sarr[1]);

        prefix = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                int x = line.charAt(j - 1) - '0';
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + x;
            }
        }
    }

    private static void bruteforce() {
        // 가로가로가로
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n -1; j++) {
                long sum1 = arrSum(1, 1, i, m);
                long sum2 = arrSum(i + 1, 1, j, m);
                long sum3 = arrSum(j + 1, 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }

        // 세로세로세로
        for (int i = 1; i <= m - 2; i++) {
            for (int j = i + 1; j <= m -1; j++) {
                long sum1 = arrSum(1, 1, n, i);
                long sum2 = arrSum(1, i + 1, n, j);
                long sum3 = arrSum(1, j + 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }

        // 가로 세로세로
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= m - 1; j++) {
                long sum1 = arrSum(1, 1, i, m);
                long sum2 = arrSum(i + 1, 1, n, j);
                long sum3 = arrSum(i + 1, j + 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }

        // 세로세로 가로
        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n -1; j++) {
                long sum1 = arrSum(1, 1, j, i);
                long sum2 = arrSum(1, i + 1, j, m);
                long sum3 = arrSum(j + 1, 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }


        // 세로 가로가로
        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n -1; j++) {
                long sum1 = arrSum(1,1, n, i);
                long sum2 = arrSum(1, i + 1, j, m);
                long sum3 = arrSum(j + 1, i + 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }


        // 가로가로 세로
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= m - 1; j++) {
                long sum1 = arrSum(1, 1, i, j);
                long sum2 = arrSum(i + 1, 1, n, j);
                long sum3 = arrSum(1, j + 1, n, m);

                ans = Math.max(ans, sum1 * sum2 * sum3);
            }
        }

    }

    private static long arrSum(int a, int b, int c, int d) {
        return prefix[c][d] - prefix[a - 1][d] - prefix[c][b - 1] + prefix[a - 1][b - 1];
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        bruteforce();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
