import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int a = 300;
        int b = a++;
        System.out.println(b);
        int c = --b;
        System.out.println(c);
    }
}