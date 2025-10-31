import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        int u, v;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }
    }

    private static void treeDp(int curIdx, int parent) {
        dp[curIdx][0] = 0;
        dp[curIdx][1] = 1;

        for (int adjIdx : tree.get(curIdx)) {
            if (adjIdx == parent) continue;

            else {
                treeDp(adjIdx, curIdx);
                dp[curIdx][0] += dp[adjIdx][1];
                dp[curIdx][1] += Math.min(dp[adjIdx][0], dp[adjIdx][1]);
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        treeDp(1, -1);  // 루트의 부모 노드는 -1로 처리
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void main(String[] args) throws IOException{
        Main.solution();
    }
}
