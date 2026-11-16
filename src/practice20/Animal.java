package practice20;
public abstract class Animal implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    protected Animal(String name) { this.name = name; }
    public String toString() { return getClass().getSimpleName() + " " + name; }
}
