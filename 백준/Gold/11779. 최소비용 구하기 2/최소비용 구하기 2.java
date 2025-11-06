import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static int goalS, goalE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int[] parent;

    static class Node implements Comparable<Node>{
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = INF;
            parent[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        goalS = Integer.parseInt(st.nextToken());
        goalE = Integer.parseInt(st.nextToken());

        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curIdx = node.idx;
            int costSum = node.cost;

            if (dist[curIdx] < costSum) continue;

            for (Node adjNode : graph.get(curIdx)) {
                int adjIdx = adjNode.idx;
                int cost = adjNode.cost;

                if (dist[adjIdx] > dist[curIdx] + cost) {
                    dist[adjIdx] = dist[curIdx] + cost;
                    parent[adjIdx] = curIdx;
                    pq.add(new Node(adjIdx, dist[adjIdx]));
                }
            }
        }
    }

    private static void calculatePath() {
        StringBuilder sb = new StringBuilder();

        sb.append(dist[goalE]);
        sb.append("\n");

        Deque<Integer> st = new ArrayDeque<>();

        int cur = goalE;

        while (cur != -1) {
            st.push(cur);
            cur = parent[cur];
        }

        sb.append(st.size());
        sb.append("\n");

        while (!st.isEmpty()) {
            int idx = st.pop();
            sb.append(idx);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }

    private static void solution() throws IOException {
        readInput();
        dijkstra(goalS);
        calculatePath();
    }

    public static void main(String[] args) throws IOException{
        Main.solution();
    }
}
