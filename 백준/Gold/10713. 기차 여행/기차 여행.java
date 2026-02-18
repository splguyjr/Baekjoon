import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] prefix;
    static int[][] charge;
    static long ans = 0;

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

    private static void readInput() {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();

        prefix = new int[n + 1];
        charge = new int[n + 1][3];

        int st = reader.nextInt();
        for (int i = 0; i < m - 1; i++) {
            int dest = reader.nextInt();
            if (st > dest) {
                prefix[dest]++;
                prefix[st]--;
            }
            else {
                prefix[st]++;
                prefix[dest]--;
            }
            st = dest;
        }

        for (int i = 1; i <= n - 1; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();

            charge[i][0] = a;
            charge[i][1] = b;
            charge[i][2] = c;
        }
    }

    private static void calcPrefix() {
        for (int i = 1; i <= n; i++) {
            prefix[i] += prefix[i - 1];
        }
    }

    private static void calcMinPrice() {
        for (int i = 1; i <= n; i++) {
            int cnt = prefix[i];
            int price = Math.min(charge[i][0] * cnt, charge[i][2] + charge[i][1] * cnt);
            ans += price;
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() {
        readInput();
        calcPrefix();
        calcMinPrice();
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
