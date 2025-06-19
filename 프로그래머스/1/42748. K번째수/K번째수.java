import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] arr : commands) {
            int st = arr[0];
            int ed = arr[1];
            int len = arr[2];
            
            List<Integer> temp = new ArrayList<>();
            for (int i = st - 1; i < ed; i++) {
                temp.add(array[i]);
            }
            
            Collections.sort(temp);
            answer.add(temp.get(len-1));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}