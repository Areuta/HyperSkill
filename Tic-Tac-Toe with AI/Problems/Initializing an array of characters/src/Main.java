import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        char[] characters = {'a', 'z', 'e', 'd'};
        System.out.println(Arrays.toString(characters));
        print(100);

    }
    public static void print(short a) {
        System.out.println("short arg: " + a);
    }

    public static void print(int a) {
        System.out.println("int arg: " + a);
    }

    public static void print(long a) {
        System.out.println("long arg: " + a);
    }

    public static void print(double a) {
        System.out.println("double arg: " + a);
    }

}