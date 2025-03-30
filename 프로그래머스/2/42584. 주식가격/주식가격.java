import java.util.*;

class Solution {
    // 1 2 3 3 2 3
    //     2 1      -> for문 돌면서 현재 확인하고 있는 prices[i]에 대해 이전에 넣었던 가격 prices[st.peek()]가 더 크지 않은 시점까지 확인 후 업데이트, 이후 stack에 남은 모든 인덱스 위치의 가격들은 오름차순(<=)임.  
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            answer[st.peek()] = prices.length - st.peek() - 1;
            st.pop();
        }
        
        return answer;
    }
}