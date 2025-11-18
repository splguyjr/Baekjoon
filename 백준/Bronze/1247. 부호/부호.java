import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    private static void calSum() {
        int n = sc.nextInt();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            sum = sum.add(new BigInteger(sc.next()));
        }

        if (sum.equals(BigInteger.ZERO)) System.out.println(0);
        else if (sum.compareTo(BigInteger.ZERO) < 0) System.out.println("-");
        else System.out.println("+");
    }

    public static void main(String[] args) {
        calSum();
        calSum();
        calSum();
    }
}
