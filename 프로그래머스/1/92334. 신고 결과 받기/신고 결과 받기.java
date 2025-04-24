import java.util.*;

class Solution {
    static Map<String, Set<String>> hm = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        // Map<String, HashSet<String>> -> 신고당한 이, 신고한 사람
        for (String s : report) {
            String[] arr = s.split(" ");
            String r1 = arr[0];
            String r2 = arr[1];
            if (!hm.containsKey(r2)) {
                hm.put(r2, new HashSet<>());
            }
            Set<String> set = hm.get(r2);
            set.add(r1);
            hm.put(r2, set);
        }
        
        // set의 크기가 k 이상인 경우 키를 신고처리 리스트에 담기
        List<String> list = new ArrayList<>();
        for (String key : hm.keySet()) {
            if (hm.get(key).size() >= k) {
                list.add(key);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (String reported : list) {
            Set<String> s = hm.get(reported);
            for (String x : s) {
                for (int i = 0; i < id_list.length; i++) {
                    if(id_list[i].equals(x)) {
                        answer[i] +=1;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}