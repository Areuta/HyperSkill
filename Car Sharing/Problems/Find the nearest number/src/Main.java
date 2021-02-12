import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> listDiff = new ArrayList<>();
        int n = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = reader.readLine().split("\\s");
            for (String str : strings) {
                list.add(Integer.parseInt(str));
            }
            n = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Bad Input!");
        }

        int minDif = abs(n - list.get(0));
        for (int i : list) {
            int currentDiff = abs(n - i);
            if (minDif > currentDiff) {
                minDif = currentDiff;
            }
        }

        for (int i : list) {
            if (minDif == abs(i - n)) {
                if (n < i) {
                    listDiff.add(i);
                } else {
                    listDiff.add(0, i);
                }
            }
        }

        for (int i : listDiff) {
            System.out.print(i + " ");
        }
    }
}