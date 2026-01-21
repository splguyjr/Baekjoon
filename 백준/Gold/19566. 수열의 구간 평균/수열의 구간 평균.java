import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static long[] prefix;
    static Map<Long, Integer> hm = new HashMap<>();
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        prefix = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());

        }
    }

    private static void calPrefix() {
        hm.put((long)0, 1);   // prefix[0] - 0 * k = 0;

        for (int i = 1; i <= n; i++) {
            long diff1 = prefix[i] - (long) i * k;
            ans += hm.getOrDefault(diff1, 0);

            hm.put(diff1, hm.getOrDefault(diff1, 0) + 1);
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        calPrefix();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
