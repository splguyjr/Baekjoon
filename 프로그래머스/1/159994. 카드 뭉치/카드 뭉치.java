import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        List<String> goalList = Arrays.asList(goal);
        
        for(String s : cards1) {
            q1.offer(s);
        }
        
        for(String s : cards2) {
            q2.offer(s);
        }
        
        boolean check = true;
        
        
        for(String s : goalList) {
            boolean checkPopped = false;
            if(!q1.isEmpty()) {
            if(q1.peek().equals(s)) {
                System.out.println(q1.poll());
                checkPopped = true;
            }}
            
            if(checkPopped) continue;
            
            if (!q2.isEmpty()) {
                if (q2.peek().equals(s)) {
                System.out.println(q2.poll());
                checkPopped = true;
            }}
            
            if(!checkPopped) {
                check = false;
                break;
            }
        }
        
        if(check == true) {
            return "Yes";
        } else {
            return "No";
        }
        
    }
}