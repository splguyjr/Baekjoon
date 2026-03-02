import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[16][3];
    static int a, b, c;

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

        for (int i = 0; i < 16; i++) {
            arr[i][0] = reader.nextInt();
            arr[i][1] = reader.nextInt();
            arr[i][2] = reader.nextInt();
        }

        while (true) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            int z = reader.nextInt();

            if (x == -1 && y == -1 && z == -1) {
                reader.close();
                return;
            }

            calcMinDist(x, y, z);
            System.out.printf("(%d,%d,%d) maps to (%d,%d,%d)\n", x, y, z, a, b, c);
        }
    }

    private static void calcMinDist(int x, int y, int z) {
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < 16; i++) {
            int dist = euclideanDistance(x, y, z, arr[i][0], arr[i][1], arr[i][2]);
            if (dist < minDist) {
                minDist = dist;
                a = arr[i][0];
                b = arr[i][1];
                c = arr[i][2];
            }
        }
    }

    private static int euclideanDistance(int x1, int y1, int z1, int x2, int y2, int z2) {
        return (int) (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
    }

    public static void main(String[] args) {
        readInput();
    }
}
