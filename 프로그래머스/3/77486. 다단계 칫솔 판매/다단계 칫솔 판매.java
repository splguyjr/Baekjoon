import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> hm = new HashMap<>();
        
        //HashMap<판매원, 판매원 추천인>
        for (int i = 0; i < enroll.length; i++) {
            hm.put(enroll[i], referral[i]);
        }
        
        HashMap<String, Integer> result = new HashMap<>();
        //seller, amount 읽으면서 하위 노드에서 '-'노드 혹은 돈이 < 10인 경우까지 반복하며 이익 더해줌
        
        for (int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            String sellerNode = seller[i];
            while(!sellerNode.equals("-") && money > 0) {
                int profit = money - money / 10;// 12 -> 11
                money = money / 10; // 12 -> 1
                result.put(sellerNode, result.getOrDefault(sellerNode ,0) + profit);
                sellerNode = hm.get(sellerNode);
            }
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            int value = result.getOrDefault(enroll[i], 0);
            answer[i] = value;
        }
        
        return answer;
    }
}