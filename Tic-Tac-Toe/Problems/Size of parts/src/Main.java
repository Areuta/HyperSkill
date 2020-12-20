import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberParts = scanner.nextInt();
        int largeParts = 0, smallerParts = 0, perfectParts = 0;
        for (int i = 0; i < numberParts; i++) {
            int p = scanner.nextInt();
            switch (p) {
                case 1:
                    largeParts++;
                    break;
                case 0:
                    perfectParts++;
                    break;
                case -1:
                    smallerParts++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + p);
            }
        }
        System.out.printf("%d %d %d", perfectParts, largeParts, smallerParts);
    }
}