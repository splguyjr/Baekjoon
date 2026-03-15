import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            calcMinDay(n, a, b);
        }
    }

    private static void calcMinDay(long n, long a, long b) {
        long target = Math.min(a, b);
        long gold = 1L;

        for (int i = 0; i < n; i++) {
            gold *= 2L;
        }

        long day = 0;

        if ((target & 1L) == 1L) {
            System.out.println(n);
            return;
        }

        while (target != 0) {
            if (gold > target) {
                gold /= 2;
                day++;
            } else {
                target -= gold;
            }
        }

        System.out.println(day);
    }

    private static void solution() throws IOException {
        readInput();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
