class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];
        
        int idx = 0;
        for (long num : numbers) {
            if (num % 2 == 0) {
                answer[idx++] = num + 1;
            }
            else {
                answer[idx++] = closest(num);
            }
        }
        
        return answer;
    }
    
    private static long closest(long num) {
        int idx = 0;
        long x = num;
        while (num % 2 == 1) {
            idx++;
            num /= 2;
        }
        
        // 탈출한 시점 idx 자리가 최초 만나는 0
        
        return x + (1L << (idx - 1));
    }
}