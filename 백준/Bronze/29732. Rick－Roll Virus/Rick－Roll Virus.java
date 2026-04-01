import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[] virus;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        virus = new int[n + 1];
        result = new int[n + 1];

        String s = br.readLine();
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'R') virus[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (virus[i] == 1) {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 1 && j <= n) {
                        result[j] = 1;
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] == 1) cnt++;
        }

        if (cnt <= m) System.out.println("Yes");
        else System.out.println("No");
    }
}
