import practice18.Practice18;
import practice19.*;
import practice20.*;
import practice21.*;
import java.nio.file.*;
import java.util.*;
public class Verification {
    private static int count;
    private static void check(boolean ok) { count++; if(!ok) throw new AssertionError("Проверка " + count); }
    interface Action { void run() throws Exception; }
    private static void fails(Class<? extends Throwable> type, Action action) throws Exception {
        try { action.run(); } catch(Throwable e) { check(type.isInstance(e)); return; }
        throw new AssertionError("Ожидалось " + type);
    }
    public static void main(String[] args) throws Exception {
        check(Practice18.divide("1")==2);
        for(String s:new String[]{"Qwerty","1.2"}) fails(NumberFormatException.class,()->Practice18.divide(s));
        fails(ArithmeticException.class,()->Practice18.divide("0"));
        fails(NullPointerException.class,()->Practice18.getDetails(null));
        fails(Exception.class,()->Practice18.checkedDetails(" "));
        var out=System.out; var buffer=new java.io.ByteArrayOutputStream();
        try { System.setOut(new java.io.PrintStream(buffer)); Practice18.getKey(new Scanner("\nJava\n")); }
        finally { System.setOut(out); }
        check(buffer.toString().contains("data for Java"));
        Checkout.validate("Учебный Клиент","123456789047"); check(true);
        for(String s:new String[]{"123456789048","000000000000","abc","123"})
            fails(InvalidInnException.class,()->Checkout.validate("Клиент",s));
        fails(EmptyStringException.class,()->Checkout.validate(" ","123456789047"));
        LabClass lab=new LabClass(new StudentInfo[]{new Student("Иванов Иван",3.5),new Student("Петров Пётр",4.8)});
        lab.sort();check(lab.getStudents()[0].getAverageGrade()==4.8);
        check(lab.find(" иванов иван ").getAverageGrade()==3.5);
        fails(StudentNotFoundException.class,()->lab.find("Нет студента"));
        fails(EmptyStringException.class,()->lab.find(""));
        fails(EmptyStringException.class,()->new Student("",4));
        fails(IllegalArgumentException.class,()->new Student("Имя",Double.NaN));
        Integer[] source={4,-3,10};MinMax<Integer> mm=new MinMax<>(source);source[0]=100;
        check(mm.min()==-3 && mm.max()==10);
        check(new MinMax<>(new String[]{"b","a"}).min().equals("a"));
        fails(IllegalArgumentException.class,()->new MinMax<>(new Integer[0]));
        check(Calculator.sum(2,3.5)==5.5);check(Calculator.subtraction(7L,2.5)==4.5);
        check(Calculator.multiply(3,2.5f)==7.5);check(Calculator.divide(7,2L)==3.5);
        fails(ArithmeticException.class,()->Calculator.divide(1,-0.0));
        Matrix<Integer> a=new Matrix<>(new Integer[][]{{1,2,3},{4,5,6}});
        Matrix<Double> b=new Matrix<>(new Double[][]{{1.0},{2.0},{3.0}});
        check(a.multiply(b).get(0,0)==14 && a.multiply(b).get(1,0)==32);
        check(a.transpose().rows()==3 && a.transpose().get(2,1)==6);
        check(a.add(a).get(1,2)==12);check(a.subtract(a).get(1,2)==0);
        fails(IllegalArgumentException.class,()->a.add(b));
        fails(IllegalArgumentException.class,()->b.multiply(b));
        fails(IllegalArgumentException.class,()->new Matrix<>(new Integer[][]{{1},{1,2}}));
        Integer[] values={1,2};ArrayStorage<Integer> storage=new ArrayStorage<>(values);values[0]=9;
        check(storage.get(0)==1 && storage.size()==2);
        fails(IndexOutOfBoundsException.class,()->storage.get(-1));
        fails(IndexOutOfBoundsException.class,()->storage.get(2));
        check(Practice21.toList(new String[]{"a","b"}).equals(List.of("a","b")));
        check(Solution.newArrayList(1,1).size()==2);check(Solution.newHashSet(1,1).size()==1);
        check(Solution.newHashMap(Map.entry("a",1),Map.entry("a",2)).get("a")==2);
        Path temp=Files.createTempDirectory("practice21-");
        try {
            for(int i=0;i<7;i++)Files.createFile(temp.resolve("file"+i));
            check(Practice21.directoryContents(temp).size()==7);buffer.reset();
            try { System.setOut(new java.io.PrintStream(buffer));Practice21.printFirstFive(temp); }
            finally { System.setOut(out); }
            check(buffer.toString().lines().count()==5);
            fails(java.io.IOException.class,()->Practice21.directoryContents(temp.resolve("absent")));
        } finally { for(Path f:Practice21.directoryContents(temp))Files.delete(f);Files.delete(temp); }
        System.out.println("Успешно: "+count+" проверок");
    }
}
