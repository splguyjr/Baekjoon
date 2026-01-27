import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] height;
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            else {
                height = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    height[i] = Integer.parseInt(st.nextToken());
                }
                calcLargestRectangleArea();
            }

        }
    }

    private static void calcLargestRectangleArea() {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= height.length - 1; i++) {
            int curHeight = height[i];

            while (!st.isEmpty() && height[st.peek()] > curHeight) {
                int top = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                ans = Long.max(ans, (long) height[top] * width);
            }
            st.push(i);
        }

        printAnswer();
        ans = 0;
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
