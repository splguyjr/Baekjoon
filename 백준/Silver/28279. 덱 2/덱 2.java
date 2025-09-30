import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Deque<Integer> deque = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void solution() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        bw.write(deque.removeFirst() + "\n");
                    }
                    else bw.write("-1\n");
                    break;
                case 4:
                    if (!deque.isEmpty()) {
                        bw.write(deque.removeLast() + "\n");
                    }
                    else bw.write("-1\n");
                    break;
                case 5:
                    bw.write(deque.size() + "\n");
                    break;
                case 6:
                    if (!deque.isEmpty()) {
                        bw.write("0\n");
                    }
                    else bw.write("1\n");
                    break;
                case 7:
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    else bw.write("-1\n");
                    break;
                case 8:
                    if (!deque.isEmpty()) {
                        bw.write(deque.peekLast() + "\n");
                    }
                    else bw.write("-1\n");
                    break;
            }
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}