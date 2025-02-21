class Solution {
    static int n;
    static int[] arr;
    static int ans = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        arr = new int[n];
        visited = new boolean[n];
        dfs(0, dungeons, k);
        return ans;
    }
    
    public static void dfs(int depth, int[][] dungeons, int k) {
        if (depth == n) {
            ans = Math.max(ans, check(arr, dungeons, k));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1, dungeons, k);
                visited[i] = false;
            }
        }
    }
    
    public static int check(int[] arr, int[][] dungeons, int k) {
        int cnt = 0;
        for (int x : arr) {
            int limit = dungeons[x][0];
            int use = dungeons[x][1];
            if(k >= limit) {
                k -= use;
                cnt++;
            }
        }
        return cnt;
    }
    
}