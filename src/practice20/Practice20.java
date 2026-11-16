package practice20;
public class Practice20 {
    public static void main(String[] args) {
        System.out.println("Задания 1–2"); new Triple<>("Java", 7, 2.5).printTypes();
        System.out.println("Задание 3"); new BoundedTriple<>("Dog", new Dog("Шарик"), 12).printTypes();
        MinMax<Integer> mm = new MinMax<>(new Integer[]{9, -2, 4, 15});
        System.out.println("Задание 4: min=" + mm.min() + ", max=" + mm.max());
        System.out.println("sum=" + Calculator.sum(2, 3.5) + ", subtraction=" + Calculator.subtraction(7L, 2.5));
        System.out.println("multiply=" + Calculator.multiply(3, 2.5f) + ", divide=" + Calculator.divide(7, 2L));
        Matrix<Integer> a = new Matrix<>(new Integer[][]{{1,2},{3,4}});
        Matrix<Double> b = new Matrix<>(new Double[][]{{0.5,1.0},{1.5,2.0}});
        System.out.println("Задание 5: A+B=" + a.add(b));
        System.out.println("A-B=" + a.subtract(b)); System.out.println("A*B=" + a.multiply(b));
        System.out.println("A^T=" + a.transpose());
    }
}
