import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] dp;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], - 1);
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int dfs(int x, int y) {
        if (x == 0 && y == 0) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        if (x - 1 >= 0 && arr[x - 1][y] > arr[x][y]) dp[x][y] += dfs(x - 1, y);
        if (x + 1 <= n - 1 && arr[x + 1][y] > arr[x][y]) dp[x][y] += dfs(x + 1, y);
        if (y - 1 >= 0 && arr[x][y - 1] > arr[x][y]) dp[x][y] += dfs(x, y - 1);
        if (y + 1 <= m - 1 && arr[x][y + 1] > arr[x][y]) dp[x][y] += dfs(x, y + 1);
        return dp[x][y];
    }

    private static void solution() throws IOException {
        readInput();
        System.out.print(dfs(n - 1, m - 1));
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
