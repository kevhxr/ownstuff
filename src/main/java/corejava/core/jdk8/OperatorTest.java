package corejava.core.jdk8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class OperatorTest {

    public static void main(String[] args) {
        testBinaryOperator(8, 2, (num1, num2) -> num1 / num2);
        testMinBy("hello", "wonders", Comparator.comparingInt(String::length));
        testMinBy("hello", "wonders", Comparator.comparingInt(str -> str.charAt(0)));
        testMaxBy("hello", "wonders", Comparator.comparingInt(String::length));
    }


    public static void testBinaryOperator(Integer num1,
                                          Integer num2,
                                          BinaryOperator<Integer> result) {
        System.out.println(result.apply(num1, num2));
    }

    public static void testMinBy(String str1,
                                 String str2,
                                 Comparator<String> comparator) {
        System.out.println(BinaryOperator.minBy(comparator).apply(str1, str2));
    }

    /**
     * 返回两者里面较大的一个
     *
     * @param str1
     * @param str2
     * @param comparator
     */
    public static void testMaxBy(String str1,
                                 String str2,
                                 Comparator<String> comparator) {
        System.out.println(BinaryOperator.maxBy(comparator).apply(str1, str2));
    }
}
