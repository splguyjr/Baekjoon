import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] t = new int[n + 1][n + 1];  // 삼각형 데이터 저장
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
                t[i][j] += Math.max(t[i-1][j-1], t[i-1][j]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(t[n][i], ans);
        }

        System.out.println(ans);
    }
}