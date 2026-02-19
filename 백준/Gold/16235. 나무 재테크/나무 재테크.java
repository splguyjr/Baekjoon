import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, k;
    static int[] a;
    static int[] nut;
    static Deque<Integer>[] tree;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

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

        void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readInput() {
        Reader reader = new Reader();
        n = reader.nextInt();
        m = reader.nextInt();
        k = reader.nextInt();

        a = new int[n * n];
        nut = new int[n * n];
        tree = new ArrayDeque[n * n];

        for (int i = 0; i < n * n; i++) {
            tree[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i * n + j] = reader.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nut[i * n + j] = 5;
            }
        }

        List<Integer>[] list = new ArrayList[n * n];
        for (int i = 0; i < n * n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = reader.nextInt() - 1;
            int y = reader.nextInt() - 1;
            int z = reader.nextInt();

            list[x * n + y].add(z);
        }

        for (int i = 0; i < n * n; i++) {
            Collections.sort(list[i]);
            for (int age : list[i]) tree[i].addLast(age);
        }
    }

    private static void simulateYears() {
        for (int i = 0; i < k; i++) {
            springAndSummer();
            autumn();
            winter();
        }
    }

    private static void springAndSummer() {
        for (int i = 0; i < n * n; i++) {
            Deque<Integer> dq = tree[i];

            int deadAgeSum = 0;
            int size = dq.size();
            for (int j = 0; j < size; j++) {
                int age = dq.pollFirst();
                if (age <= nut[i]) {
                    dq.addLast(age + 1);
                    nut[i] -= age;
                } else {
                    deadAgeSum += age / 2;
                }
            }
            nut[i] += deadAgeSum;
        }
    }

    private static void autumn() {
        for (int i = 0; i < n * n; i++) {
            Deque<Integer> dq = tree[i];
            
            for (int age : dq) {
                if (age % 5 == 0) {
                    addTree(i);
                }
            }
        }
    }

    private static void addTree(int idx) {
        int r = idx / n;
        int c = idx % n;

        for (int i = 0; i < 8; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (isInRange(nr, nc)) {
                int nIdx = nr * n + nc;
                tree[nIdx].addFirst(1);
            }
        }
    }

    private static boolean isInRange(int a, int b) {
        return a >= 0 && b >= 0 && a < n && b < n;
    }

    private static void winter() {
        for (int i = 0; i < n * n; i++) {
            nut[i] += a[i];
        }
    }

    private static int countAliveTrees() {
        int cnt = 0;
        for (int i = 0; i < n * n; i++) {
            Deque<Integer> dq = tree[i];

            cnt += dq.size();
        }

        return cnt;
    }

    private static void printAnswer() {
        System.out.println(countAliveTrees());
    }

    private static void solution() {
        readInput();
        simulateYears();
        printAnswer();
    }

    public static void main(String[] args) {
        Main.solution();
    }
}
