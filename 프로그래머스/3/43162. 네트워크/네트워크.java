import java.util.*;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(computers[i][j] == 1)
                    merge(i+1, j+1);
            }
        }
        
        Set<Integer> st = new HashSet<>();
        
        for (int i = 1; i <= n; i++) {
            st.add(find(i));
        }
        
        return st.size();
    }
    
    
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    public void merge(int x, int y) {
        int rootX  = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}