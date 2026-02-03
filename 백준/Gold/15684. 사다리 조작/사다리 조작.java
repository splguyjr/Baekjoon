import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, h;
    static int[][] map;
    static int ans = 4;

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
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
        h = reader.nextInt();

        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();

            map[a][b] = 1; // 오
            map[a][b + 1] = -1; // 왼
        }
    }

    private static void dfs(int r, int c, int cnt) {
        if (check()) {
            ans = Math.min(ans, cnt);
            return;
        }

        else if (cnt == 3) {
            return;
        }

        for (int i = r; i <= h; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (isAvailableLine(i, j)) {
                    map[i][j] = 1;
                    map[i][j + 1] = -1;
                    dfs(i, j, cnt + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean isAvailableLine(int r, int c) {
        if (map[r][c + 1] == 1) return false;
        else if (map[r][c] == 1) return false;
        else if (c > 1 && map[r][c - 1] == 1) return false;
        return true;
    }

    private static boolean check() {
        for (int i = 1; i <= n; i++) {
            if (!checkLine(i)) return false;
        }
        return true;
    }

    private static boolean checkLine(int idx) {
        int pos = idx;
        for (int i = 1; i <= h; i++) {
            if (map[i][pos] == 1) pos++;
            else if (map[i][pos] == -1) pos--;
        }
        if (pos == idx) return true;
        else return false;
    }

    private static void printAnswer() {
        if (ans == 4) System.out.println(-1);
        else System.out.println(ans);
    }

    private static void solution() {
        readInput();
        dfs(1, 1, 0);
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
