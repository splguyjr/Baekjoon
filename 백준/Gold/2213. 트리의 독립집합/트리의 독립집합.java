import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] w;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    static List<Integer> path = new ArrayList<>();

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n + 1];
        dp = new int[n + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
    }

    private static void treeDp(int curIdx, int parentIdx) {
        dp[curIdx][0] = 0;
        dp[curIdx][1] = w[curIdx];

        for (int adjIdx : tree.get(curIdx)) {
            if (adjIdx == parentIdx) continue;

            treeDp(adjIdx, curIdx);
            dp[curIdx][0] += Math.max(dp[adjIdx][0], dp[adjIdx][1]);
            dp[curIdx][1] += dp[adjIdx][0];
        }
    }

    private static void calcPath(int curIdx, int parentIdx, boolean parentSelected) {
        boolean include = !parentSelected && (dp[curIdx][1] > dp[curIdx][0]);
        if (include) path.add(curIdx);


        for (int adjIdx : tree.get(curIdx)) {
            if (adjIdx != parentIdx) calcPath(adjIdx, curIdx, include);
        }
    }

    private static void printAnswer() {
        System.out.println(Math.max(dp[1][0], dp[1][1]));
        Collections.sort(path);
        StringBuilder sb = new StringBuilder();
        for (int x : path) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    private static void solution() throws IOException {
        readInput();
        treeDp(1, -1);
        calcPath(1, -1, false);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
