import java.util.*;

class Solution {
    static class User {
        int num;
        double faultRate;
        User(int num, double faultRate) {
            this.num = num;
            this.faultRate = faultRate;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2];//n이 5면 입력은 6까지
        
        for (int x : stages) {
            arr[x]++;
        }

        int len = stages.length;
        double[] ans = new double[N];
        User[] users = new User[N];

        for (int i = 0; i < N; i++) {
            if(len == 0) users[i] = new User(i+1, 0);
            else users[i] = new User(i+1, (double) arr[i+1] / len);
            len -= arr[i+1];
        }
        
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Double.compare(u2.faultRate, u1.faultRate); // 실패율 내림차순
            }
        });
        
        int[] f = new int[N];
        
        for (int i = 0; i < N; i++) {
            f[i] = users[i].num;
        }
        
        return f;
    }
}