import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        
        for(String st : intStrs) {
            String temp = "";
            char[] carr = st.toCharArray();
            for(int i =s; i< s+l; i++) {
                temp += carr[i];
            }
            if(k < Integer.parseInt(temp))
                list.add(Integer.parseInt(temp));
        }

        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}