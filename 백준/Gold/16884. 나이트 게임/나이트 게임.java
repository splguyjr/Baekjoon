import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int t;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n % 2 == 0) System.out.println("cubelover");
            else System.out.println("koosaga");
        }
    }

    private static void solution() throws IOException {
        readInput();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
