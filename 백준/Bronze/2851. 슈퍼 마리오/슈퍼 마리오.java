import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int ans = 0;
        
        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
            if (sum > 100) {
                if (sum - 100 <= 100 - ans) {
                    ans = sum;
                }
            } else ans = sum;
        }
        
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
