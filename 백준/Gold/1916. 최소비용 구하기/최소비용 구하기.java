import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int ver;
        int cost;

        public Edge(int ver, int cost) {
            this.ver = ver;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <=N ; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int curVer = poll.ver;
            int curCost = poll.cost;

            if (dist[curVer] < curCost) continue;

            for (Edge edge : graph[curVer]) {
                if (dist[edge.ver] > curCost + edge.cost) {
                    dist[edge.ver] = curCost + edge.cost;
                    pq.offer(new Edge(edge.ver, dist[edge.ver]));
                }
            }
        }

        System.out.println(dist[end]);
    }
}