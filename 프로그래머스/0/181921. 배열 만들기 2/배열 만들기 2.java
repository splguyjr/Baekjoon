import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList();
        
        for(int i = l; i<=r; i++) {
            boolean flag = true;
            int num = i;
            while(num > 0) {
                if (num % 5 == 0 || num % 5 == 5) {
                    num /= 10;
                }
                else {flag = false; break;}
            }
            if(flag) list.add(i);
        }
        int[] answer = new int[list.size() > 0 ? list.size() : 1];
        if(list.size()== 0) answer[0]=-1;
        else {
            for(int i =0 ; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
}