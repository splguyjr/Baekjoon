import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] dist;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void dfs(int cnt, int cur, int sum) {
        if (cnt == n) {
            if (dist[cur][0] == 0) return;
            else {
                ans = Math.min(ans, sum + dist[cur][0]);
            }
        }

        else {
            for (int i = 0; i < n; i++) {
                if(!visited[i] && dist[cur][i] > 0) {
                    visited[i] = true;
                    dfs(cnt + 1, i, sum + dist[cur][i]);
                    visited[i] = false;
                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        visited[0] = true;  // 0번 위치 시작
        dfs(1, 0, 0);
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}