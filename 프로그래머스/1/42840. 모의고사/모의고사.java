import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {{1,2,3,4,5},
                            {2,1,2,3,2,4,2,5},
                            {3,3,1,1,2,2,4,4,5,5}};
        
        int[] count = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if(answers[i] == patterns[j][i % patterns[j].length])
                    count[j]++;
            }
        }
        
        int max = 0;
        
        for (int i =0; i < 3; i++)
            max = Math.max(count[i], max);
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if(max == count[i]) list.add(i+1);
        }
        
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}