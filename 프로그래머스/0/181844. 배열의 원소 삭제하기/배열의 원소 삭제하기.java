import java.util.*;

class Solution {
    public List solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        
        //answer 동적 배열 생성 후 기존 원소들 전부 넣어주기, 이후 조건에 따라 삭제
        for (int i = 0; i < arr.length; i++) {
            answer.add(arr[i]);
        }
        
        for (int i = 0; i < delete_list.length; i++) {
            if (answer.contains(delete_list[i])) {
                answer.remove(Integer.valueOf(delete_list[i]));
            }
        }
        
        return answer;
    }
}