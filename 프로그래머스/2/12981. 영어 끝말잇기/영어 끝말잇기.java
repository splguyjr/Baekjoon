import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        int len = words.length;
        Set<String> s = new HashSet<>();
        
        // 끝말잇기를 준수하지 않았는지 확인하면서, 각각의 사용자의 set에 add하면서 중복되지 않았는지 추가로 확인
        int idx = 0;
        for (int i = 0; i <len - 1; i++) {
            char cEnd = words[i].charAt(words[i].length()-1);
            char cStart = words[i+1].charAt(0);
            int x = i % n + 1; // 몇번째 사람인지
            int y = i / n + 1; // 몇번째 세트인지
            
            // 현재 단어가 이미 set에 있는 경우 -> 현재 사람 탈락
            // 이거부터 검사해야함..(현재 단어끝과 다음 단어 시작 비교 처리보다 먼저)
            if(s.contains(words[i])) {
                return new int[] {x,y};
            }
            
            // 다음 단어 시작 알파벳이 끝 알파벳이랑 다를때 -> 다음 사람 탈락
            if(cStart != cEnd) { 
                int a = (i+1) % n + 1;
                int b = (i+1) / n + 1;
                return new int[] {a,b};
            }
            s.add(words[i]);
        }
        
        //마지막 원소 중복 여부 검사
        if(s.contains(words[len-1])) {
            int x = (len-1) % n + 1;
            int y = (len-1) / n + 1;
            return new int[] {x,y};
        }
        return new int[] {0,0};
    }
}