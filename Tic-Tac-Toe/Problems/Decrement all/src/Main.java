import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = 'a' + 'b';
        System.out.println(ch);
        int z = 'z';
        char mystery = Character.highSurrogate(z - 10);
    }
}