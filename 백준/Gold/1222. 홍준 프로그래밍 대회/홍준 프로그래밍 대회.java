import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] freq;  // 학교들의 인원 분포 수 저장
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
    }

    private static void readInput() throws IOException {
        Reader reader = new Reader();

        n = reader.nextInt();

        freq = new int[2000001];

        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            freq[num]++;
        }
    }

    private static void checkDivisor() {
        for (int i = 1; i <= 2000000; i++) {
            int cnt = 0;
            for (int j = 1; i * j <= 2000000; j++) {
                if (freq[i * j] != 0) {
                    cnt += freq[i * j];
                }
            }

            if (cnt >= 2) {
                ans = Math.max(ans, (long)i * cnt);
            }
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        checkDivisor();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
