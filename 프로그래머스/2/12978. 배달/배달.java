import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 인접 리스트 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 도로 정보 입력
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 최소 시간 저장 배열 (초기값: 큰 수)
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // 우선순위 큐 (시간 기준 최소 힙)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.time > dist[current.to]) continue;

            for (Node next : graph.get(current.to)) {
                int newTime = dist[current.to] + next.time;
                if (newTime < dist[next.to]) {
                    dist[next.to] = newTime;
                    pq.offer(new Node(next.to, newTime));
                }
            }
        }

        // K 이하로 배달 가능한 마을 수 카운트
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}

// Node 클래스: 마을 번호와 이동 시간 저장
class Node implements Comparable<Node> {
    int to;
    int time;

    public Node(int to, int time) {
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(Node other) {
        return this.time - other.time;
    }
}
