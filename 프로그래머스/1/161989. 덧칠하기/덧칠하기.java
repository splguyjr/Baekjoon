import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] visited = new boolean[n];
        
        int min = section[0] - 1;
        int max = section[section.length-1] - 1;
        
        for(int i = 0; i < visited.length; i++)
            visited[i] = true;
        
        for(int i = 0; i < section.length; i++) {
            visited[section[i] - 1] = false;
        }
        
        int cnt = 0;
        for(int i = min; i <= max; i++) {
            if (!visited[i]) {
                for(int j = 0; j < m; j++) {
                    if(i + j <= max)
                        visited[i + j] = true;
                }
                i = i + m - 1;
                cnt++;
            }
        }
        
        return cnt;
    }
}