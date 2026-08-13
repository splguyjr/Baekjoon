import java.util.*;

class Solution {
    static Map<Character, Integer> m = new HashMap<Character, Integer>();
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int idx = 0;
        for (char c : skill.toCharArray()) {
            m.put(c, idx++);
        }
        
        for (String s : skill_trees) {
            int curSeq = 0;
            if(check(skill, s, curSeq)) answer++;
        }
        
        return answer;
    }
    
    private static boolean check(String skill, String tree, int curSeq) {
        for (char c : tree.toCharArray()) {
            if (m.containsKey(c)) {
                if (m.get(c) == curSeq) {
                    curSeq++;
                } else return false;
            }
        }
        return true;
    }
}