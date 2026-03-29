import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static int[][] map;
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == 'x') map[i][j] = 1;
            }
        }
    }

    private static void countPossibleRoutes() {
        for (int i = 0; i < r; i++) {
            dfs(i, 0);
        }
    }
    private static boolean dfs(int x, int y) {
        map[x][y] = 1;

        if (y == c - 1) {
            ans++;
            return true;
        }

        int[] dx = new int[] {-1, 0, 1};
        int[] dy = new int[] {1, 1, 1};

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkPosition(nx, ny)) {
                if(dfs(nx, ny)) return true;
            }
        }

        return false;
    }


    private static boolean checkPosition(int a, int b) {
        boolean isInRange = a >= 0 && b >= 0 && a < r && b < c;
        if (isInRange) {
            boolean isVisited = map[a][b] == 1;
            return !isVisited;
        }
        return isInRange;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        countPossibleRoutes();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
