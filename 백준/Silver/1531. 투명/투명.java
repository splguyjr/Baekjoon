import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[101][101];

        for (int i = 0; i <= 100; i++) {
            Arrays.fill(map[i], m);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            placePaper(x1, y1, x2, y2);
        }
    }

    private static void placePaper(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                map[i][j] -= 1;
            }
        }
    }

    private static void countAnswer() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (map[i][j] < 0) ans++;
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        countAnswer();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
