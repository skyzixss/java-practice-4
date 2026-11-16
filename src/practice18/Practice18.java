package practice18;
import java.util.Scanner;

/** Задания 1–8: обработка, генерация и проброс исключений. */
public class Practice18 {
    public static int divide(String input) { return 2 / Integer.parseInt(input); }
    public static void handle(String input) {
        try { System.out.println(input + " -> " + divide(input)); }
        catch (NumberFormatException e) { System.out.println(input + ": NumberFormatException"); }
        catch (ArithmeticException e) { System.out.println(input + ": ArithmeticException"); }
        finally { System.out.println("finally: вычисление завершено"); }
    }
    public static String getDetails(String key) {
        if (key == null) throw new NullPointerException("null key in getDetails");
        return "data for " + key;
    }
    public static void printMessage(String key) {
        try { System.out.println(getDetails(key)); }
        catch (NullPointerException e) { System.out.println("Ошибка ключа: " + e.getMessage()); }
    }
    public static String checkedDetails(String key) throws Exception {
        if (key == null || key.isBlank()) throw new Exception("Key set to empty string");
        return "data for " + key;
    }
    public static void printDetails(String key) throws Exception {
        try { System.out.println(checkedDetails(key)); }
        catch (Exception e) { throw e; } // Проброс вызывающему методу.
    }
    public static void getKey(Scanner scanner) {
        while (true) {
            System.out.print("Введите непустой ключ: ");
            if (!scanner.hasNextLine()) { System.out.println("Ввод завершён"); return; }
            try { printDetails(scanner.nextLine()); return; }
            catch (Exception e) { System.out.println(e.getMessage() + ". Повторите ввод."); }
        }
    }
    public static void main(String[] args) {
        System.out.println("Задание 1");
        try { int zero = 0; System.out.println(2 / zero); }
        catch (ArithmeticException e) { System.out.println("Необработанное в исходном примере: " + e); }
        System.out.println("2.0 / 0.0 = " + (2.0 / 0.0));
        System.out.println("Задания 2 и 4");
        for (String value : new String[]{"Qwerty", "0", "1.2", "1"}) handle(value);
        System.out.println("Задание 3: общий catch допускается после частных; иначе unreachable catch");
        try { divide("Qwerty"); } catch (Exception e) { System.out.println("Общий catch: " + e.getClass().getSimpleName()); }
        System.out.println("Задания 5 и 6");
        printMessage(null); printMessage("Java");
        System.out.println("Задание 7");
        try { printDetails(""); } catch (Exception e) { System.out.println("Перехват на верхнем уровне: " + e.getMessage()); }
        System.out.println("Задание 8");
        getKey(new Scanner(System.in));
    }
}
