import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int sx, sy;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static BabyShark babyShark;
    static int ans = 0;

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

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

    static class BabyShark {
        private int age;
        private int progress;   // 경험치 바

        BabyShark (int age) {
            this.age = age;
            this.progress = 0;
        }

        void eat() {
            progress++;
            if (progress == age) {
                age++;
                progress = 0;
            }
        }

        int getAge() {
            return age;
        }

        int getProgress() {
            return progress;
        }
    }

    private static void readInput() {
        Reader reader = new Reader();
        n = reader.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = reader.nextInt();
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        babyShark = new BabyShark(2);
    }

    private static boolean bfs() {
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sx, sy, 0});
        visited[sx][sy] = true;
        int tx = n - 1;
        int ty = n - 1;
        int distOfLevel = 0;
        boolean flag = false;

        while (!q.isEmpty() && !flag) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int dist = cur[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    int nDist = dist + 1;

                    if (isInRange(nx, ny)) {
                        if (visited[nx][ny]) continue;

                        if (isEatable(nx, ny)) {
                            if (nx < tx || (nx == tx && ny < ty)) {
                                tx = nx;
                                ty = ny;
                            }
                            distOfLevel = nDist;
                            flag = true;
                        }

                        else if (isPassable(nx, ny)) {
                            q.add(new int[] {nx, ny, nDist});
                        }

                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if (flag) {
            ans += distOfLevel;
            map[tx][ty] = 0;
            sx = tx;
            sy = ty;
            babyShark.eat();
            return true;
        }
        return false;
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }

    private static boolean isPassable(int a, int b) {
        int age = babyShark.getAge();
        if (age >= map[a][b]) return true;
        return false;
    }

    private static boolean isEatable(int a, int b) {
        if (map[a][b] > 0) {
            int age = babyShark.getAge();
            if (age > map[a][b]) return true;
        }
        return false;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() {
        readInput();
        while(bfs());
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
