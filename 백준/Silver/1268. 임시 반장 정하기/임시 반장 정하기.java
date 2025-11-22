import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static Set<Integer>[] slist;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][6];
        slist = new Set[n + 1];

        for (int i = 0; i <= n; i++) {
            slist[i] = new HashSet<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calSameCount() {
        for (int k = 1; k <= 5; k++) {
            for (int i = 1; i <= n - 1; i++) {
                int x = arr[i][k];
                for (int j = i + 1; j <= n; j++) {
                    int y = arr[j][k];

                    if (x == y) {
                        slist[i].add(j);
                        slist[j].add(i);
                    }
                }
            }
        }
    }

    private static void printAnswer() {
        int maxCount = 0;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if (slist[i].size() > maxCount) {
                maxCount = slist[i].size();
                idx = i;
            }
        }
        
        if (maxCount == 0) System.out.println(1);
        
        else System.out.println(idx);
    }

    public static void main(String[] args) throws IOException {
        readInput();
        calSameCount();
        printAnswer();
    }
}