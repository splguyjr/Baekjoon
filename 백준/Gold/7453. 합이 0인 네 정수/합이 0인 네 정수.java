import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] a, b, c, d;
    static int[] ab, cd;
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        ab = new int[n * n];
        cd = new int[n * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sortAndAdd() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[n * i + j] = a[i] + b[j];
                cd[n * i + j] = c[i] + d[j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);
    }

    private static void countSumZero() {
        for (int i = 0; i < n * n; i++) {
            int x = ab[i];

            ans += upper_bound(-x) - lower_bound(-x);
        }
    }

    // x 초과가 처음 나오는 위치
    private static int lower_bound(int x) {
        int left = 0;
        int right = cd.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (cd[mid] >= x) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    // x 이상이 처음 나오는 위치
    private static int upper_bound(int x) {
        int left = 0;
        int right = cd.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (cd[mid] > x) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static void printAnswer() {
        System.out.print(ans);
    }

    private static void solution() throws IOException {
        readInput();
        sortAndAdd();
        countSumZero();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
