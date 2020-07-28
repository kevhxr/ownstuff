package corejava.core.jdk8;

import org.junit.Test;

import java.util.function.Function;

public class FunctionTest {

    private static void numberToString(Function<Number, String> function) {
        String apply = function.apply(12);
        System.out.println("转换结果:" + apply);
    }

    /**
     * 先执行调用者，再执行参数，和compose相反。
     *
     * @param f1
     * @param f2
     */
    private static void method_andThen(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        Integer apply = f1.andThen(f2).apply(2);
        System.out.println(apply);
    }

    /**
     * 先执行参数，再执行调用者，和andThen相反。
     * 2*2 -> 4+1
     *
     * @param f1
     * @param f2
     */
    private static void method_compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        Integer apply = f1.compose(f2).apply(2);
        System.out.println(apply);
    }

    @Test
    public void identityTest() {
        Object apply = Function.identity().apply(2);
        System.out.println(apply);
    }

    public static void main(String[] args) {
        numberToString((s) -> String.valueOf(s));
    }

    private static void solution(
            Function<String, String> o1,
            Function<String, Integer> o2,
            Function<Integer, Integer> o3,
            String str) {
        Integer apply = o1.andThen(o2).andThen(o3).apply(str);
        System.out.println(apply);
    }

    @Test
    public void functionTest() {
        String str = "mia,20";
        solution(
                s -> s.split(",")[1],
                s -> Integer.parseInt(s),
                s -> s += 100,
                str);
    }

    @Test
    public void functionTest2() {
        numberToString((s) -> String.valueOf(s));
        method_andThen(s -> s + 1, s -> s = s * 2);
        method_compose(s -> s + 1, s -> s = s * s);
    }
}
