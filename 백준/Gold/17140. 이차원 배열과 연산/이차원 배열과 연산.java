import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int mr = 3, mc = 3;
    static int time = 0;
    static boolean flag = false;

    static class Number implements Comparable<Number> {
        int num;
        int cnt;

        Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number n) {
            // 등장 횟수 1순위, 숫자 2순위
            if (this.cnt == n.cnt) return Integer.compare(this.num, n.num);
            else {
                return Integer.compare(this.cnt, n.cnt);
            }
        }
    }

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 1 1 1
    // 1 1 1
    // 1 1 1

    // 1 3
    // 1 3
    // 1 3

    // 1 1 3 1
    // 1 1 3 1
    // 1 1 3 1


    private static void simulate() {
        while (time <= 100) {
            if (check()) {
                flag = true;
                return;
            }

            if (mr >= mc) {
                sortArrR();
            } else {
                sortArrC();
            }

            time++;
        }
    }

    private static void sortArrR() {
        int temp = 0;
        for (int i = 1; i <= mr; i++) {
            List<Number> list = new ArrayList<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= mc; j++) {
                if (arr[i][j] == 0) continue;
                hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0) + 1);
            }

            for (int num : hm.keySet()) {
                int cnt = hm.get(num);
                list.add(new Number(num, cnt));
            }

            int len = Math.min(100, list.size() * 2);
            temp = Math.max(temp, len);

            Collections.sort(list);

            for (int j = 0; j <= list.size() - 1 && j <= 49; j++) {
                Number number = list.get(j);
                int x = number.num;
                int y = number.cnt;

                arr[i][2 * j + 1] = x;
                arr[i][2 * (j + 1)] = y;
            }

            for (int j = len + 1; j <= 100 ; j++) {
                arr[i][j] = 0;
            }
        }
        mc = temp;
    }

    private static void sortArrC() {
        int temp = 0;
        for (int i = 1; i <= mc; i++) {
            List<Number> list = new ArrayList<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 1; j <= mr; j++) {
                if (arr[j][i] == 0) continue;
                hm.put(arr[j][i], hm.getOrDefault(arr[j][i], 0) + 1);
            }

            for (int num : hm.keySet()) {
                int cnt = hm.get(num);
                list.add(new Number(num, cnt));
            }

            int len = Math.min(100, list.size() * 2);
            temp = Math.max(len, temp);

            Collections.sort(list);

            for (int j = 0; j <= list.size() - 1&& j <= 49; j++) {
                Number number = list.get(j);
                int x = number.num;
                int y = number.cnt;

                arr[2 * j + 1][i] = x;
                arr[2 * (j + 1)][i] = y;
            }

            for (int j = len + 1; j <= 100 ; j++) {
                arr[j][i] = 0;
            }
        }
        mr = temp;
    }

    private static boolean check() {
        if (arr[r][c] == k) return true;
        else return false;
    }

    private static void printAnswer() {
        if (flag) System.out.println(time);
        else System.out.println("-1");
    }

    private static void solution() throws IOException {
        readInput();
        simulate();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
