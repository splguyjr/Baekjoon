import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge{
        int ver;
        Long cost;

        public Edge(int ver, Long cost) {
            this.ver = ver;
            this.cost = cost;
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

        Long[] dist = new Long[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Long cost = (long) Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Math.toIntExact(e1.cost - e2.cost));

        pq.offer(new Edge(start, 0L));
        dist[start] = 0L;
        
        while (!pq.isEmpty()) {
            Edge poll = pq.poll();
            int curVer = poll.ver;
            Long curCost = poll.cost;
            
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