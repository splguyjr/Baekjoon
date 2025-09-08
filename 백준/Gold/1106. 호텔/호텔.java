import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int c, n;
    static int[] dp;  // i번째 요소까지 담을 수 있을 때 최소 금액
    static List<Node> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node {
        int cost;
        int gain;

        Node(int cost, int num) {
            this.cost = cost;
            this.gain = num;
        }
    }

    private static void readInput() throws IOException {
        String line = br.readLine();
        st = new StringTokenizer(line);
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        dp = new int[c+1];

        for (int i = 0; i <= c; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        int cost, gain;   // 비용, 비용으로 확보가능한 고객 수

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            cost = Integer.parseInt(st.nextToken());
            gain = Integer.parseInt(st.nextToken());
            list.add(new Node(cost, gain));
        }
    }

    private static void dp() {
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 1; j <= c; j++) {
                int cost = list.get(i-1).cost;
                int gain = list.get(i-1).gain;

                if (j <= gain) { // 한번의 비용으로 확보 가능한 고객 수가 현재 목표보다 큰 경우 최소로 초기화
                    dp[j] = Math.min(dp[j], cost);
                    continue;
                }

                dp[j] = Math.min(dp[j-gain] + cost, dp[j]);
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        dp();
        System.out.println(dp[c]);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}