import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            queue.offerFirst(scanner.nextInt());
        }

        queue.forEach(System.out::println);
    }
}