import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int ind1 = scanner.nextInt();
        int ind2 = scanner.nextInt();

       /* if (ind1 >= 0 && ind2 >= 0 && ind1 < str.length() && ind2 < str.length()) {
            System.out.println(str.substring(ind1, ind2));
        }*/
        System.out.println(str.substring(ind1, ind2 + 1));
    }
}