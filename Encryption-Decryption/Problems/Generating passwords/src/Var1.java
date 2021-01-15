import java.util.Scanner;
import java.util.*;

public class Var1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();               // a - number of uppercase letters
        int b = sc.nextInt();               // b - number of lowercase letters
        int c = sc.nextInt();               // c - number of digits
        int n = sc.nextInt();               // n - number of symbols      a + b + c <= n
        sc.close();
        if (n == 0) {
            return;
        }

        char lL = '\0';
        int counterA = 0;
        while (counterA < a) {
            char lL2 = (char) Math.round(25 * Math.random() + 65);
            if (lL != lL2) {
                System.out.print(lL2);
                lL = lL2;
                counterA++;
            }
        }
        char m = '\0';
        int counterb = 0;
        while (counterb < b) {
            char m2 = (char) Math.round(25 * Math.random() + 97);
            if (m != m2) {
                System.out.print(m2);
                m = m2;
                counterb++;
            }
        }
        char x = '\0';
        int counterc = 0;
        while (counterc < c) {
            char x2 = (char) Math.round(9 * Math.random() + 48);
            if (x != x2) {
                System.out.print(x2);
                x = x2;
                counterc++;
            }
        }
        if (a + b + c < n) {
            for (int i = 0; i < n - a - b - c; i++) {
                if (i % 2 == 0) {
                    char lL2 = (char) Math.round(25 * Math.random() + 65);
                    System.out.print(lL2);
                } else {
                    char x2 = (char) Math.round(9 * Math.random() + 48);
                    System.out.print(x2);
                }
            }
        }
    }
}