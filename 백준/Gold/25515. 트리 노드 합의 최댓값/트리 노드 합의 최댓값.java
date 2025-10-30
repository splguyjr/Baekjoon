import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] score;     // 각 노드에 적힌 정수
    static long[] dp;    // 해당 인덱스 노드를 루트로 한 서브트리의 정수 합 최댓값
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        score = new int[n];
        dp = new long[n];

        int p,c;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            tree.get(p).add(c);
            tree.get(c).add(p);
        }

        st = new StringTokenizer(br.readLine());

        int x = 0;
        while(st.hasMoreTokens()) {
            score[x] = Integer.parseInt(st.nextToken());
            x++;
        }
    }

    private static void dfs(int idx, int prev) {
        if (dp[idx] != 0) return;

        dp[idx] = score[idx];

        for (int adjIdx : tree.get(idx)) {
            if (prev != adjIdx) {   // 부모 노드를 다시 방문하는 경우를 방지
                dfs(adjIdx, idx);
                dp[idx] = Math.max(dp[idx], dp[idx] + dp[adjIdx]);  // 하위 서브트리 정점들의 합이 음수인 경우 포함하지 않아야 함
            }
        }
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append(dp[0]);
        System.out.println(sb.toString());
    }

    private static void solution() throws IOException {
        readInput();
        dfs(0, -1); // 루트의 부모는 없으므로 -1
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
