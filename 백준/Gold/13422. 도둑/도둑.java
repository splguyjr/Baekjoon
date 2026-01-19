import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int n, m, k;
    static int[] prefix;

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void solve() throws IOException {
        Reader reader = new Reader();
        StringBuilder sb = new StringBuilder();

        t = reader.nextInt();

        for (int i = 0; i < t; i++) {
            n = reader.nextInt();
            m = reader.nextInt();
            k = reader.nextInt();

            prefix = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                prefix[j] = prefix[j - 1] + reader.nextInt();
            }

            sb.append(countPossible()).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

        reader.close();
    }

    private static int countPossible() {
        int cnt = 0;

        if (n == m) {
            if (prefixSum(1) < k) return 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (prefixSum(i) < k) cnt++;
        }

        return cnt;
    }

    private static int prefixSum(int st) {
        int ed;

        if (st + m - 1 > n) {
            ed = (st + m - 1) % n;
            return prefix[n] - prefix[st - 1] + prefix[ed];
        }

        else {
            ed = st + m - 1;
            return prefix[ed] - prefix[st - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        Main.solve();
    }
}
