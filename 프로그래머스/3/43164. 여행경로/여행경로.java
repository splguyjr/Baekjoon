import java.util.*;

class Solution {
    // "ICN" -> {"ATL", "SFO"}
    static Map<String, List<String>> graph = new HashMap<>();
    static List<String> answer = new ArrayList<>();
    static int cnt;
    
    public String[] solution(String[][] tickets) {
        cnt = tickets.length;
        fillGraph(tickets);
        dfs("ICN", 0);
        
        String[] ans = answer.toArray(String[]::new);
        return ans;
    }
    
    private static void fillGraph(String[][] tickets) {
        for (String[] flights : tickets) {
            String st = flights[0];
            String dt = flights[1];
            
            List<String> list = graph.getOrDefault(st, new ArrayList<String>());
            list.add(dt);
            Collections.sort(list);
            graph.put(st, list);
        }
    }
    
    // ICN에서 부터 시작해서 앞에서부터 연쇄적으로 방문, 방문한 자리는 지우기
    private static boolean dfs(String cur, int depth) {
        answer.add(cur);
        
        if (depth == cnt) {
            return true;
        }
        
        List<String> dests = graph.getOrDefault(cur, new ArrayList<>());
        
        // 티켓 사용 후 답에 도달 못하면 원상복구
        for (int i = 0; i < dests.size(); i++) {
            String next = dests.remove(i);
            if(dfs(next, depth + 1)) return true;
            dests.add(i, next);
        }
        
        answer.remove(answer.size() - 1);
        return false;
    }
}