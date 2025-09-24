import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int INF = 987654321;
    static int[][] dist;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        dp = new int[n][1<<n];//j에 해당하는 도시들을 방문한 상태, 현재 i에 위치해있을 때 나머지 도시들을 방문하고 처음 도시로 돌아가는 최소 비용

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int dfs(int mask, int cur) {
        // 모든 도시를 방문한 경우
        if (mask == (1 << n) - 1) {
            // 마지막 위치에서 시작 지점으로 경로가 존재하는지 확인
            if (dist[cur][0] == 0) return INF;

            else return dist[cur][0];
        }

        if (dp[cur][mask] != -1) return dp[cur][mask];

        dp[cur][mask] = INF;

        for (int i = 0; i < n; i++) {
            // 현재 위치에서 다음으로 가는 경로가 없는 경우 or 이미 방문한 도시인 경우
            if (dist[cur][i] == 0 || (mask & (1 << i)) != 0) continue;

            // 다음 도시 방문 처리
            int next = mask | (1 << i);

            dp[cur][mask] = Math.min(dp[cur][mask], dfs(next, i) + dist[cur][i]);
        }

        return dp[cur][mask];
    }

    private static void solution() throws IOException {
        readInput();
        System.out.println(dfs(1, 0));  // 0번 도시에서 시작
    }

    public static void main(String[] args) throws IOException {
        Main.solution();

    }
}