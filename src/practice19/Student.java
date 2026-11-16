package practice19;
public class Student implements StudentInfo {
    private final String fullName;
    private final double averageGrade;
    public Student(String fullName, double averageGrade) throws EmptyStringException {
        if (fullName == null || fullName.isBlank()) throw new EmptyStringException("ФИО не заполнено");
        if (!Double.isFinite(averageGrade) || averageGrade < 0 || averageGrade > 5)
            throw new IllegalArgumentException("Балл должен быть от 0 до 5");
        this.fullName = fullName.strip(); this.averageGrade = averageGrade;
    }
    public String getFullName() { return fullName; }
    public double getAverageGrade() { return averageGrade; }
}
