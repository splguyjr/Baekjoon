import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        System.out.println(solution(line));
    }
    public static int solution(String input) {

        int level = 0;
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        boolean check = false;//이전이 '(' 이면 1
        for (char c : input.toCharArray()) {
            if(c == '(') {
                level++;
                check = true;
            }

            else {
                if(check) {
                    answer += --level;
                    check = false;
                }
                else {
                    answer += 1;
                    level--;
                }
            }
        }

        return answer;
    }

}