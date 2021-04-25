/**
 * Class to work with
 */
class Multiplicator {

    public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
        Folder<T>[] array = new Folder[arraySize];
        for (int i = 0; i < arraySize; i++) {
            Folder<T> folder1 = new Folder<>();
            folder1.put(folder.get().copy());
            array[i] = folder1;
        }
        return array;
    }

}

// Don't change the code below
interface Copy<T> {
    T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}