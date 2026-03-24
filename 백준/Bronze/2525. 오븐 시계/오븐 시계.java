import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int minute = (60 * a + b + c) % 1440;
        int hour = minute / 60;
        int min = minute - hour * 60;

        System.out.println(hour + " " + min);
    }
}
