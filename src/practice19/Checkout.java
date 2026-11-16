package practice19;
import java.util.Scanner;
public class Checkout {
    private static int digit(String s, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) sum += (s.charAt(i) - '0') * weights[i];
        return sum % 11 % 10;
    }
    // Проверяется структура ИНН физлица; принадлежность ФИО требует внешнего реестра.
    public static void validate(String name, String inn) throws EmptyStringException, InvalidInnException {
        if (name == null || name.isBlank()) throw new EmptyStringException("ФИО не заполнено");
        if (inn == null || !inn.matches("[0-9]{12}") || inn.chars().allMatch(c -> c == '0'))
            throw new InvalidInnException("ИНН физического лица должен содержать 12 цифр");
        if (digit(inn, new int[]{7,2,4,10,3,5,9,4,6,8}) != inn.charAt(10)-'0'
                || digit(inn, new int[]{3,7,2,4,10,3,5,9,4,6,8}) != inn.charAt(11)-'0')
            throw new InvalidInnException("Неверные контрольные разряды ИНН");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ФИО: "); String name = in.hasNextLine() ? in.nextLine() : "";
        System.out.print("ИНН (12 цифр): "); String inn = in.hasNextLine() ? in.nextLine() : "";
        try { validate(name, inn); System.out.println("Заказ оформлен. Формат и контрольные разряды ИНН верны."); }
        catch (EmptyStringException | InvalidInnException e) { System.out.println("Заказ отклонён: " + e.getMessage()); }
    }
}
