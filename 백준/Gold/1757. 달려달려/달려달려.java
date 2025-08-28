import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp[i] = 시각 i부터 N까지 시작할 때 얻을 수 있는 최대 거리 (이때 지침 지수는 0)
public class Main {

    static int[] dp;
    static int n, m;
    static int[] dist;
    static int[] prefixDist;
    static int answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void readInput() throws IOException{
        String input = br.readLine();
        String[] arr = input.split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);

        dist = new int[n + 2];
        prefixDist = new int[n + 1];
        dp = new int[n + 2];
        
        for (int i = 1; i <= n; i++) {
            input = br.readLine();
            dist[i] = Integer.parseInt(input);
            prefixDist[i] = prefixDist[i - 1] + dist[i];
        }
    }

    private static void dp() {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= (n - i + 1) / 2; j++) {
                // i부터 L거리만큼 연속으로 달린 경우 거리 계산(누적합 배열을 이용해 N(1)으로)
                int distSum = prefixDist[n] - prefixDist[i - 1] - (prefixDist[n] - prefixDist[i + j - 1]);
                dp[i] = Math.max(dp[i], Math.max(dp[i + 1], distSum + dp[i + 2 * j]));
            }
        }

        answer = dp[1];
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