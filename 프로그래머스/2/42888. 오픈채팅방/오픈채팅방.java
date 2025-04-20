import java.util.*;

class Solution {
    public List<String> solution(String[] record) {

        // ArrayList<String>, HashMap<String(uid), String(nickname)>형태로 저장하기
        // 시간복잡도 최소 nlogn으로 풀기
        // 어떻게 앞서 지나간 채팅들에 대해 닉네임 변경을 기록? -> UID에 대한 최종 닉네임만을 기억하기 -> HashMap<String(uid), String(nickname)
        // 매번 기록해놔야 하는 추가적인 정보 -> Enter or Leave, 어느 UUID? -> ArrayList<String> (E uid1234 식으로 저장)
        
        List<String> list = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        Map<String, String> uidNickMap = new HashMap<>();
        
        for (String s : record) {
            String[] arr = s.split(" ");
            String cmd = arr[0];
            String uid = arr[1];
        
            if (cmd.startsWith("E")) {
                String nick = arr[2];
                list.add("E " + arr[1]);
                uidNickMap.put(arr[1], arr[2]);
            }
            
            else if (cmd.startsWith("L")) {
                list.add("L " + arr[1]);
            }
            
            else {
                String nick = arr[2];
                uidNickMap.put(arr[1], arr[2]);
            }
        }
        
        for (String s : list) {
            String[] arr = s.split(" ");
            String cmd = arr[0];
            String uid = arr[1];
            String nick = uidNickMap.get(uid);
            
            if (cmd.equals("E")) {
                 answer.add(nick + "님이 들어왔습니다.");
            }
            
            else {
                answer.add(nick + "님이 나갔습니다.");
            }
            
        }
        
        return answer;
    }
}