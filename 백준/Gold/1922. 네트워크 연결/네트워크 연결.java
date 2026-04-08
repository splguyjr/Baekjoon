import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 프림
    // 들어온 정점을 통해 업데이트가 가능한지 확인하고, 다시 큐에 넣음

    // 크루스칼
    // Union-Find로 사이클이 발생하는지 판단

    static int n, m;
    static int a, b, c;
    static Edge[] edges;
    static int[] parent;
    static int ans = 0;

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int len;

        Edge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.len, e.len);
        }

    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        edges = new Edge[m];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges);
    }
    
    private static void kruskal() {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (cnt == n - 1) return;
            Edge edge = edges[i];
            int x = edge.x;
            int y = edge.y;
            int len = edge.len;

            if (find(x) != find(y)) {
                ans += len;
                union(x, y);
                cnt++;
            }
        }
    }

    private static int find(int x) {
        return parent[x] = (parent[x] == x) ? x : find(parent[x]);
    }

    private static boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        else {
            parent[px] = py;
            return true;
        }
    }

    private static void printAnswer() {
        System.out.print(ans);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        kruskal();
        printAnswer();
    }

}