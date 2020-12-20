import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    final static int size;
    final static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
        size = scanner.nextInt();
    }

    Comparator<int[]> intComp;

    public static void main(String[] args) {
        Main main = new Main();
        main.intComp = new Comparator<>() {
            @Override
            public int compare(int[] int1, int[] int2) {
                for (int i = 0; i < size; i++) {
                    if (int1[i] > int2[i]) {
                        return 1;
                    }
                    if (int1[i] < int2[i]) {
                        return -1;
                    }
                }
                return 0;
            }
        };
        ArrayList<int[]> iii = main.decompose(size);
        System.out.println(iii.size());
        for (int[] ints : iii) {
            for (int i = 0; i < size; i++) {
                if (ints[i] != 0) {
                    System.out.printf("%d ", ints[i]);
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

    public ArrayList<int[]> decompose(int n) {
        ArrayList<int[]> list = new ArrayList<>();
        if (n == 1) {
            int[] i1 = new int[size];
            i1[0] = 1;
            for (int i = 1; i < size; i++) {
                i1[i] = 0;
            }
            list.add(i1);
        } else {
            for (int[] addends : decompose(n - 1)) {

                for (int i = 0; i <= addends[0]; i++) {
                    int[] ints = new int[size];
                    int k = findEnd(addends, i);
                    for (int j = 0; j < n; j++) {
                        ints[j] = k == j ? addends[j] + 1 : addends[j];
                    }
                    if (!findInt(ints, list)) {
                        list.add(ints);
                    }
                }
            }
            list.sort(intComp);

        }
        return list;
    }

    // returns the presence of an element in the list
    private boolean findInt(int[] toFind, ArrayList<int[]> list1) {
        for (int[] ints : list1) {
            if (intComp.compare(toFind, ints) == 0) {
                return true;
            }
        }
        return false;
    }

    public int findEnd(int[] addends, int i) {
        if (addends[0] == i) {
            return 0;
        }
        for (int j = 1; j < addends.length; j++) {
            if (addends[j] == i && addends[j - 1] == i + 1) {
                return j;
            }
        }
        return 0;
    }

}