package practice21;
import java.util.Objects;
public class ArrayStorage<T> {
    private final T[] values;
    public ArrayStorage(T[] values) { this.values = Objects.requireNonNull(values).clone(); }
    public T get(int index) { return values[Objects.checkIndex(index, values.length)]; }
    public int size() { return values.length; }
}
