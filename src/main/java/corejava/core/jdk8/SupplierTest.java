package corejava.core.jdk8;

import org.junit.Test;

import java.util.function.Supplier;

public class SupplierTest {

    private static int getMax(Supplier<Integer> supply) {
        return supply.get();
    }

    @Test
    public void supplierMaxTest() {
        Integer[] data = new Integer[]{6, 5, 4, 3, 2, 1};
        int result = getMax(() -> {
            int max = 0;
            for (int i = 0; i < data.length; i++) {
                max = Math.max(max, data[i]);
            }
            return max;
        });
        System.out.println(result);
    }

    private static String test_Supplier(Supplier<String> supply) {
        //供应者接口
        return supply.get();
    }

    public static void main(String[] args) {
        // 产生的数据作为 sout 作为输出
        System.out.println(test_Supplier(
                () -> "产生数据"
                )
        );

        System.out.println(
                (new Supplier<String>() {
                    @Override
                    public String get() {
                        return "产生数据";
                    }
                }).get()
        );
    }
}
