import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int sum1, sum2;
    static int ans1, ans2;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int stone = Integer.parseInt(st.nextToken());
            if (stone == 1) {
                sum1 += 1;
                if (sum2 + 1 > 0) sum2 = 0;
                else sum2 += 1;

                ans1 = Math.max(sum1, ans1);
                ans2 = Math.max(-sum2, ans2);
            }

            else {
                sum2 -= 1;
                if (sum1 - 1 < 0) sum1 = 0;
                else sum1 -= 1;

                ans1 = Math.max(sum1, ans1);
                ans2 = Math.max(-sum2, ans2);
            }

        }

        br.close();
    }

    private static void printAnswer() {
        System.out.println(Math.max(ans1, ans2));
    }

    public static void main(String[] args) throws IOException {
        readInput();
        printAnswer();
    }
}
