import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[] start;
    static boolean[] goal;
    static boolean[] start2;
    static int cnt1 = 0, cnt2 = 0;
    static boolean b1 = true;
    static boolean b2 = true;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        start = new boolean[n];
        start2 = new boolean[n];
        goal = new boolean[n];

        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
            start[i] = s1.charAt(i) - '0' == 1;
            goal[i] = s2.charAt(i) - '0' == 1;
        }

        start2 = start.clone();
    }

    private static void checkFromLeft() {
        // 초기 전구를 키는 경우
        clickSwitch(0, start);
        cnt1++;
        for (int i = 1; i < n; i++) {
            if (start[i - 1] != goal[i - 1]) {
                clickSwitch(i, start);
                cnt1++;
            }
        }

        // 초기 전구를 키지 않는 경우
        for (int i = 1; i < n; i++) {
            if (start2[i - 1] != goal[i - 1]) {
                clickSwitch(i, start2);
                cnt2++;
            }
        }
    }

    private static void clickSwitch(int x, boolean[] start) {
        if (x != 0) {
            start[x - 1] = !start[x - 1];
        }
        if (x != n - 1) {
            start[x + 1] = !start[x + 1];
        }
        start[x] = !start[x];
    }

    private static void checkPossible() {
        for (int i = 0; i < n; i++) {
            if (start[i] != goal[i]) {
                b1 = false;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (start2[i] != goal[i]) {
                b2 = false;
                break;
            }
        }

        if (b1 && b2) {
            System.out.println(Math.min(cnt1, cnt2));
        }
        else if (b1) {
            System.out.println(cnt1);
        } else if (b2) {
            System.out.println(cnt2);
        }
        else {
            System.out.println(-1);
        }
    }

    private static void solution() throws IOException {
        readInput();
        checkFromLeft();
        checkPossible();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
