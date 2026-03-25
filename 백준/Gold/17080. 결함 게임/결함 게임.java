import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1, 2, 3, 4
        // 1, 1, 2, 1
        int[] arr = new int[] {1, 1, 2, 1};

        if (n % 4 == 0) System.out.println(arr[3]);
        else System.out.println(arr[n % 4 - 1]);
    }
}
