package practice19;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
public class LabClassUI extends JFrame {
    private final LabClass lab;
    private final DefaultTableModel model = new DefaultTableModel(new String[]{"ФИО", "Средний балл"}, 0) {
        public boolean isCellEditable(int row, int column) { return false; }
    };
    private final JTextField search = new JTextField(24);
    private final JLabel status = new JLabel("Введите полное ФИО или отсортируйте список");
    public LabClassUI(LabClass lab) {
        super("Блок 4 — Поиск и сортировка студентов"); this.lab = lab;
        JButton sort = new JButton("По баллу ↓"), find = new JButton("Найти");
        JPanel controls = new JPanel(); controls.add(search); controls.add(find); controls.add(sort);
        add(controls, BorderLayout.NORTH); add(new JScrollPane(new JTable(model))); add(status, BorderLayout.SOUTH);
        sort.addActionListener(e -> { lab.sort(); refresh(); status.setText("Список отсортирован по убыванию балла"); });
        find.addActionListener(e -> {
            try { StudentInfo s = lab.find(search.getText()); status.setText(s.getFullName() + ": " + s.getAverageGrade()); }
            catch (EmptyStringException | StudentNotFoundException ex) { status.setText(ex.getMessage()); }
        });
        search.addActionListener(e -> find.doClick());
        refresh(); setSize(740, 360); setLocationRelativeTo(null); setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void refresh() { model.setRowCount(0); for (StudentInfo s : lab.getStudents()) model.addRow(new Object[]{s.getFullName(), s.getAverageGrade()}); }
}
