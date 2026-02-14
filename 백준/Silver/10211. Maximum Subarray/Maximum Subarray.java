import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int t;
    
    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int temp = 0;
            int ans = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                temp = temp > 0 ? cur + temp : cur;
                ans = Math.max(temp, ans);
            }

            System.out.println(ans);
        }
    }
    
    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
