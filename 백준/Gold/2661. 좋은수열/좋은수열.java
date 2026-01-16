import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    private static void dfs(String s, int cnt) {
        if (cnt == n) {
            System.out.println(s);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (checkGoodSequence(s + i)) {
                dfs(s + i, cnt + 1);
            }
        }
    }

    private static boolean checkGoodSequence(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String front = s.substring(s.length()- 2 * i, s.length() - i);
            String back = s.substring(s.length() - i);

            if (front.equals(back)) return false;
        }
        return true;
    }


    private static void solution() throws IOException {
        readInput();
        dfs("", 0);
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
