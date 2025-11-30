import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Node[] arr;

    static class Node implements Comparable<Node> {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Node(x, y);
        }

        Arrays.sort(arr);
    }

    private static int dp() {
        int[] dp = new int[n];
        int mx = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int y1 = arr[i].y;
                int y2 = arr[j].y;

                if (y1 > y2)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
            mx = Math.max(mx, dp[i]);
        }

        return mx;
    }

    private static void solution() throws IOException {
        readInput();
        System.out.println(n - dp());
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
