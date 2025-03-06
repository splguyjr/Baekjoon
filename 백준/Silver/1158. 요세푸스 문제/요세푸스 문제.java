import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solution(n, k));
    }
    public static String solution(int n, int k) {
        Queue<Integer> tableQueue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            tableQueue.offer(i);
        }

        sb.append("<");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k - 1; j++) {
                tableQueue.offer(tableQueue.poll());
            }
            sb.append(tableQueue.poll());
            if(!tableQueue.isEmpty())
                sb.append(", ");
        }
        sb.append(">");

        return sb.toString();
    }
}