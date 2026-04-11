import java.util.Scanner;
import java.util.Stack;

public class Main {

    static long n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        while (n > 0) {
            if ((n & 1) == 1) st.add(1);
            else st.add(0);

            n = n >> 1;
        }
        boolean flag = true;
        while (!st.isEmpty()) {
            if (flag && st.peek() == 0) {
                st.pop();
            }
            else {
                System.out.print(st.pop());
                flag = false;
            }
        }
    }
}
