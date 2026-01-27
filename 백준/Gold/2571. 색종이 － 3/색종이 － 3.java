import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr = new int[101][101]; // 색종이를 붙인 위치는 두 개의 자연수로 주어지므로 1-based
    static int[] height = new int[102]; // 행을 바닥으로 하여 이어지는 연속적인 높이 저장
    static int ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lr = Integer.parseInt(st.nextToken());
            int lc = Integer.parseInt(st.nextToken());

            coverRectangle(lr, lc);
        }
    }

    private static void coverRectangle(int r, int c) {
        for (int i = r; i < r + 10; i++) {
            for (int j = c; j < c + 10; j++) {
                arr[i][j] = 1;
            }
        }
    }

    private static void calConsecutiveHeight() {
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (arr[i][j] == 1) height[j]++;
                else height[j] = 0;
            }
            calcLargestRectangleArea(i);
        }
    }

    private static void calcLargestRectangleArea(int r) {
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i <= 101; i++) {
            int curHeight = height[i];

            // 비어있지 않고, 다음 height가 이전에 저장된 height보다 작으면 계속 pop하면서 최대 넓이 계산
            // height[101]을 0으로 잡아 끝에 도달하면 1이상인 높이들은 자동으로 전부 pop하도록
            // 계속해서 오른쪽으로 확장의 여지가 남아있는 높이의 히스토그램을 만날때까지 계속해서 pop한다의 의미
            while (!st.isEmpty() && height[st.peek()] > curHeight) {
                int top = st.pop();
                int left = st.isEmpty() ? 0 : st.peek();
                int width = i - 1 - left;   // 먼저 뽑고 나서 거리 계산하므로 -1
                ans = Math.max(ans, width * height[top]);
            }

            st.push(i);
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }


    private static void solution() throws IOException {
        readInput();
        calConsecutiveHeight();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
