import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        String[] split = solution(arr).split(" ");
        for(String s : split) {
            System.out.println(s);
        }
    }

    public static String solution(Integer[] array) {

        PriorityQueue<Number> pq = new PriorityQueue<>((n1, n2) -> {
            if (n1.abs == n2.abs) return n1.real - n2.real;
            else return n1.abs - n2.abs;
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            int x = array[i];

            if(x != 0) {
                int real = x;
                int abs = Math.abs(x);

                pq.offer(new Number(abs, real));
            }

            else {
                if(pq.isEmpty()) {
                    sb.append("0 ");
                }
                else
                    sb.append(pq.poll().real).append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static class Number {
        int abs;
        int real;

        public Number(int abs, int real) {
            this.abs = abs;
            this.real = real;
        }
    }
}