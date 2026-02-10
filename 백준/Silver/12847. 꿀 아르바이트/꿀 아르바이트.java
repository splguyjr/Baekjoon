import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[] prefix;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        prefix = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n - m + 1; i++) {
            sum = Math.max(sum, prefix[i + m - 1] - prefix[i - 1]);
        }

        System.out.println(sum);
    }
}
