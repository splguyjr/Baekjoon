import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            if(x >= 97)
                b = b + (char)(x - 32);
            
            else b = b + (char)(x + 32);
        }

        System.out.print(b);
    }
}