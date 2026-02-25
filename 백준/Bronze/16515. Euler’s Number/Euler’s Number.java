import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double d = 1;
        double e = 1;
        for (int i = 1; i <= n; i++) {
            d /= i;
            e += d;
        }

        System.out.println(e);
    }
}
