import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static int blockCnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
    }

    private static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];

        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;

            blockCnt = Math.max(blockCnt, cnt);

            if (x == n - 1 && y == m - 1) return;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isInRange(nx, ny)) {
                    if (visited[nx][ny]) continue;

                    int block = arr[nx][ny];

                    if (block == 1) {
                        pq.add(new Node(nx, ny, cnt + 1));
                    }
                    else pq.add(new Node(nx, ny, cnt));

                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < m;
    }

    private static void printAnswer() {
        System.out.println(blockCnt);
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
