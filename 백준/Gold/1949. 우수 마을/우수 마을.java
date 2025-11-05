import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<List<Integer>> tree = new ArrayList<>();
    static int[] people;
    static int[][] dp;


    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        people = new int[n + 1];
        dp = new int[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
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
        dp[curIdx][1] = people[curIdx];

        for (int adjIdx : tree.get(curIdx)) {
            if (adjIdx == parentIdx) continue;

            else {
                treeDp(adjIdx, curIdx);
                dp[curIdx][0] += Math.max(dp[adjIdx][0], dp[adjIdx][1]);
                dp[curIdx][1] += dp[adjIdx][0];
            }
        }
    }

    private static void printAnswer() {
        int maxSum = Math.max(dp[1][0], dp[1][1]);

        System.out.println(maxSum);
    }

    private static void solution() throws IOException {
        readInput();
        treeDp(1, -1);
        printAnswer();
    }

    public static void main(String[] args) throws IOException{
        Main.solution();
    }
}
