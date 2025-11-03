import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[][] cost;    // 0이 white
    static long[][] dp;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        cost = new int[n][2];
        dp = new long[n][2];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree.get(p).add(c);
            tree.get(c).add(p);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    // 한 노드가 black이면 자식은 무조건 white, 한 노드가 white면 black vs white 중 더 최소 비용을 선택
    private static void treeDp(int curIdx, int parentIdx) {
        dp[curIdx][0] = cost[curIdx][0];
        dp[curIdx][1] = cost[curIdx][1];

        for (int adjIdx : tree.get(curIdx)) {
            if (adjIdx == parentIdx) continue;  // 이미 방문한 부모에 대해 다시 탐색하는 경우를 방지

            treeDp(adjIdx, curIdx);

            dp[curIdx][0] += Math.min(dp[adjIdx][0], dp[adjIdx][1]);
            dp[curIdx][1] += dp[adjIdx][0];
        }
    }

    private static void printAnswer() {
        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }

    private static void solution() throws IOException {
        readInput();
        treeDp(0, -1);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }

}
