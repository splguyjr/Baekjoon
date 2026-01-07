import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static String[] word;
    static List<Character> list = new ArrayList<>();
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        word = new String[n];

        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
    }

    //abcdefghij
    //klmnopqrst
    //uvwxyz
    //a:0, c:2, i:8, n:13, t:19
    private static void dfs(int idx, int count) {
        if (count == k - 5) {
            ans = Math.max(ans, checkCount());
            return;
        }

        if (idx == 26) return;  // 가르칠 수 있는 알파벳 개수를 다 채우지 않은 경우 확인 x
        
        // a, c, i, n, t인 경우 이미 포함되었다고 간주하므로 넘기기
        if (idx == 0 || idx == 2 || idx == 8 || idx == 13 || idx == 19) {
            dfs(idx + 1, count);
        }

        else {
            list.add((char)('a' + idx));
            dfs(idx + 1, count + 1);
            list.remove(list.size() - 1);

            dfs(idx + 1, count);
        }
    }

    private static int checkCount() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (char c : word[i].toCharArray()) {
                if (c != 'a' && c != 'c' && c != 'i' && c != 'n' && c != 't') {
                    if (!list.contains(c)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) count++;
        }

        return count;
    }

    private static void printAnswer() {
        if (k <= 4) System.out.println(ans);
        else {
            dfs(0, 0);
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        readInput();
        printAnswer();
    }
}
