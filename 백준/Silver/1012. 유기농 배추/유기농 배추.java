import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 너비 우선 탐색(Breadth-First Search)
* 선입 선출 구조의 queue를 활용한다.
* 시작 노드에서 출발해서 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘이다. */

public class Main {

    /* 배추 밭에 필요한 배추 지렁이 갯수 구하는 문제
    * x, y 좌표를 이용한 탐색 문제를 해결할 수 있다.
    * */

    static int t;
    static int m, n, k;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static boolean[][] visit;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            visit = new boolean[m][n];
            map = new int[m][n];

            // map 정보 등록
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Coordinate> q = new LinkedList<>();
        visit[x][y] = true;
        q.offer(new Coordinate(x, y));

        while (!q.isEmpty()) {
            Coordinate poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (!(nx < 0 || nx >= m || ny < 0 || ny >= n)) {
                    if (!visit[nx][ny] && map[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }
    }

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}