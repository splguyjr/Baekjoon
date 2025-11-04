import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int x, y, z;
    static List<List<Node>> map = new ArrayList<>();
    static long[] dist;
    static final long INF = Long.MAX_VALUE;
    static PriorityQueue<Node> pq;

    static class Node implements Comparable<Node> {
        int x;
        long cost;

        Node(int x, long cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.cost, node.cost);
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            map.add(new ArrayList<>());
        }

        dist = new long[n + 1];

        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
    }

    private static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int curIdx = node.x;
            long curCost = node.cost;

            if (curCost > dist[curIdx]) continue;

            for (Node adjNode : map.get(curIdx)) {
                int adjIdx = adjNode.x;
                long cost = adjNode.cost;

                if (dist[adjIdx] > dist[curIdx] + cost) {
                    dist[adjIdx] = dist[curIdx] + cost;
                    pq.offer(new Node(adjIdx, dist[adjIdx]));
                }
            }
        }
    }

    // y를 거치지 않고 최단 거리 계산
    private static void dijkstra1(int start, int y) {
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int curIdx = node.x;
            long curCost = node.cost;

            if (curCost > dist[curIdx]) continue;

            for (Node adjNode : map.get(curIdx)) {
                int adjIdx = adjNode.x;
                long cost = adjNode.cost;

                if (adjIdx == y) continue;

                if (dist[adjIdx] > dist[curIdx] + cost) {
                    dist[adjIdx] = dist[curIdx] + cost;
                    pq.offer(new Node(adjIdx, dist[adjIdx]));
                }
            }
        }
    }

    // x에서 y를 거쳐 z에 도달하는 최단거리 + 그냥 x에서 z에 도달하는 최단 거리 계산
    private static void calcMinDist() {
        dijkstra(x);
        long x_y = dist[y];
        dijkstra(y);
        long y_z = dist[z];

        dijkstra1(x, y);
        long x_z = dist[z];

        StringBuilder sb = new StringBuilder();

        long dist_xyz;
        long dist_xz;

        if (x_y == INF || y_z == INF)
            dist_xyz = -1;
        else
            dist_xyz = x_y + y_z;

        if (x_z == INF)
            dist_xz = -1;
        else
            dist_xz = x_z;

        sb.append(dist_xyz + " " + dist_xz);
        System.out.println(sb);
    }

    private static void solution() throws IOException {
        readInput();
        calcMinDist();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
