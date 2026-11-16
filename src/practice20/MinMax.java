package practice20;
import java.util.Objects;
public class MinMax<T extends Comparable<? super T>> {
    private final T[] values;
    public MinMax(T[] values) {
        if (values == null || values.length == 0) throw new IllegalArgumentException("Массив пуст");
        this.values = values.clone(); for (T v : this.values) Objects.requireNonNull(v, "Элемент null");
    }
    public T min() { T result = values[0]; for (T v : values) if (v.compareTo(result) < 0) result = v; return result; }
    public T max() { T result = values[0]; for (T v : values) if (v.compareTo(result) > 0) result = v; return result; }
}
