package practice20;
import java.util.Objects;
public class Triple<T, V, K> {
    private final T first; private final V second; private final K third;
    public Triple(T first, V second, K third) { this.first = first; this.second = second; this.third = third; }
    public T getFirst() { return first; }
    public V getSecond() { return second; }
    public K getThird() { return third; }
    public void printTypes() {
        for (Object value : new Object[]{first, second, third}) System.out.println(value == null ? "null" : value.getClass().getName());
    }
}
