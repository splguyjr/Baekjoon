import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] prefix;

    static long cnt = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    private static void hashingPrefixSum() {
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int prefixSum = prefix[i];
            cnt += hm.getOrDefault(prefixSum - k, 0);

            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }
    }

    private static void printAnswer() {
        System.out.println(cnt);
    }

    private static void solution() throws IOException {
        readInput();
        hashingPrefixSum();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
