package practice19;
import java.util.Arrays;
import java.util.Comparator;
public class LabClass {
    private final StudentInfo[] students; // Массив интерфейсных ссылок.
    public LabClass(StudentInfo[] students) { this.students = students.clone(); }
    public StudentInfo[] getStudents() { return students.clone(); }
    public void sort() { Arrays.sort(students, Comparator.comparingDouble(StudentInfo::getAverageGrade).reversed().thenComparing(StudentInfo::getFullName)); }
    public StudentInfo find(String name) throws EmptyStringException, StudentNotFoundException {
        if (name == null || name.isBlank()) throw new EmptyStringException("Введите ФИО для поиска");
        for (StudentInfo s : students) if (s.getFullName().equalsIgnoreCase(name.strip())) return s;
        throw new StudentNotFoundException("Студент не найден: " + name);
    }
}
