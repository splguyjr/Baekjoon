import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x = 2024 * 12 + 8 + (n - 1) * 7;
        int y = (x % 12) == 0 ? x / 12 - 1 : x / 12;
        int z = (x - y * 12) % 13;

        System.out.print(y + " " + z);
    }
}
