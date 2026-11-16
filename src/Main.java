import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Блок 4. Практические работы 18–21");
        System.out.println("1 — Исключения (18)\n2 — Оформление заказа (19.1)\n3 — Студенты, окно Swing (19.2)\n4 — Дженерики и матрицы (20)\n5 — Массивы и коллекции (21)");
        StringBuilder input = new StringBuilder();
        try { int c; while ((c = System.in.read()) != -1 && c != '\n') if (c != '\r') input.append((char)c); }
        catch (java.io.IOException e) { throw new java.io.UncheckedIOException(e); }
        String choice = input.toString();
        switch (choice) {
            case "1" -> practice18.Practice18.main(args);
            case "2" -> practice19.Checkout.main(args);
            case "3" -> practice19.LabClassDriver.main(args);
            case "4" -> practice20.Practice20.main(args);
            case "5" -> practice21.Practice21.main(args);
            default -> System.out.println("Выберите пункт от 1 до 5");
        }
    }
}
