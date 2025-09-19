import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] map;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // n이 10으로 작으므로 O(n^3)에 해당하는 플로이드 워셜을 적용하여 최단거리를 계산하여도 문제가 없음
    private static void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
    }

    private static void dfs(int cur, int cnt, int sum) {
        if (cnt == n) {
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1, sum + map[cur][i]);
                visited[i] = false;
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        floyd();
        visited[k] = true;
        dfs(k, 1, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}