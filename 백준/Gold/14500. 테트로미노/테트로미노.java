import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readInput() {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = reader.nextInt();
            }
        }
    }

    private static void bruteForce() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }
    }

    private static void dfs(int row, int col, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nRow = row + dx[i];
            int nCol = col + dy[i];

            if (nRow < 0 || nCol < 0 || nRow >= n || nCol >= m) continue;
            if (visited[nRow][nCol]) continue;

            // ㅗ모양
            if (cnt == 2) {
                visited[nRow][nCol] = true;
                dfs(row, col, cnt + 1, sum + arr[nRow][nCol]);
                visited[nRow][nCol] = false;
            }

            visited[nRow][nCol] = true;
            dfs(nRow, nCol, cnt + 1, sum + arr[nRow][nCol]);
            visited[nRow][nCol] = false;
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() {
        readInput();
        bruteForce();
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
