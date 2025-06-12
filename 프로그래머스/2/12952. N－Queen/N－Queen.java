class Solution {
    public int solution(int n) {
        int[] col = new int[n];
        return backtrack(0, n, col);
    }
    
    private int backtrack(int level, int n, int[] col) {
        if (level == n) {
            return 1;
        }

        int count = 0;
        
        // 해당 level의 0 ~ n-1번 위치에 대한 방문 처리
        for (int i = 0; i < n; i++) {
            col[level] = i;
            if (isPromising(level, col)) {
                count += backtrack(level + 1, n, col);
            }
        }
        return count;
    }

    // 유망성 체크: 같은 열, 같은 대각선 배제
    private boolean isPromising(int level, int[] col) {
        for (int i = 0; i < level; i++) {
            if (col[i] == col[level]) return false; // 같은 열
            if (Math.abs(level - i) == Math.abs(col[level] - col[i])) return false; // 대각선
        }
        return true;
    }
}
