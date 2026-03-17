import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr; // 중요도, 필요 공부시간
    static int[][] dp; // n번째 과목까지 봤을때, k의 시간으로 뽑을 수 있는 최대 중요도
    static int n, k;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k + 1][2];
        dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void knapsack() {
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                int value = arr[i][0];
                int cost = arr[i][1];

                dp[i][j] = dp[i - 1][j];
                if (j >= cost)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost] + value);
            }
        }
    }

    private static void printAnswer() {
        System.out.println(dp[k][n]);
    }

    private static void solution() throws IOException {
        readInput();
        knapsack();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
