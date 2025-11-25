import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[19][19];
    static int[] dx = {0, -1, 1, 1};
    static int[] dy = {1, 1, 0, 1};

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }

    private static void bruteforce() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue;

                int color = board[i][j];

                for (int dir = 0; dir < 4; dir++) {
                    int prevX = i - dx[dir];
                    int prevY = j - dy[dir];

                    if (isInRange(prevX, prevY) && board[prevX][prevY] == color) continue;

                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    int count = 1;

                    while (isInRange(nx, ny) && board[nx][ny] == color) {
                        count++;
                        nx = nx + dx[dir];
                        ny = ny + dy[dir];
                    }

                    if (count == 5) {
                        System.out.println(color);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }


            }
        }

        System.out.println(0);
    }

    private static void solution() throws IOException {
        readInput();
        bruteforce();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
