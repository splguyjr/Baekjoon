import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int INF = 100001;
    static int[][] dist;
    static int[][] next;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                next[i][j] = -1;
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());

           dist[a][b] = Math.min(dist[a][b], c);
           next[a][b] = b;
        }

        br.close();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }

                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        floyd();
        printAnswer();
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb.append("0 ");
                else {
                    sb.append(dist[i][j]);
                    sb.append(" ");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }

        // 경로 복원하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    sb.append("0\n");
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    for (int k = i; k != j; k = next[k][j]) {
                        list.add(k);
                    }
                    list.add(j);

                    sb.append(list.size());
                    sb.append(" ");

                    for (int x : list) {
                        sb.append(x);
                        sb.append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
