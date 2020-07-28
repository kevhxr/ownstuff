package corejava.core.jdk8;

import corejava.core.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredictableTest {

    private static void method_test(Predicate<String> predicate) {
        boolean b = predicate.test("OOM SOF");
        System.out.println(b);
    }

    // 判断字符串: 是否同时存在o h
    private static void method_and(Predicate<String> predicate1, Predicate<String> predicate2) {
        boolean b = predicate1.and(predicate2).test("OOM SOF");
        System.out.println(b);
    }

    //判断字符串: 存在o or h
    private static void method_or(Predicate<String> predicate1, Predicate<String> predicate2) {
        boolean b = predicate1.or(predicate2).test("OOM SOF");
        System.out.println(b);
    }

    // 判断字符串: 不存在o为真
    private static void method_negate(Predicate<String> predicate) {
        boolean b = predicate.negate().test("OOM SOF");
        System.out.println(b);
    }

    // 判断字符串: 不存在o为真
    private static void method_isEqual(Predicate<String> predicate) {
        boolean b = Predicate.isEqual(predicate).test(predicate);
        System.out.println(b);
    }

    @Test
    public void equalTest() {

        Student student = new Student(1, "s1");
        Predicate<Student> predicate = Predicate.isEqual(student);
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "zhangsan"));
        students.add(new Student(2, "lisi"));
        students.add(new Student(3, "wangwu"));
        students.add(new Student(4, "wangwu"));
        students.add(new Student(2, "lisi"));
        students.add(new Student(6, "zhangsan"));
        int a = (int) students.stream().filter(predicate).count();
        System.out.println(a);
        System.out.println(
                Stream.of(
                        new Student(1, "zhangsan"),
                        new Student(2, "lisi"),
                        new Student(3, "wangwu"),
                        new Student(4, "wangwu"),
                        new Student(2, "lisi"),
                        new Student(6, "zhangsan")
                )
                        .filter(predicate)
                        .count()
        );
    }


    public static void main(String[] args) {
        method_test((s) -> s.contains("O"));
        method_and(s -> s.contains("O"), s -> s.contains("h"));
        method_or(s -> s.contains("O"), s -> s.contains("h"));
        method_negate(s -> s.contains("O"));
    }

    private static void getFemaleAndName(Predicate<String> one,
                                         Predicate<String> two,
                                         String[] arr) {
        Arrays.stream(arr).forEach(string -> {
            if (one.and(two).test(string)) {
                System.out.println(string);
            }
        });
    }

    @Test
    public void predictTest() {
        String[] array = {"lisa,f", "sara,f", "lee,f", "lucy,f"};
        getFemaleAndName(
                ((s) -> s.split(",")[0].length() == 4),
                ((s) -> s.split(",")[1].equals("f")),
                array);
    }
}
