import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];   // 회의 갯수 * (시작 시간/ 종료 시간)
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());  // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken());  // 종료 시간
        }

        // 종료시간이 빠른 순, 시작 시간이 빠른 순으로 정렬
        // 1 3 , 2 3, 3 3의 경우 1 3, 3, 3이 처리되도록

        Arrays.sort(time, (a1, a2) -> {
            if(a1[1] == a2[1]) return a1[0] - a2[0];
            return a1[1] - a2[1];
        });

        int currentEndTime = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (currentEndTime <= time[i][0]) {
                currentEndTime = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}