package practice19;
import javax.swing.SwingUtilities;
public class LabClassDriver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                StudentInfo[] students = {new Student("Игнатов Антон Ильич", 4.7), new Student("Петров Иван Сергеевич", 3.8), new Student("Сидорова Анна Олеговна", 4.9)};
                new LabClassUI(new LabClass(students)).setVisible(true);
            } catch (EmptyStringException e) { throw new IllegalStateException(e); }
        });
    }
}
