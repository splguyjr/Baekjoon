import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int answer;
    static int[] arr;
    static int[][] dp;  // i, j인 경우 -> 앞에서부터 i 위치까지, 뒤에서부터 j 위치까지 짜른 경우에서 최대 이익
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void readInput() throws IOException {
        String s = br.readLine();
        n = Integer.parseInt(s);

        arr = new int[n + 2];
        dp = new int[n + 3][n + 3]; // 0 ~ n+2

        for (int i = 1; i <= n; i++) {
            s = br.readLine();
            arr[i] = Integer.parseInt(s);
        }
    }

    // 점화식 세우기, 기존까지의 최대에서
    private static void dp() {
        for (int i = 1; i <= n + 1; i++) {
            int size = n + 2 - i;
            int turn = i - 1;

            for (int j = 0; j < i; j++) {
                if (j == 0) dp[j][j+size] = dp[j][j+size+1] + turn * arr[j+size];
                else dp[j][j+size] = Math.max(dp[j][j+size+1] + turn * arr[j+size], dp[j-1][j+size] + turn * arr[j]);

                // 모두 뽑은 경우 중 최대값 저장
                if (i == n + 1) {
                    answer = Math.max(answer, dp[j][j+size]);
                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        dp();
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}