import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[] parent;
    static List<Integer> plan = new ArrayList<>();

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            plan.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) {
            parent[rx] = ry;
        }
    }

    private static void connect() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }
    }

    private static boolean checkPossible() {
        for (int i = 0; i < plan.size() - 1; i++) {
            int a = plan.get(i);
            int b = plan.get(i + 1);

            if (find(a) != find(b)) return false;
        }

        return true;
    }

    private static void printAnswer() {
        if (checkPossible()) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void solution() throws IOException {
        readInput();
        connect();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
