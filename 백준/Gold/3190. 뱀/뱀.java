import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, l;
    static boolean[][] map;
    static boolean[][] visited;
    static Deque<int[]> snake = new ArrayDeque<>();
    static Queue<Command> q = new LinkedList<>();

    static int direction = 3;   // 0:상, 1:하, 2:좌, 3:우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Command {
        int time;
        char cmd;

        Command(int time, char cmd) {
            this.time = time;
            this.cmd = cmd;
        }
    }

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        l  = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char cmd = st.nextToken().charAt(0);
            q.offer(new Command(time, cmd));
        }
    }

    private static int move() {
        int x = 1, y = 1;
        snake.addFirst(new int[]{x, y});
        visited[x][y] = true;

        int time = 0;

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 벽 충돌
            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                time++;
                break;
            }

            // 몸 충돌
            if (visited[nx][ny]) {
                time++;
                break;
            }

            boolean hasApple = map[nx][ny];

            // 사과 없으면 꼬리 먼저 제거
            if (hasApple) {
                map[nx][ny] = false;
            } else {
                int[] tail = snake.removeLast();
                visited[tail[0]][tail[1]] = false;
            }

            // 전진
            snake.addFirst(new int[]{nx, ny});
            visited[nx][ny] = true;
            x = nx; y = ny;
            time++;

            if (!q.isEmpty() && time == q.peek().time) {
                Command command = q.poll();
                // 0:상, 1:하, 2:좌, 3:우
                if (command.cmd == 'L') {
                    direction = (direction == 0) ? 2
                              : (direction == 1) ? 3
                              : (direction == 2) ? 1 : 0;
                } else {
                    direction = (direction == 0) ? 3
                              : (direction == 1) ? 2
                              : (direction == 2) ? 0 : 1;
                }
            }
        }

        return time;
    }

    private static void solution() throws IOException {
        readInput();
        System.out.println(move());
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
