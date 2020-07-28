package corejava.core.jdk8;

import org.junit.Test;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void generateX(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    public static void main(String[] args) {
        generateX(s -> System.out.println(s));
    }

    @Test
    public void consumerTest() {
        formattorPersonMsg((s1) -> {
            for (int i = 0; i < s1.length; i++) {
                System.out.print(s1[i].split(",")[0] + " ");
            }
        }, (s2) -> {
            System.out.println();
            for (int i = 0; i < s2.length; i++) {
                System.out.print(s2[i].split(",")[1] + " ");
            }
        });
        System.out.println();
    }

    public static void formattorPersonMsg(Consumer<String[]> con1, Consumer<String[]> con2) {
        // con1.accept(new String[]{ "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" });
        // con2.accept(new String[]{ "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" });
        // 一句代码搞定
        con1.andThen(con2).accept(new String[]{"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"});
    }

    // 自身自销 有意思
    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) { // 这里每次产生 {迪丽热巴。性别：女 } String 数据 逻辑那边顺序处理就行
            one.andThen(two).accept(info); // 姓名：迪丽热巴。性别：女。 } }
        }
    }
}
