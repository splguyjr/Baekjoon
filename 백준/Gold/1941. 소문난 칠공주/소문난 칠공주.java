import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] map = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;

    private static void readInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String line = sc.nextLine();

            int j = 0;
            for (char c : line.toCharArray()) {
                map[i][j++] = c;
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

    // 7공주 조건을 만족하는지 체크 -> 무작위로 뽑은 위치가 연결되어 있고, 다솜파가 4명 이상인지 확인
    private static boolean bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[5][5];

        int cnt = 1;
        int cntS = (map[a][b] == 'S') ? 1 : 0;
        q.add(new int[] {a, b});
        v[a][b] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isInRange(nx, ny)) continue;
                if (!visited[nx][ny]) continue;
                if (v[nx][ny]) continue;

                if (map[nx][ny] == 'S') cntS++;
                cnt++;
                q.add(new int[] {nx, ny});
                v[nx][ny] = true;
            }
        }

        return cnt == 7 && cntS >= 4;
    }

    // 'S'가 4개 이상이고 서로 연결되어 있어야 함.
    private static boolean checkSevenPrincess() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    if(bfs(i, j)) return true;
                    return false;
                }
            }
        }
        return false;
    }

    private static void dfs(int cnt, int idx) {
        if (cnt == 7) {
            if (checkSevenPrincess()) ans++;
            return;
        }

        for (int i = idx; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            visited[r][c] = true;
            dfs(cnt + 1, i + 1);
            visited[r][c] = false;
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        dfs(0, 0);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
