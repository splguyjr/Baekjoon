import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long n;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

    }

    private static void printAnswer() {
        if (n % 7 == 0 || n % 7 == 2) System.out.print("CY");
        else System.out.print("SK");
    }

    private static void solution() throws IOException {
        readInput();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
