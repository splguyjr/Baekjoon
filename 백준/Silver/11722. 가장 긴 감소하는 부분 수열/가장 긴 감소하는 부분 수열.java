import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[] dp;
    static int ans = 1;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void dp() {
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);

                ans = Math.max(ans, dp[i]);
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        dp();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
