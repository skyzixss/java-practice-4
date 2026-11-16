package practice20;
public final class Calculator {
    private Calculator() {}
    public static <A extends Number, B extends Number> double sum(A a, B b) { return a.doubleValue() + b.doubleValue(); }
    public static <A extends Number, B extends Number> double subtraction(A a, B b) { return a.doubleValue() - b.doubleValue(); }
    public static <A extends Number, B extends Number> double multiply(A a, B b) { return a.doubleValue() * b.doubleValue(); }
    public static <A extends Number, B extends Number> double divide(A a, B b) {
        if (b.doubleValue() == 0) throw new ArithmeticException("Деление на ноль");
        return a.doubleValue() / b.doubleValue();
    }
}
