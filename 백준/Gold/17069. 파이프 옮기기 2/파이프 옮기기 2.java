import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static long[][][] dp;   // i, j 위치까지 연결해 해당 위치에 k 파이프를 놓을 수 있는 가짓 수

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static long dp() {
        dp[1][2][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (map[i][j] != 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    if(map[i-1][j] != 1 && map[i][j-1] != 1)
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        return dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
    }

    private static void printAnswer() {
        System.out.println(dp());
    }

    private static void solution() throws IOException {
        readInput();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}