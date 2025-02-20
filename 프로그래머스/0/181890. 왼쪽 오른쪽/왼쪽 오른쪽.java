import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        List<String> list = new ArrayList<>();
        
        for(String s : str_list)
            list.add(s);
        
        int idx1 = list.indexOf("l");
        int idx2 = list.indexOf("r");
        List<String> ans;
        if(idx1 == -1 && idx2 == -1) return new String[]{};
        else if(idx1 == -1) {
            ans = new ArrayList<String>(list.subList(idx2 + 1, str_list.length));
        }
        
        else if(idx2 == -1) {
            ans = new ArrayList<String>(list.subList(0, idx1));
        }
   
        
        else if(idx1 < idx2) {
            ans = new ArrayList<String>(list.subList(0, idx1));
        }        
        else
            ans = new ArrayList<String>(list.subList(idx2 + 1, str_list.length));
        
        String[] answer = ans.stream().toArray(String[]::new);
        return answer;
    }
}