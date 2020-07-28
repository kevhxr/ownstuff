package corejava.designmodel.proxy.performance;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 结论：  CGLIB 效率基本完败
 */

public class PerformanceTest {

    public static void main(String[] args) {

        Target cook = new CookService();

        Target jdkProxy = JdkProxyMaker.newProxyInstance(cook);
        WaiterService cglibProxy = CglibProxyMaker.newProxyInstance(WaiterService.class);

        //预热一下
/*        int preRunCount = 10000;
        runWithMonitor(cook, preRunCount,"native");
        runWithMonitor(cglibProxy, preRunCount,"cglib");
        runWithMonitor(jdkProxy, preRunCount,"jdk");*/

        //执行测试
        Map<String, Target> tests = new LinkedHashMap<>();
        //tests.put("Native   ", cook);
        tests.put("Jdk  ", jdkProxy);
        //tests.put("Cglib    ", cglibProxy);
        int repeatCount = 3;
        int runCount = 50000000;
        runTest(repeatCount, runCount, tests);
        runTestCGLib(repeatCount, runCount, cglibProxy);
    }

    private static void runTestCGLib(int repeatCount, int runCount, WaiterService target) {
        System.out.println(String.format("\n===== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] =====",
                repeatCount, runCount, System.getProperty("java.version")));
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            long start = System.currentTimeMillis();
            for (int j = 0; j < runCount; j++) {
                target.work(j);
            }
            long end = System.currentTimeMillis();
            System.out.println("[ Cglib ] Total Time:" + (end - start) + "ms");
        }
    }


    private static void runTest(int repeatCount, int runCount, Map<String, Target> tests) {
        System.out.println(String.format("\n===== run test : [repeatCount=%s] [runCount=%s] [java.version=%s] =====",
                repeatCount, runCount, System.getProperty("java.version")));
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n--------- test : [%s] ---------", (i + 1)));
            for (String key : tests.keySet()) {
                runWithMonitor(tests.get(key), runCount, key);
            }
        }
    }


    private static void runWithMonitor(Target target, int runCount, String tag) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            target.work(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + tag + "] Total Time:" + (end - start) + "ms");
    }
}
