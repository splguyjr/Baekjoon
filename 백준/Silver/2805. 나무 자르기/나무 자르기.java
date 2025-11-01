import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] tree;
    static long ans = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void readInput() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
    }

    private static boolean check(int x) {
        long sum = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (tree[i] > x) {
                sum += tree[i] - x;
            }
        }

        if (sum >= m) return true;
        else return false;
    }

    private static void binarySearch() {
        int left = 0;
        int right = tree[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            // 나무 길이 합이 충분하므로 더 높이 잘라야 함
            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }
    }

    private static void solution() throws IOException {
        readInput();
        binarySearch();
        System.out.println(ans);
    }


    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}