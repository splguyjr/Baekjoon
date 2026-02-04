import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited = new boolean[101][101];
    static int ans = 0;

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

        for (int i = 0; i < n; i++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            int d = reader.nextInt();
            int g = reader.nextInt();

            markCurve(x, y, d, g);
        }
    }

    private static void markCurve(int x, int y, int d, int g) {
        List<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = dirList.size() - 1; j >= 0; j--) {
                dirList.add((dirList.get(j) + 1) % 4);
            }
        }

        visited[y][x] = true;
        for (int dir : dirList) {
            x += dx[dir];
            y += dy[dir];

            visited[y][x] = true;
        }
    }

    private static void checkSquare() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1]) ans++;
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() {
        readInput();
        checkSquare();
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
