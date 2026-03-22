import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = 1;
        int d = 1;
        for (int i = 0; i < n; i++) {
            c += a; d += b;
            if (d > c) {
                int temp = c;
                c = d;
                d = temp;
            }
            else if (d == c) {
                d -= 1;
            }
        }

        System.out.println(c + " " + d);
    }
}
