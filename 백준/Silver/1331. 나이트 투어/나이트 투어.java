import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isRightMove(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x1 - x2);
        int dy = Math.abs(y1 - y2);

        return (dx == 1 && dy == 2) || (dx == 2 && dy == 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        boolean[][] visited = new boolean[6][6];
        int[] x = new int[36];
        int[] y = new int[36];

        for (int i = 0; i < 36; i++) {
            String line = br.readLine();

            int a = line.charAt(0) - 'A';
            int b = line.charAt(1) - '1';

            if (visited[a][b]) {
                System.out.println("Invalid");
                return;
            }

            visited[a][b] = true;

            x[i] = a;
            y[i] = b;
        }

        for (int i = 1; i < 36; i++) {
            int x1 = x[i - 1];
            int y1 = y[i - 1];
            int x2 = x[i];
            int y2 = y[i];

            if (!isRightMove(x1, y1, x2, y2)) {
                System.out.println("Invalid");
                return;
            }
        }

        if (!isRightMove(x[35], y[35], x[0], y[0])) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }
}
