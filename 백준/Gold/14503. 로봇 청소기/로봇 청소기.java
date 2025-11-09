import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int r, c, d; // 시작 좌표 r,c & 방향 d(북:0, 동:1, 남:2, 서:3)
    static int[][] map;
    static int cleanCount = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    private static boolean isInRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < m);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {r, c});
        map[r][c] = 2;

        while (!q.isEmpty()) {
            int[] space = q.poll();
            int x = space[0];
            int y = space[1];

            boolean hasEmpty = false;

            // 주변 4칸 중 청소되지 않은 칸이 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInRange(nx, ny) && map[nx][ny] == 0) {
                    hasEmpty = true;
                    break;
                }
            }

            if (hasEmpty) {
                // 왼쪽으로 회전하면서 앞이 청소되지 않은 곳일 때만 이동
                for (int i = 0; i < 4; i++) {
                    d = (d + 3) % 4;
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (isInRange(nx, ny) && map[nx][ny] == 0) {
                        map[nx][ny] = 2;
                        cleanCount++;
                        q.offer(new int[]{nx, ny});
                        break;
                    }
                }
            }
            // 청소되지 않은 칸이 없다면 후진 시도
            else {
                int backDir = (d + 2) % 4;
                int bx = x + dx[backDir];
                int by = y + dy[backDir];

                if (!isInRange(bx, by) || map[bx][by] == 1) break; // 뒤가 벽이면 종료
                q.offer(new int[]{bx, by}); // 벽 아니면 후진
            }
        }
    }

    private static void printAnswer() {
        System.out.println(cleanCount);
    }

    private static void solution() throws IOException {
        readInput();
        bfs();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
