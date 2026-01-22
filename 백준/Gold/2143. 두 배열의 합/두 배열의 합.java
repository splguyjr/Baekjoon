import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int t, n, m;
    static int[] prefixA;
    static int[] prefixB;
    static Map<Integer, Integer> hma = new HashMap<>();
    static Map<Integer, Integer> hmb = new HashMap<>();
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        prefixA = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixA[i] = prefixA[i - 1] + Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        prefixB = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            prefixB[i] = prefixB[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    private static void calcSubArraySum() {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                // i~j의 부분합 저장
                int sum = prefixA[j] - prefixA[i - 1];
                hma.put(sum, hma.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                // i~j의 부분합 저장
                int sum = prefixB[j] - prefixB[i - 1];
                hmb.put(sum, hmb.getOrDefault(sum, 0) + 1);
            }
        }
    }

    private static void countMatchingCase() {
        for (int key : hma.keySet()) {
            int cntA = hma.get(key);

            int matchKey = t - key;
            ans += (long) cntA * hmb.getOrDefault(matchKey, 0);
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        calcSubArraySum();
        countMatchingCase();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
