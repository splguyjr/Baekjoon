import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static boolean[][] visited;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[a][b];

            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < b; l++) {
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }

            bruteforce(sticker);
/*            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (visited[j][l]) System.out.print("1 ");
                    else System.out.print("0 ");
                }
                System.out.println();
            }
            System.out.println();*/
        }

        br.close();
    }

    // 시계방향 90도 회전 -> (0, 0), (0, 1), (0, 2) -> (0, 2), (1, 2), (2, 2)
    // (x, y) -> (y, n - x)
    private static int[][] rotateClockwise(int[][] sticker) {
        int n = sticker.length;
        int m = sticker[0].length;

        int[][] arr = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sticker[i][j] == 1) arr[j][n- i - 1] = 1;
            }
        }

        return arr;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static boolean checkFit(int x, int y, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (!isInRange(x + i, y + j)) return false;
                if (sticker[i][j] == 1 && visited[x + i][y + j]) return false;
            }
        }

        return true;
    }

    private static void markSticker(int x, int y, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1) visited[x + i][y + j] = true;
            }
        }
    }

    private static void bruteforce(int[][] sticker) {
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (checkFit(i, j, sticker)) {
                        markSticker(i, j, sticker);
                        return;
                    }
                }
            }
            sticker = rotateClockwise(sticker);
        }
    }

    private static void printAnswer() {
        int ans = 0;

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j]) ans++;
            }
        }

        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
