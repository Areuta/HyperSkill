import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int maxCountSequence = 1;

        int i = 0;
        while (i < size - 1) {
            int countSequence = 1;
            while (i < size - 1 && array[i] < array[i + 1]) {
                countSequence++;
                i++;
            }
            i++;
            if (countSequence > maxCountSequence) {
                maxCountSequence = countSequence;
            }
        }

        System.out.println(maxCountSequence);
    }
}