import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[] parent;
    static int[] cost;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        cost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (cost[px] > cost[py]) {
                parent[px] = py;
            }
            else parent[py] = px;
        }
    }

    private static int calMinCost() {
        Set<Integer> s = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            s.add(find(i));
        }

        int sum = 0;

        for (int x : s) {
            sum += cost[x];
        }

        return sum;
    }

    private static void printAnswer() {
        int minCost = calMinCost();

        if (minCost <= k) {
            System.out.println(minCost);
        }

        else System.out.println("Oh no");
    }

    private static void solution() throws IOException {
        readInput();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
