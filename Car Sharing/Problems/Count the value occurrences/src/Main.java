import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        return countConcreteNumber(elem, list1) == countConcreteNumber(elem, list2);
    }

    public static int countConcreteNumber(int elem, List<Integer> list) {
        int count = 0;
        for (int i : list) {
            if (i == elem) {
                count++;
            }
        }
        return count;
//        Collections.frequency() !!!
    }
}