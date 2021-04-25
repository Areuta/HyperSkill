// do not remove imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.List;

class ArrayUtils<T> {

    public static <T> T[] invert(T[] array) {
        List<T> list = new ArrayList<>(List.of(array));
        Collections.reverse(list);
        return list.toArray(array);
    }
}
