import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final Long INF = Long.MAX_VALUE / 2;
    static int n, m, d, e;  // 지점 개수, 경로 개수, 체력 소모량, 높이 비례 성취감
    static int[] height;
    static long[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    static long maxPoint = Long.MAX_VALUE * -1;

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        height = new int[n + 1];
        dist = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, n));
            graph.get(b).add(new Node(a, n));
        }
    }

    // 출발지점에서 다른 지점까지 최단 거리 계산
    private static long[] dijkstra(int start) {
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int curIdx = poll.idx;
            long costSum = poll.cost;   // 현재 지점까지 누적 거리

            if (dist[curIdx] < costSum) continue;

            for (Node adjNode : graph.get(curIdx)) {
                int adjIdx = adjNode.idx;
                long cost = adjNode.cost;

                if ((dist[adjIdx] > dist[curIdx] + cost) && height[curIdx] < height[adjIdx]) {
                    dist[adjIdx] = dist[curIdx] + cost;
                    pq.offer(new Node(adjIdx, dist[adjIdx]));
                }
            }
        }

        return dist.clone();
    }

    private static long calcMax() {
        long[] larr1 = dijkstra(1);
        long[] larr2 = dijkstra(n);

        for (int i = 2; i <= n - 1; i++) {
            if (larr1[i] != INF && larr2[i] != INF) {
                long point = height[i] * e - (larr1[i] + larr2[i]) * d;
                maxPoint = Math.max(maxPoint, point);
            }
        }

        return maxPoint;
    }

    private static void printAnwer() {
        if (maxPoint == -1 * Long.MAX_VALUE) {
            System.out.println("Impossible");
        }
        else {
            System.out.println(maxPoint);
        }
    }

    private static void solution() throws IOException {
        readInput();
        calcMax();
        printAnwer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}