import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Node> list = new ArrayList<>();
    static final int MAX = 2500;
    static int ans = MAX;

    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Reader {
        static BufferedReader br;
        static StringTokenizer st;

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

    private static void readInput() throws IOException {
        Reader reader = new Reader();

        n = reader.nextInt();
        m = reader.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
                if (map[i][j] == 2) {
                    list.add(new Node(i, j));
                }
            }
        }

        reader.close();
    }

    private static void dfs(int idx, int cnt, List<Node> vList) {
        if (cnt == m) {
            bfs(vList);
        }

        for (int i = idx; i < list.size(); i++) {
            vList.add(list.get(i));
            dfs(i + 1,cnt + 1, vList);
            vList.remove(vList.size() - 1);
        }
    }

    private static void bfs(List<Node> vList) {
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (Node node : vList) {
            q.add(node);
            visited[node.x][node.y] = 0;
        }

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            int x = curNode.x;
            int y = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny)) {
                    if (visited[nx][ny] == -1) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }

        checkAllVisited(visited);
    }

    private static void checkAllVisited(int[][] visited) {
        int mx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    if (visited[i][j] == -1) return;
                    mx = Math.max(mx, visited[i][j]);
                }
            }
        }

        ans = Math.min(ans, mx);
    }

    private static boolean isValid(int a, int b) {
        return isInRange(a, b) && isNotWall(a, b);
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }

    private static boolean isNotWall(int a, int b) {
        return map[a][b] != 1;
    }

    private static void printAnswer() {
        if (ans == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    private static void solution() throws IOException {
        readInput();
        dfs(0, 0, new ArrayList<>());
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
