import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, x;
    static int[] prefix;
    static int ans = 0;
    static int mxCnt = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }
    }

    private static void calculateMaxVisitor() {
        for (int i = 1; i <= n - x + 1; i++) {
            int p = prefix[i + x - 1] - prefix[i - 1];
            if (ans == p) {
                mxCnt++;
            }
            else if (ans < p) {
                ans = p;
                mxCnt = 1;
            }
        }
    }

    private static void printAnswer() {
        if (ans == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(ans);
            System.out.println(mxCnt);
        }
    }

    private static void solution() throws IOException {
        readInput();
        calculateMaxVisitor();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
