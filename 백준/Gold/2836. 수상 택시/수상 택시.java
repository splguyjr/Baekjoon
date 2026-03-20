import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<int[]> list;
    static long totalLen = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) list.add(new int[] {b, a});
        }

        Collections.sort(list, (a, b) -> {
            int x1 = a[0]; int y1 = a[1];
            int x2 = b[0]; int y2 = b[1];
            if (x1 == x2) return Integer.compare(y1, y2);
            else return Integer.compare(x1, x2);
        });
    }

    private static void calcDist() {
        int st = 0;
        int ed = 0;

        for (int[] route : list) {
            int x = route[0];
            int y = route[1];

            if (ed < x) {
                totalLen += ed - st;
                st = x;
                ed = y;
            }
            else ed = Math.max(ed, y);
        }

        totalLen += ed - st;
    }

    private static void printAnswer() {
        totalLen *= 2;
        totalLen += m;
        System.out.print(totalLen);
    }

    private static void solution() throws IOException {
        readInput();
        calcDist();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
