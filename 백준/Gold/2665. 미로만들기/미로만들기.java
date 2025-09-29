import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int idx = 0;
            for (char c : line.toCharArray()) {
                map[i][idx] = c - '0';
                idx++;
            }
        }
    }

    private static void bfs() {
        q.offer(new int[] {0, 0});
        visited[0][0] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0], y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                else {
                    int cost = (map[nx][ny] == 1) ? 0 : 1;
                    
                    if (visited[nx][ny] > cost + visited[x][y]) {
                        if (map[nx][ny] == 1) {
                            visited[nx][ny] = visited[x][y];
                            q.offer(new int[] {nx, ny});
                        }
                        else if (map[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + cost;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }

        System.out.println(visited[n-1][n-1]);
    }

    private static void solution() throws IOException {
        readInput();
        bfs();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
