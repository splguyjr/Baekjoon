import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int n;
    static int[] height;
    static long ans = 0;

    private static void readInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        height = new int[n + 1];

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void calcLargestRectangleArea() {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int curHeight = height[i];

            while (!st.isEmpty() && height[st.peek()] > curHeight) {
                int top = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                ans = Long.max(ans, (long) height[top] * width);
            }
            st.push(i);
        }
    }

    private static void printAnswer() {
        System.out.println(ans);
    }

    private static void solution() throws IOException {
        readInput();
        calcLargestRectangleArea();
        printAnswer();
    }

    public static void main(String[] args) throws IOException {
        Main.solution();
    }
}
