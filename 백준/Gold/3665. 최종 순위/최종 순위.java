import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int t, n;
    static int[] indegree;

    // 사이클이 없어야 함 -> indegree가 0인 점이 무조건 존재
    // 정답이 모호하지 않아야 함 -> indegree가 0인 점이 1개만 존
    private static void topologicalSort(List<Integer>[] adjList) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (q.size() == 0) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            if (q.size() >= 2) {
                System.out.println("?");
                return;
            }

            int curIdx = q.poll();
            sb.append(curIdx).append(" ");

            for (int adjIdx : adjList[curIdx]) {
                indegree[adjIdx]--;
                if (indegree[adjIdx] == 0)
                    q.offer(adjIdx);
            }
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            indegree = new int[n + 1];
            List<Integer>[] adjList = new ArrayList[n + 1];

            for (int j = 0; j < n + 1; j++) {
                adjList[j] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= n; k++) {
                    if (k != a && !adjList[k].contains(a)) {
                        adjList[a].add(k);
                        indegree[k]++;
                    }
                }
            }

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                Integer a = Integer.parseInt(st.nextToken());
                Integer b = Integer.parseInt(st.nextToken());

                if (adjList[a].contains(b)) {
                    adjList[a].remove(b);
                    adjList[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                }
                else {
                    adjList[b].remove(a);
                    adjList[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }
            topologicalSort(adjList);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
