import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] diff;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        diff = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            diff[a] += k;
            diff[b + 1] -=k;
        }

        br.close();
    }

    // 3 0 0 0 -3
    private static void applyDifference() {
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            arr[i] += diff[i];
        }
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb.toString());
    }

    private static void solution() throws IOException {
        readInput();
        applyDifference();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
