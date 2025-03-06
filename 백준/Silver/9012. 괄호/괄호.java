import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int next = sc.nextInt();
        sc.nextLine();

        while(next-- > 0) {
            String line = sc.nextLine();
            System.out.println(solution(line));
        }
    }


    public static String solution(String input) {

        Stack<Integer> pStack = new Stack<>();

        for (char p : input.toCharArray()) {
            if(p == ')') {
                if(pStack.isEmpty())
                    return "NO";
                else
                    pStack.pop();
            }

            else if(p == '(') {
                pStack.push(1);
            }
        }

        if(pStack.isEmpty()) return "YES";
        return "NO";
    }
}