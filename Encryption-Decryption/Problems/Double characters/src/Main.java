import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (Character character : str.toCharArray()) {
            sb.append(character);
            sb.append(character);
//            sb.append(String.valueOf(character).repeat(2));
        }
        System.out.println(sb.toString());
    }
}