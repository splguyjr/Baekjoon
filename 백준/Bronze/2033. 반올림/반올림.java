import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        
        int res = 10;
        while (x >= res) {
            x = ((x + (res / 2)) / res) * res;
            res *= 10;
        }

        System.out.println(x);
    }
}
