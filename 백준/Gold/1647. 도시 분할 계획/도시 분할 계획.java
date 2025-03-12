import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int house;
        int cost;

        public Edge(int house, int cost) {
            this.house = house;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        Long totalCost = 0L;
        int maxCost = 0;
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int house = poll.house;
            int cost = poll.cost;
            if(visited[house]) continue;
            visited[house] = true;
            totalCost += cost;
            maxCost = Math.max(maxCost, cost);
            for (Edge edge : graph[house]) {
                if(!visited[edge.house]) {
                    pq.offer(edge);
                }
            }
        }
        System.out.println(totalCost-maxCost);
    }
}