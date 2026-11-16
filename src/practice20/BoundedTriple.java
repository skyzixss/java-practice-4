package practice20;
import java.io.Serializable;
// В пункте 3 PDF условие для K обрывается; принято ограничение Number.
public class BoundedTriple<T extends Comparable<? super T>, V extends Animal & Serializable, K extends Number> extends Triple<T,V,K> {
    public BoundedTriple(T t, V v, K k) { super(t,v,k); }
}
