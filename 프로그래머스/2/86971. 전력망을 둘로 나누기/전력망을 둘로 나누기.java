import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // i번째 간선은 제거한 상태로 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            // BFS로 한쪽 서브트리의 크기 측정
            boolean[] visited = new boolean[n + 1];
            int count = bfs(1, graph, visited);
            int diff = Math.abs(count - (n - count));

            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    private int bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }

        return count;
    }
}