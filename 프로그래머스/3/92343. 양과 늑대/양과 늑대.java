import java.util.*;

// 풀이 참조함
class Solution {
    
    public static class Info {
        int node, sheep, wolf;  // 방문 노드 위치, 현재까지 
        HashSet<Integer> visitable; // 방문할 예정인 노드들 저장
        
        public Info(int node, int sheep, int wolf, HashSet<Integer> visitable){
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visitable = visitable;
        }
    }
    
    static ArrayList<Integer>[] tree;
    static Queue<Info> q = new LinkedList<>();
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 부모 -> 자식 순서로 접근할 수 있도록 트리 구조 저장
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }
        
        // 초기값 0 위치는 항상 양으로 시작
        q.offer(new Info(0, 1, 0, new HashSet<>()));
        
        // bfs 탐색
        while (!q.isEmpty()) {
            Info now = q.poll();
            answer = Math.max(answer, now.sheep);
            // 인접한 노드들 방문 예정 set에 추가
            for (int next : tree[now.node]) {
                now.visitable.add(next);
            }
            
            for (int next : now.visitable) {
                HashSet<Integer> set = new HashSet<>(now.visitable);
                set.remove(next);   // 다음 노드에 자기 자신은 뺀 채로 방문할 노드 리스트를 저장
                
                // 다음 방문할 노드가 늑대일때
                if (info[next] == 1) {
                    // 늑대가 한 마리 늘어날때 양과 같아지면 방문 불가능
                    if (now.sheep != now.wolf + 1) {
                        q.add(new Info(next, now.sheep, now.wolf+1, set));
                    }
                }
                
                // 다음 방문할 노드가 양일때
                else {
                    q.add(new Info(next, now.sheep+1, now.wolf, set));
                }   
            }
        }
        
        return answer;
    }
}
