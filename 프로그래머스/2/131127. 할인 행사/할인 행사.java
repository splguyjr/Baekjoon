import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            hm.put(want[i], number[i]);
        }
        
        boolean flag;

        
        for (int i = 0; i < discount.length - 10 + 1; i++) {
            // 10일동안의 할인 정보를 추적
            HashMap<String, Integer> dMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                //j번째 날짜의 할인항목이 이미 Map에 있으면 1로 저장, 아니면 기존 value값 + 1로 저장
                dMap.put(discount[i+j], dMap.getOrDefault(discount[i+j], 0) + 1);
            }
            
            boolean check = true;
            for (String key : hm.keySet()) {
                if (hm.get(key) != dMap.get(key)) {
                    check = false;
                    break;
                }
            }
            
            if (check) answer += 1;
            
        }
        
        return answer;
    }
}