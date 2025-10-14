import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m, x, y, k;
    static int[][] map;
    static List<Integer> command = new ArrayList<>();
    static int[] dice = new int[6]; // 0(윗면), 1(바닥면), 2(북쪽면), 3(남쪽면), 4(동쪽면), 5(서쪽면)
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            command.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void rollEast(int[] arr) {
        int t = arr[0], b = arr[1], n = arr[2], s = arr[3], e = arr[4], w = arr[5];
        // 윗면 -> 동쪽면, 동쪽면 -> 바닥면, 바닥면 -> 서쪽면, 서쪽면 -> 윗면
        arr[4] = t;
        arr[1] = e;
        arr[5] = b;
        arr[0] = w;
    }

    private static void rollWest(int[] arr) {
        int t = arr[0], b = arr[1], n = arr[2], s = arr[3], e = arr[4], w = arr[5];
        // 윗면 -> 서쪽면, 서쪽면 -> 바닥면, 바닥면 -> 동쪽면, 동쪽면 -> 윗면
        arr[5] = t;
        arr[1] = w;
        arr[4] = b;
        arr[0] = e;
    }

    private static void rollNorth(int[] arr) {
        int t = arr[0], b = arr[1], n = arr[2], s = arr[3], e = arr[4], w = arr[5];
        // 윗면 -> 북쪽면, 북쪽면 -> 바닥면, 바닥면 -> 남쪽면, 남쪽면 -> 윗면
        arr[2] = t;
        arr[1] = n;
        arr[3] = b;
        arr[0] = s;
    }

    private static void rollSouth(int[] arr) {
        int t = arr[0], b = arr[1], n = arr[2], s = arr[3], e = arr[4], w = arr[5];
        // 윗면 -> 남쪽면, 남쪽면 -> 바닥면, 바닥면 -> 북쪽면, 북쪽면 -> 윗면
        arr[3] = t;
        arr[1] = s;
        arr[2] = b;
        arr[0] = n;
    }

    private static void copy(int a, int b) {
        if (map[a][b] == 0) {
            map[a][b] = dice[1];
        }

        else {
            dice[1] = map[a][b];
            map[a][b] = 0;
        }
    }

    private static void roll(int command) {
        int nx = x + dx[command];
        int ny = y + dy[command];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m) return;

        switch (command) {
            case 1:
                rollEast(dice);
                copy(nx, ny);
                break;
            case 2:
                rollWest(dice);
                copy(nx, ny);
                break;
            case 3:
                rollNorth(dice);
                copy(nx, ny);
                break;
            case 4:
                rollSouth(dice);
                copy(nx, ny);
                break;

        }

        x = nx;
        y = ny;

        System.out.println(dice[0]);
    }

    private static void solution() throws IOException {
        readInput();
        for (int cmd : command) {
            roll(cmd);
        }
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
