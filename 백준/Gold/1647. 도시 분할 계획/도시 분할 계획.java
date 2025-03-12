import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static Edge[] edges;
    static BufferedReader br;
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        initialize(N);
        readEdges(br, M);
        Arrays.sort(edges);

        long result = kruskalMST(N);
        System.out.println(result);
    }

    private static void initialize(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void readEdges(BufferedReader br, int m) throws IOException {
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }
    }

    private static long kruskalMST(int n) {
        long totalCost = 0;
        long maxCost = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (union(edge.a, edge.b)) {
                totalCost += edge.cost;
                maxCost = Math.max(maxCost, edge.cost);
                edgeCount++;
                if (edgeCount == n - 1) break; // 최소 스패닝 트리 완성
            }
        }

        return totalCost - maxCost; // 가장 비싼 간선을 제거
    }

    private static int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false; // 같은 집합이면 스킵
        parent[rootY] = rootX;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int a, b, cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}