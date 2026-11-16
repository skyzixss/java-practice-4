package practice21;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;
public class Practice21 {
    public static <T> List<T> toList(T[] array) { return new ArrayList<>(Arrays.asList(array)); }
    public static List<Path> directoryContents(Path path) throws IOException {
        try (Stream<Path> files = Files.list(path)) { return files.sorted().toList(); }
    }
    public static List<Path> printFirstFive(Path path) throws IOException {
        List<Path> files = directoryContents(path);
        files.stream().limit(5).forEach(file -> System.out.println(file.getFileName())); return files;
    }
    public static void main(String[] args) {
        System.out.println("Задание 1: " + toList(new String[]{"Java", "Generics"}));
        System.out.println(toList(new Integer[]{1,2,3}));
        ArrayStorage<Integer> ints = new ArrayStorage<>(new Integer[]{10,20,30});
        ArrayStorage<Long> longs = new ArrayStorage<>(new Long[]{100L,200L});
        System.out.println("Задания 2–3: " + ints.get(1) + ", " + longs.get(0));
        System.out.println("Задание 4: первые 5 элементов каталога");
        try { printFirstFive(Path.of(args.length == 0 ? "." : args[0])); }
        catch (IOException | InvalidPathException e) { System.out.println("Ошибка каталога: " + e.getMessage()); }
        System.out.println("Задание 5: " + Solution.newArrayList(1,2,3));
        System.out.println(Solution.newHashSet("a","b","a"));
        System.out.println(Solution.newHashMap(Map.entry("one",1),Map.entry("two",2)));
    }
}
