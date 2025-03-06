import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrayInput = br.readLine();
            arrayInput = arrayInput.substring(1, arrayInput.length()-1);
            if(arrayInput.equals("")) {
                if (command.contains("D")) System.out.println("error");
                else System.out.println("[]");
                continue;
            }
            String[] split = arrayInput.split(",");
            Integer[] array = new Integer[split.length];
            for(int j = 0; j < split.length; j++) {
                array[j] = Integer.valueOf(split[j]);
            }
            System.out.println(solution(command, array));
        }
    }
    public static String solution(String command, Integer[] array) {

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < array.length; i++) {
            deque.add(array[i]);
        }
        boolean flag = false;//초기엔 정방향 true면 역방향이므로 뒤에서 빼기
        for (char c : command.toCharArray()) {
            if(c == 'R')
                flag = flag ? false : true;

            else {
                if(deque.isEmpty()) return "error";
                else if(flag) {
                    deque.pollLast();
                }
                else deque.pollFirst();
            }
        }
        sb.append("[");

        if(flag) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if(i == size - 1) sb.append(deque.pollLast());
                else sb.append(deque.pollLast()+ ",");
            }
        }
        else {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) sb.append(deque.pollFirst());
                else sb.append(deque.pollFirst() + ",");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}