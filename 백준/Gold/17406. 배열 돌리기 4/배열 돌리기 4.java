import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static int[][] arr;
    static int[][] rotation;
    static int ans = Integer.MAX_VALUE;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        rotation = new int[k][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            rotation[i][0] = r;
            rotation[i][1] = c;
            rotation[i][2] = s;
        }

    }

    private static void dfs(int depth, int[][] arr, boolean[] visited) {
        if (depth == k) {
            ans = Math.min(ans, countMin(arr));
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;

            int r = rotation[i][0];
            int c = rotation[i][1];
            int s = rotation[i][2];
            
            int[][] rotatedArr = rotate(arr, r, c, s);

            visited[i] = true;
            dfs(depth + 1, rotatedArr, visited);
            visited[i] = false;
        }
    }

    // 좌상단 : (r-s, c-s), 우하단 : (r+s, c+s)
    private static int[][] rotate(int[][] arr, int r, int c, int S) {
        int[][] copyArr = copy(arr);

        for (int s = 1; s <= S; s++) {
            // 위쪽
            int upTemp = copyArr[r - s][c + s]; // 우측 상단 저장
            for (int col = c + s; col > c - s; col--) {
                copyArr[r - s][col] = copyArr[r - s][col - 1];
            }

            // 오른쪽
            int rightTemp = copyArr[r + s][c + s]; // 우측 하단 저장
            for (int row = r + s; row > r - s + 1; row--) {
                copyArr[row][c + s] = copyArr[row - 1][c + s];
            }
            copyArr[r - s + 1][c + s] = upTemp;

            // 아래쪽
            int downTemp = copyArr[r + s][c - s]; // 좌측 하단 저장
            for (int col = c - s; col < c + s - 1; col++) {
                copyArr[r + s][col] = copyArr[r + s][col + 1];
            }
            copyArr[r + s][c + s - 1] = rightTemp;

            // 왼쪽
            for (int row = r - s; row < r + s - 1; row++) {
                copyArr[row][c - s] = copyArr[row + 1][c - s];
            }
            copyArr[r + s - 1][c - s] = downTemp;
        }

        return copyArr;
    }

    private static int[][] copy(int[][] arr) {
        int[][] copyArr = new int[n + 1][m + 1];

        for (int j = 1; j <= n; j++) {
            copyArr[j] = arr[j].clone();
        }

        return copyArr;
    }

    private static int countMin(int[][] arr) {
        int rowSum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += arr[i][j];
            }
            rowSum = Math.min(rowSum, sum);
        }

        return rowSum;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        dfs(0, arr, new boolean[k]);
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
