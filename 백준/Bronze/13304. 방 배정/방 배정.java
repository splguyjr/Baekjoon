import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static void solution() throws IOException {
        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int sum12 = 0;
        int boy34 = 0;
        int girl34 = 0;
        int boy56 = 0;
        int girl56 = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (grade <= 2) {
                sum12++;
            } else if (grade <= 4) {
                if (sex == 0) girl34++;
                else boy34++;
            } else {
                if (sex == 0) girl56++;
                else boy56++;
            }
        }

        int ans = 0;

        ans += (sum12 + k - 1) / k;
        ans += (boy34 + k - 1) / k;
        ans += (girl34 + k - 1) / k;
        ans += (boy56 + k - 1) / k;
        ans += (girl56 + k - 1) / k;

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
