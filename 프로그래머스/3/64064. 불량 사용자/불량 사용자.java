import java.util.*;

class Solution {
    //중복제거에는 Set<Integer> -> Integer는 비트 상태값 이용하기, dfs + 백트래킹으로 user_id하나하나 돌면서 매칭시켜보기
    static Set<Integer> s = new HashSet<>();
    
    private static boolean match(String user, String banned) {
        if (user.length() != banned.length()) return false;
        for (int i = 0; i < banned.length(); i++) {
            char c1 = banned.charAt(i);
            if (c1 == '*') continue;
            if (c1 != user.charAt(i)) return false;
        }
        return true;
    }
    
    private void dfs(int depth, int mask, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            s.add(mask);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if ((mask & (1 << i)) == 0) {
                if (match(user_id[i], banned_id[depth]))
                    dfs(depth + 1, mask | (1 << i), user_id, banned_id);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0, user_id, banned_id);
        
        return s.size();
    }
}