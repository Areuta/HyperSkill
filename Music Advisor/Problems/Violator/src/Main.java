import java.util.ArrayList;
import java.util.List;

/**
 * Class to work with
 */
class Violator {

    public static List<Box<? extends Bakery>> defraud() {
        List list = new ArrayList();
        Box box = new Box();
        box.put(new Paper());
        list.add(box);
        return list;
    }
}
