package practice21;
import java.util.*;
public class Solution<T,V,K> {
    private final T first; private final V second; private final K third;
    public Solution(T t, V v, K k) { first=t; second=v; third=k; }
    public T getFirst() { return first; } public V getSecond() { return second; } public K getThird() { return third; }
    @SafeVarargs public static <T> ArrayList<T> newArrayList(T... values) {
        ArrayList<T> result = new ArrayList<>(); for (T v:values) result.add(v); return result;
    }
    @SafeVarargs public static <T> HashSet<T> newHashSet(T... values) {
        HashSet<T> result = new HashSet<>(); for (T v:values) result.add(v); return result;
    }
    // В PDF сигнатура обрывается: передаём типизированные пары ключ–значение.
    @SafeVarargs public static <K,V> HashMap<K,V> newHashMap(Map.Entry<? extends K,? extends V>... entries) {
        HashMap<K,V> result = new HashMap<>(); for (var e:entries) result.put(e.getKey(),e.getValue()); return result;
    }
}
