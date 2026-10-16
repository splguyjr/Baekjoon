import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        
        int[] parent = new int[n];
        for (int[] e : edges)  parent[e[1]] = e[0];
        
        int sheepMask = 0;
        for (int i = 0; i < n; i++) {
            if (info[i] == 0) sheepMask |= 1 << i;
        }
        
        boolean[] seen = new boolean[1 << n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        seen[1 << 0] = true;
        int answer = 0;
        
        while (!q.isEmpty()) {
            int mask = q.poll();
            int sheep = Integer.bitCount(mask & sheepMask);
            int wolf = Integer.bitCount(mask) - sheep;
            answer = Math.max(answer, sheep);
            
            for (int v = 1; v < n; v++) {
                // 방문한 경우
                if ((mask & (1 << v)) != 0) continue;
                // 부모는 방문한 경우 확인
                if ((mask & (1 << parent[v])) == 0) continue;
                
                int next = mask | (1 << v);
                if (seen[next]) continue;
                
                int ns = sheep + (info[v] == 0 ? 1 : 0);
                int nw = wolf + (info[v] == 1 ? 1 : 0);
                if (ns <= nw) continue;
                
                seen[next] = true;
                q.add(next);
            }
        }
        
        return answer;
    }
}