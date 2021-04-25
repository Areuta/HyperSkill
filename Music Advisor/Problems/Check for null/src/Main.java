// do not remove imports
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class ArrayUtils {

    public static <T> boolean hasNull(T[] array) {
        for (T t : array) {
            if (Objects.isNull(t)) {
                return true;
            }
        }
        return false;
    }
}