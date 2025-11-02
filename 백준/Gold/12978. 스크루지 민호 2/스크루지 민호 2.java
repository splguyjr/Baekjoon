import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static List<Integer>[] tree;
    static int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        tree = (List<Integer>[]) new List[n + 1];
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }
    }

    private static void treeDp(int curIdx, int parent) {
        dp[curIdx][0] = 0;
        dp[curIdx][1] = 1;

        for (int adjIdx : tree[curIdx]) {
            if (adjIdx == parent) continue;

            treeDp(adjIdx, curIdx);

            dp[curIdx][0] += dp[adjIdx][1];
            dp[curIdx][1] += Math.min(dp[adjIdx][0], dp[adjIdx][1]);
        }
    }

    private static void printAnswer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int minCity = Math.min(dp[1][0], dp[1][1]);
        bw.append(String.valueOf(minCity));
        bw.flush();
        bw.close();
    }

    private static void solution() throws IOException {
        readInput();
        treeDp(1, -1);
        printAnswer();
    }


    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}