import java.util.*;

class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] isSummit;
    
    static class Node implements Comparable<Node> {
        int idx;
        int intensity; // 현재까지 누적된 경로중 최대 길이 저장
        
        Node(int idx, int intensity) {
            this.idx = idx;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.intensity, o.intensity);
        }
    }
    
    private static void dijkstra(int[] st) {
        for (int x : st) {
            pq.add(new Node(x, 0));
            dist[x] = 0;
        }
        
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.idx;
            int intensity = node.intensity;
            
            if (dist[idx] < intensity) continue;
            if (isSummit[idx]) continue;
            
            for (Node adj : list.get(idx)) {
                int adjIdx = adj.idx;
                int len = adj.intensity;
                
                int d = Math.max(dist[idx], len);
                // 현재점까지 최소 거리와 다음 정점까지의 거리 중 최댓값을 취해도 갱신가능한지 판단하기
                if (dist[adjIdx] > d) {
                    dist[adjIdx] = d;
                    pq.add(new Node(adjIdx, d));
                }
            }
        }
    }
    
    //다익스트라 기반으로 가되 -> 출발점으로부터 거리가 아니라 가중치를 여태거쳐간 간선의 최대길이로 갱신
    //산봉우리 테스트는 작은 번호부터 해야함
    //전체 시작점들을 어떻게 한번에 검사하지
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 산봉우리의 번호, intensity의 최솟값
        int[] answer = new int[2];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        dist = new int[n + 1];
        isSummit = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < summits.length; i++) {
            isSummit[summits[i]] = true;
        }
        
        for (int[] arr: paths) {
            int a = arr[0];
            int b = arr[1];
            int len = arr[2];
            
            list.get(a).add(new Node(b, len));
            list.get(b).add(new Node(a, len));
        }
        
        dijkstra(gates);
        
        // 갱신된 dist 배열에 대해 summit에 해당하는지 확인
        for (int i = 1; i <= n; i++) {
            if (isSummit[i] && dist[i] < answer[1]) {
                // answer[0]:산봉우리 번호, answer[1]:intensity 최솟값
                answer[0] = i;
                answer[1] = dist[i];
            }
        }
        
        return answer;
    }
}