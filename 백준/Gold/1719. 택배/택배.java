import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static int[][] answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge> {
        int idx;
        int cost;

        Edge(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    private static void initializeDist() {
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    private static void readInput() throws IOException {
        String line = br.readLine();
        st = new StringTokenizer(line);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        answer = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }
    }

    private static void printRoute() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (answer[i][j] == 0)
                    sb.append("-");
                else sb.append(answer[i][j]);

                if (j != n)
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 다익스트라를 모든 정점을 기준으로 돌려야 하므로 매번 거리 INF 초기화
        initializeDist();

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        int[] temp  = new int[n + 1];

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int idx = cur.idx;
            int cost = cur.cost; // 현재 점까지의 누적 거리

            // 이미 다른 정점을 통해 더 최단거리로 갱신된 경우 건너뜀
            if (dist[idx] < cost) continue;

            // 현재 방문한 정점과 연결된 정점들 중에서
            for (Edge edge : graph.get(idx)) {
                // 현재 정점을 통해서 다음 연결된 정점으로 가는게 최단거리 갱신인 경우
                int nextIdx = edge.idx;
                int nextDist = edge.cost; // 현재 정점에서 연결된 다음 정점까지의 거리

                if (dist[nextIdx] > cost + nextDist) {
                    if (idx == start) {
                        answer[start][nextIdx] = nextIdx;
                    }
                    else {
                        answer[start][nextIdx] = answer[start][idx];
                    }
                    dist[nextIdx] = cost + nextDist;
                    pq.offer(new Edge(nextIdx, dist[nextIdx]));
                }
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        for (int i = 1; i <= n ; i++) {
            dijkstra(i);
        }
        printRoute();
    }


    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}