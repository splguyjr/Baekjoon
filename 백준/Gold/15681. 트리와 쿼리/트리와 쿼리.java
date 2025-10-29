import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, r, q;
    static List<Integer>[] adjList;
    static List<Integer>[] childList;   // 자식을 담는 리스트 배열
    static int[] parentNode;            // 부모를 담는 배열, 루트는 0
    static boolean[] visited;           // 트리 순회시 방문 여부 관리
    static int[] dp;                    // 서브트리 내부 정점 개수 메모이제이션
    static int[] queryArr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return -1; // 입력 끝
            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    private static void readInput() throws IOException {
        n = nextInt();
        r = nextInt();
        q = nextInt();

        adjList = new List[n + 1];
        childList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
            childList[i] = new ArrayList<>();
        }
        parentNode = new int[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1];
        queryArr = new int[q];

        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = nextInt();
            v = nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i < q; i++) {
            queryArr[i] = nextInt();
        }
    }

    private static void scanSubtree(int idx, int parent) {
        visited[idx] = true;
        parentNode[idx] = parent;

        for (int node : adjList[idx]) {
            if (!visited[node]) {
                childList[idx].add(node);
                scanSubtree(node, idx);
            }
        }
    }

    private static int countSubtree(int root) {
        if (dp[root] != 0) return dp[root];
        else if (childList[root].isEmpty()) return dp[root] = 1;
        else {
            int sum = 1;
            for (int node : childList[root]) {
                sum += countSubtree(node);
            }
            return dp[root] = sum;
        }
    }

    private static void answerQuery() {
        StringBuilder sb = new StringBuilder();
        for (int idx : queryArr) {
            sb.append(dp[idx]).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void solution() throws IOException {
        readInput();
        scanSubtree(r, 0);  // 루트 노드의 부모는 없으므로 0
        countSubtree(r);
        answerQuery();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
