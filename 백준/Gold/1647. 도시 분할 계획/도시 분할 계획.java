import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static Edge[] edges;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        solve();
    }

    private static void solve() throws IOException {
        readInput();
        printResult(kruskalMST());
    }


    private static void readInput() throws IOException {
        readSize();
        initialize(N, M);
        readEdges(M);
    }

    private static void readSize() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }


    private static void initialize(int n, int m) {
        initializeParent(n);
        initializeEdges(m);
    }
    private static void initializeParent(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void initializeEdges(int m) {
        edges = new Edge[m];
    }

    private static void readEdges(int m) throws IOException {
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }
    }

    //totalCost와 maxCost를 동시에 리턴해야 하는 문제점
    private static long kruskalMST() {
        long totalCost = 0;     // 현재까지 선택한 간선들의 총 가중치 합
        int maxCost = 0;        // 현재까지 선택한 간선 중 가장 가중치가 큰 값
        int edgeCount = 0;      // 현재까지 선택한 간선의 개수

        sortEdges();

        for (Edge edge : edges) {
            if (union(edge.a, edge.b)) {
                totalCost += edge.cost;
                maxCost = Math.max(maxCost, edge.cost);
                edgeCount++;
                if (edgeCount == N - 1) break;
            }
        }

        return totalCost - maxCost;
    }

    private static void printResult(long result) {
        System.out.println(result);
    }

    private static void sortEdges() {
        Arrays.sort(edges);
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

        if (rootX == rootY) return false;
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